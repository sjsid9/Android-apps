package com.infisoln.siddhant.asynctask_networking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubHolder> {

    ArrayList<Item> itemArrayList;

    public GithubAdapter(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public GithubHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      LayoutInflater li =  LayoutInflater.from(viewGroup.getContext());
      View view = li.inflate(R.layout.layout_row,viewGroup,false);
      return new GithubHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubHolder githubHolder, int i) {

        Item currentItem = itemArrayList.get(i);

        githubHolder.tvName.setText(currentItem.getLogin());
        Picasso.get().load(currentItem.getAvatr_url()).into(githubHolder.userImage);

    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    class GithubHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        ImageView userImage;

        public GithubHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            userImage = itemView.findViewById(R.id.ivUserImage);

        }
    }

}
