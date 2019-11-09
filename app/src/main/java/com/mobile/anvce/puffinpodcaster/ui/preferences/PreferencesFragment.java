package com.mobile.anvce.puffinpodcaster.ui.preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.enums.PodcastUpdateFrequency;
import com.mobile.anvce.puffinpodcaster.enums.PodcastUpdateFrequency.PodcastUpdateFrequencyVisitor;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.sync.PodcastsSyncUtils;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class PreferencesFragment extends Fragment implements PuffinPodcasterConstants {

    private PreferencesViewModel viewModel;
    // Shared preferences object
    private SharedPreferences mPreferences;
    private String selectedRegion = "USA";
    private boolean notificationEnabled = true;
    private Spinner spinner;
    private Switch notificationSwitch;
    private String selectedUpdateFrequency = PodcastUpdateFrequency.EVERY_DAY.name();
    private RadioGroup updateFrequencyRadioGroup;
    private TextView updateFrequencyLabelSubView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mPreferences = Objects.requireNonNull(getActivity()).getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        viewModel =
                ViewModelProviders.of(this).get(PreferencesViewModel.class);

        View root = inflater.inflate(R.layout.fragment_preferences, container, false);
        final TextView textView = root.findViewById(R.id.text_preferences);
        viewModel.getText().observe(this, s -> textView.setText(""));

        initializeSpinnerForRegions(root);
        initializeNotificationSwitch(root);
        initializeUpdateFrequencySubTextDescription(root);
        initializeUpdateFrequency(root);
        return root;
    }

    private void initializeUpdateFrequencySubTextDescription(View root) {
        updateFrequencyLabelSubView = root.findViewById(R.id.updateFrequencyLabelSub);
        String subText = "( " + getString(R.string.updateFrequencyLabaelSubText) + " Every Day )";
        updateFrequencyLabelSubView.setText(subText);
    }

    private void initializeUpdateFrequency(View root) {
        updateFrequencyRadioGroup = root.findViewById(R.id.updateFrequencyRadioGroup);
        updateFrequencyRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            String baseSubText = getString(R.string.updateFrequencyLabaelSubText);
            // find which radio button is selected
            if (checkedId == R.id.eightHour) {
                selectedUpdateFrequency = PodcastUpdateFrequency.EIGHT_HOUR.name();
                saveUserSelection(PuffinPodcasterConstants.PREF_FREQUENCY_UPDATE_KEY, selectedUpdateFrequency);
                PodcastsSyncUtils.scheduleFirebaseJobDispatcherSync(getContext(), PodcastUpdateFrequency.EIGHT_HOUR);
                updateFrequencyLabelSubView.setText("( " + baseSubText + " Every  Eight Hour )");
            } else if (checkedId == R.id.everyDay) {
                selectedUpdateFrequency = PodcastUpdateFrequency.EVERY_DAY.name();
                saveUserSelection(PuffinPodcasterConstants.PREF_FREQUENCY_UPDATE_KEY, selectedUpdateFrequency);
                PodcastsSyncUtils.scheduleFirebaseJobDispatcherSync(getContext(), PodcastUpdateFrequency.EVERY_DAY);
                updateFrequencyLabelSubView.setText("( " + baseSubText + " Every Day )");
            } else {
                selectedUpdateFrequency = PodcastUpdateFrequency.WEEKLY.name();
                saveUserSelection(PuffinPodcasterConstants.PREF_FREQUENCY_UPDATE_KEY, selectedUpdateFrequency);
                PodcastsSyncUtils.scheduleFirebaseJobDispatcherSync(getContext(), PodcastUpdateFrequency.WEEKLY);
                updateFrequencyLabelSubView.setText("( " + baseSubText + " Weekly )");
            }
        });
    }

    private void initializeSpinnerForRegions(View root) {
        spinner = root.findViewById(R.id.regionSpinner);
        viewModel.getRegionList().observe(this, strings -> {
            // Creating adapters for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, strings);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapters to spinner
            spinner.setAdapter(dataAdapter);

        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                selectedRegion = (String) parent.getItemAtPosition(pos);
                resetSharedPrefrenceForPopularPodcastsAsRegionChanged(selectedRegion);
                saveUserSelection(PuffinPodcasterConstants.PREF_REGION_KEY, selectedRegion);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });
    }

    private void resetSharedPrefrenceForPopularPodcastsAsRegionChanged(@NonNull String region) {
        if (mPreferences.contains(PREF_REGION_KEY)) {
            String storedRegion = mPreferences.getString(PREF_REGION_KEY, "USA");
            if (!storedRegion.equalsIgnoreCase(region)) {
                saveUserSelection(PuffinPodcasterConstants.PREF_POPULAR_PODCAST_KEY, "");
            }
        }

    }

    private void initializeNotificationSwitch(View root) {
        notificationSwitch = root.findViewById(R.id.notificationSwitch);
        notificationSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            notificationEnabled = isChecked;
            saveUserSelection(PREF_NOTIFICATION_ENABLED_KEY, isChecked);
        });
    }

    private void saveUserSelection(String key, String selection) {
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(key, selection);
        preferencesEditor.apply();
    }

    private void saveUserSelection(String key, boolean selection) {
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putBoolean(key, selection);
        preferencesEditor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        restoreSharedPreferenceRegion(PREF_REGION_KEY);
        spinner.setSelection(viewModel.buildRegionList().indexOf(selectedRegion));
        restoreSharedPreferenceNotification(PREF_NOTIFICATION_ENABLED_KEY);
        notificationSwitch.setChecked(notificationEnabled);
        restoreSharedPreferenceUpdateFrequency(PREF_FREQUENCY_UPDATE_KEY);
        updateFrequencyRadioGroup.check(getUserSelectedFrquencyOption());
    }

    private int getUserSelectedFrquencyOption() {
        PodcastUpdateFrequency updateFrequency = PodcastUpdateFrequency.fromString(selectedUpdateFrequency);
        return updateFrequency.acceptVisitor(new UpdateFrequencyHandler());
    }

    // Restore preference Region
    private void restoreSharedPreferenceRegion(final String key) {
        if (mPreferences.contains(key)) {
            String prefRegion = mPreferences.getString(key, "");
            if (!TextUtils.isEmpty(prefRegion)) {
                selectedRegion = prefRegion;
            }
        }
    }

    // Restore preference Notification switch
    private void restoreSharedPreferenceNotification(final String key) {
        notificationEnabled = mPreferences.getBoolean(key, true);
    }

    // Restore preference update frequency
    private void restoreSharedPreferenceUpdateFrequency(final String key) {
        if (mPreferences.contains(key)) {
            String prefFrequency = mPreferences.getString(key, "");
            if (!TextUtils.isEmpty(prefFrequency)) {
                selectedUpdateFrequency = prefFrequency;
            }
        }
    }

    private class UpdateFrequencyHandler implements PodcastUpdateFrequencyVisitor<Void, Integer> {

        @Override
        public Integer visitEightHour(Void input) {
            return R.id.eightHour;
        }

        @Override
        public Integer visitEveryDay(Void input) {
            return R.id.everyDay;
        }

        @Override
        public Integer visitWeekly(Void input) {
            return R.id.weekly;
        }
    }

}