package com.example.retrofitmvvmjava.Model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    Application application;
    User[]users;
    MutableLiveData<User[]> mutableLiveData;

    public UserRepository(Application application)
    {
        this.application = application;
    }
    public MutableLiveData<User[]> getUserData()
    {
        Call<User[]> call = RetrofitClient.getInstance().getMyApi().getUserData();
        call.enqueue(new Callback<User[]>() {

            @Override
            public void onResponse(Call<User[]> call, Response<User[]> response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                users = gson.fromJson(String.valueOf(response),User[].class);
                mutableLiveData.setValue(users);
            }

            @Override
            public void onFailure(Call<User[]> call, Throwable t) {

            }


        });
        return mutableLiveData;
    }


}
