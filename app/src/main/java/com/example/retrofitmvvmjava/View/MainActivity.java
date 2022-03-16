package com.example.retrofitmvvmjava.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.retrofitmvvmjava.Adapters.UserAdapter;
import com.example.retrofitmvvmjava.Model.UserModel;
import com.example.retrofitmvvmjava.R;
import com.example.retrofitmvvmjava.ViewModel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

   /* private List<UserModel> userModelList;
    private UserAdapter adapter;
    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("List of users");
        setContentView(R.layout.activity_main);
       /* recyclerView = findViewById(R.id.recyclerView);
        // LinearLayoutManager layoutManager = new GridLayoutManager(this,1); //for in grid
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // single view recycleerView.
        //recyclerView.setLayoutManager(layoutManager);
        UserAdapter adapter = new UserAdapter(this,userModelList);
        recyclerView.setAdapter(adapter);

        mainActivityViewModel =  new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getUsersListObserver().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) { //if data changes fire this function
                if (userModels != null)
                {
                    userModelList = userModels;
                    adapter.setUserList(userModels);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "No Result Found!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mainActivityViewModel.makeApiCall();*/


    }
}