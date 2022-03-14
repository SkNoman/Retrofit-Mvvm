package com.example.retrofitmvvmjava.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitmvvmjava.Model.UserModel;
import com.example.retrofitmvvmjava.network.Api;
import com.example.retrofitmvvmjava.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<UserModel>> usersList;

    public  MainActivityViewModel()
    {
        usersList =new  MutableLiveData<>();
    }
    public  MutableLiveData<List<UserModel>> getUsersListObserver()
    {
        return usersList;
    }
    public  void makeApiCall()
    {
        Api api = RetrofitClient.getRetrofitClient().create(Api.class);
        Call<List<UserModel>> call = api.getUserList();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                usersList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                usersList.postValue(null);
            }
        });
    }




}
