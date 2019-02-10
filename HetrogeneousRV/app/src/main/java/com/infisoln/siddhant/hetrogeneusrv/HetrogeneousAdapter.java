package com.infisoln.siddhant.hetrogeneusrv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HetrogeneousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Object> arrayList;

    HetrogeneousAdapter(ArrayList<Object> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getItemViewType(int position) {
        Object currentObject = arrayList.get(position);

        if (currentObject instanceof ImageClass) {
            return 0;
        } else if (currentObject instanceof TextClass) {
            return 1;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());

        if (i == 0) {
            View view = li.inflate(R.layout.layout_row_image, viewGroup, false);
            return new ImageHolder(view);
        } else if (i == 1) {
            View view = li.inflate(R.layout.layout_row_text, viewGroup, false);
            return new TextHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int viewType = getItemViewType(i);
        if (viewType == 0) {
            ImageClass imageClass = (ImageClass) arrayList.get(i);
            ImageHolder imageHolder = (ImageHolder) viewHolder;

            imageHolder.title.setText(imageClass.getTitle());
            imageHolder.subtitle.setText(imageClass.getSubtitle());

            Picasso.get()
                    .load(imageClass.getUrl())
                    .placeholder(R.drawable.broken_image)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageHolder.imageView);

        } else if (viewType == 1) {
            TextClass textClass = (TextClass) arrayList.get(i);
            TextHolder textHolder = (TextHolder) viewHolder;

            textHolder.title.setText(textClass.getTitile());
            textHolder.subtitle.setText(textClass.getSubititle());
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;
        ImageView imageView;

        ImageHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitleImage);
            subtitle = itemView.findViewById(R.id.tvSubtitleImage);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    class TextHolder extends RecyclerView.ViewHolder {

        TextView title, subtitle;

        TextHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            subtitle = itemView.findViewById(R.id.tvSubtitle);
        }
    }

}
