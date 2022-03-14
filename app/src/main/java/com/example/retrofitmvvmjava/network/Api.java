package com.example.retrofitmvvmjava.network;

import com.example.retrofitmvvmjava.Model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("users")
    Call<List<UserModel>> getUserList();

}
