package com.example.baby.adminjagasehat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    
    private List<UserModel> list;

    public UserAdapter(List<UserModel> list){
        this.list = list;
    }
    
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item,parent,false));
    }

    @Override
    public void onBindViewHolder (final UserViewHolder holder, int position){
        UserModel user = list.get(position);

        holder.textEmail.setText(user.emailUser);
        holder.textAge.setText(user.usiaUser + "");
        holder.textJob.setText(user.kerjaUser);

    }

    @Override
    public int getItemCount(){
        return list.size();
    }
    
    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView textEmail, textJob, textAge;
        
        public UserViewHolder (View itemView){
             super(itemView);

             textAge = (TextView) itemView.findViewById(R.id.text_age);
             textEmail = (TextView) itemView.findViewById(R.id.text_email);
             textJob = (TextView) itemView.findViewById(R.id.text_job);
        }
    }
}