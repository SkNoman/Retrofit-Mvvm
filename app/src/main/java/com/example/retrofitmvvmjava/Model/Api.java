package com.example.retrofitmvvmjava.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://api.github.com/";
   @GET("users")
   Call<User[]> getUserData();
}
