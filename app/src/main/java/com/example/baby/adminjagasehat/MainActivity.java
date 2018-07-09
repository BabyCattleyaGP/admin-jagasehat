package com.example.baby.adminjagasehat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

        private RecyclerView recylerView;
        private List<UserModel> result;
        private UserAdapter adapter;

        private FirebaseDatabase database;
        private DatabaseReference reference;


        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            database = FirebaseDatabase.getInstance();
            reference = database.getReference("user");

            result = new ArrayList<>();

            recylerView = (RecyclerView) findViewById(R.id.user_list);
            recylerView.setHasFixedSize(true);
            LinearLayoutManager lin = new LinearLayoutManager(this);
            lin.setOrientation (LinearLayoutManager.VERTICAL);

            recylerView.setLayoutManager(lin);


            adapter = new UserAdapter(result);
            recylerView.setAdapter(adapter);

            updateList();
        }


        private void updateList(){
            reference.addChildEventListener(new ChildEventListener(){
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s){
                    result.add(dataSnapshot.getValue(UserModel.class));
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s){
                    UserModel model = dataSnapshot.getValue(UserModel.class);
                    int index = getItemIndex(model);

                    result.set(index, model);
                    adapter.notifyItemChanged(index);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot){
                    UserModel model = dataSnapshot.getValue(UserModel.class);
                    int index = getItemIndex(model);

                    result.remove(index);
                    adapter.notifyItemRemoved(index);
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s){
                }

                @Override
                public void onCancelled(DatabaseError databaseError){
                }
            });
        }

        private int getItemIndex(UserModel user){
            int index = -1;

            for (int i=0; i<result.size(); i++){
                if(result.get(i).key.equals(user.key)){
                    index = i;
                    break;
                }
            }

            return index;
        }
}