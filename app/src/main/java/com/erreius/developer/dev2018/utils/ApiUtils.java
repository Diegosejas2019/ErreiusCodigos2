package com.erreius.developer.dev2018.utils;

import com.erreius.developer.dev2018.interfaces.APIService;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://appcodigosservicios.erreius.com/api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
