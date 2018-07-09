package com.example.baby.adminjagasehat;

import android.content.Intent;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Map;



public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context context;
    private List<UserModel> list;

    public UserAdapter(Context context, List<UserModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item,parent,false));
    }


    @Override
    public void onBindViewHolder (@NonNull UserViewHolder holder, int position){
        UserModel user = list.get(position);

        holder.textEmail.setText(user.emailUser);
        holder.textAge.setText(user.usiaUser + "");
        holder.textJob.setText(user.kerjaUser);

        holder.rvLayoutUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(IntentKeys.USER_ID, user.ID);
                intent.putExtra(IntentKeys.USER_KERJA, user.kerjaUser);
                intent.putExtra(IntentKeys.USER_PENDIDIKAN, user.tpUser);
                intent.putExtra(IntentKeys.USER_EMAIL, user.emailUser);
                intent.putExtra(IntentKeys.USER_JK, user.jkUser);
                intent.putExtra(IntentKeys.USER_UMUR, user.usiaUser);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return list.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView textEmail, textJob, textAge;
        RelativeLayout rvLayoutUser;

        public UserViewHolder (View itemView){
            super(itemView);

            rvLayoutUser = (RelativeLayout) itemView.findViewById(R.id.layout_user);
            textAge = (TextView) itemView.findViewById(R.id.text_age);
            textEmail = (TextView) itemView.findViewById(R.id.text_email);
            textJob = (TextView) itemView.findViewById(R.id.text_job);
        }
    }
}