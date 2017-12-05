package com.example.iqbalfauzip.kontak.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Iqbal Fauzi P on 25/11/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "http://192.168.230.116:8080/rest_android/index.php/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
