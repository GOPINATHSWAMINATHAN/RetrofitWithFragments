package com.hlacab.retrofitwithfragments.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gopinath on 08/12/17.
 */

public interface RequestInterface {

public static String BASE_URL="https://simplifiedcoding.net/demos/";

@GET("marvel")
    Call<List<DemoModel>> getHeroes();
}
