package com.example.retrofitmvvmjava.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.retrofitmvvmjava.Model.UserModel;
import com.example.retrofitmvvmjava.R;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name,id,link,gravatarId,followersLink;
    UserModel userModel = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.ivAvatar);
        name = findViewById(R.id.tvName);
        id = findViewById(R.id.tvId);
        link = findViewById(R.id.tvReposUrl);
        followersLink = findViewById(R.id.followersUrl);
        gravatarId = findViewById(R.id.gravaterId);
        final Object object = getIntent().getSerializableExtra("detail");
        if (object instanceof UserModel){
            userModel = (UserModel) object;
        }
        if (userModel != null)
        {
            name.setText("Name: "+userModel.getLogin());
            id.setText("Id: "+String.valueOf(userModel.getId()));
            link.setText("Link: "+userModel.getReposUrl());
            gravatarId.setText("Link: "+userModel.getUrl());
            followersLink.setText("Type: "+userModel.getType());
            //Glide.with(getApplicationContext()).load(this.userModel.get(position).getAvatarUrl()).apply(RequestOptions.centerCropTransform()).into(holder.avatarImg);
            Glide.with(getApplicationContext()).load(userModel.getAvatarUrl()).into(imageView);
        }


    }
}