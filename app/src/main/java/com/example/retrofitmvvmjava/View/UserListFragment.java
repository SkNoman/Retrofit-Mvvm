package com.example.retrofitmvvmjava.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrofitmvvmjava.Adapters.UserAdapter;
import com.example.retrofitmvvmjava.Model.UserModel;
import com.example.retrofitmvvmjava.R;
import com.example.retrofitmvvmjava.ViewModel.MainActivityViewModel;

import java.util.List;

public class UserListFragment extends Fragment {
    private List<UserModel> userModelList;
    private UserAdapter adapter;
    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;
;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_list, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);
        Button button = view.findViewById(R.id.btn_Details_View);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                navController.navigate(R.id.action_userListFragment_to_userDetailsView);
            }
        });

        recyclerView = view.findViewById(R.id.recyclerView);
        // LinearLayoutManager layoutManager = new GridLayoutManager(this,1); //for in grid
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); // single view recycleView.
        //recyclerView.setLayoutManager(layoutManager);
        UserAdapter adapter = new UserAdapter(getContext(),userModelList);
        recyclerView.setAdapter(adapter);

        mainActivityViewModel =  new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getUsersListObserver().observe(getViewLifecycleOwner(), new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) { //if data changes fire this function
                if (userModels != null)
                {
                    userModelList = userModels;
                    adapter.setUserList(userModels);
                }
                else
                {

                    Toast.makeText(getActivity(),"No Result Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mainActivityViewModel.makeApiCall();

    }
}