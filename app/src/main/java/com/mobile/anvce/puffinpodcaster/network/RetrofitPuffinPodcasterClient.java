package com.mobile.anvce.puffinpodcaster.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobile.anvce.puffinpodcaster.BuildConfig;

import org.jetbrains.annotations.NotNull;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit instance for podcaster project.
 */

public class RetrofitPuffinPodcasterClient {

	private static Retrofit retrofit;

	public static Retrofit getRetrofitInstance() {

		HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
		loggingInterceptor.setLevel(Level.BODY);

		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
			@NotNull
			@Override
			public Response intercept(@NotNull Chain chain) throws IOException {
				Request originalRequest = chain.request();
				Request newRequest = originalRequest.newBuilder().header("Accept","application/json").addHeader("Content-Type", "application/json").addHeader("X-ListenAPI-Key", BuildConfig.LISTENING_API_KEY).build();
				return chain.proceed(newRequest);
			}
		}).addInterceptor(loggingInterceptor).build();

		Gson gson = new GsonBuilder().serializeNulls()
				.setLenient()
				.create();

		if (retrofit == null) {
			retrofit = new retrofit2.Retrofit.Builder()
					.client(okHttpClient)
					.baseUrl(BuildConfig.PODCAST_SERVICE_BASE_URL)
					.addConverterFactory(GsonConverterFactory.create(gson))
					.build();
		}
		return retrofit;
	}

}
