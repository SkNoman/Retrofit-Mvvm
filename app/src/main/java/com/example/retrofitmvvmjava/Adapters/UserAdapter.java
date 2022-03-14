package com.example.retrofitmvvmjava.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.retrofitmvvmjava.Model.UserModel;
import com.example.retrofitmvvmjava.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context context;
    private List<UserModel> userList;


    public UserAdapter(Context context,List<UserModel> userList)
    {
           this.context = context;
           this.userList = userList;
    }
    public void setUserList(List<UserModel> userList)
    {
        this.userList = userList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override


    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.layout_users_list,viewGroup,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        holder.name.setText(this.userList.get(position).getLogin().toString());
        holder.id.setText(String.valueOf(this.userList.get(position).getId()));
        holder.resposUrl.setText(this.userList.get(position).getReposUrl().toString());
        Glide.with(context).load(this.userList.get(position).getAvatarUrl()).apply(RequestOptions.centerCropTransform()).into(holder.avatarImg);
    }

    @Override
    public int getItemCount() {
        if (this.userList != null)
        {
            return this.userList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView avatarImg;
        TextView name,id,resposUrl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImg = itemView.findViewById(R.id.ivAvatar);
            name = itemView.findViewById(R.id.tvName);
            id = itemView.findViewById(R.id.tvId);
            resposUrl = itemView.findViewById(R.id.tvReposUrl);
        }
    }
}
