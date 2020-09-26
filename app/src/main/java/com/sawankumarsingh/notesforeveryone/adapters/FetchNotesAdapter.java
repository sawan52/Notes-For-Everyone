package com.sawankumarsingh.notesforeveryone.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.sawankumarsingh.notesforeveryone.R;

import java.util.ArrayList;

public class FetchNotesAdapter extends RecyclerView.Adapter<FetchNotesAdapter.FetchNotesViewHolder> {

    private RecyclerView recyclerView;
    private Context context;
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<String> urls = new ArrayList<>();

    public FetchNotesAdapter(RecyclerView recyclerView, Context context, ArrayList<String> items, ArrayList<String> urls) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.items = items;
        this.urls = urls;
    }

    @NonNull
    @Override
    public FetchNotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_fetch, viewGroup, false);
        return new FetchNotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FetchNotesViewHolder fetchNotesViewHolder, int position) {

        fetchNotesViewHolder.cardView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));

        fetchNotesViewHolder.fileName.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void update(String name, String url) {
        items.add(name);
        urls.add(url);
        notifyDataSetChanged();
    }

    public class FetchNotesViewHolder extends RecyclerView.ViewHolder {

        TextView fileName;
        CardView cardView;

        public FetchNotesViewHolder(View itemView) {
            super(itemView);

            fileName = itemView.findViewById(R.id.pdf_file_name);
            cardView = itemView.findViewById(R.id.myCardView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = recyclerView.getChildLayoutPosition(view); // return the position of selected file
                    Intent intent = new Intent();

                    intent.setType(Intent.ACTION_VIEW);

                    intent.setDataAndType(Uri.parse(urls.get(position)), "application/pdf");

                    context.startActivity(intent);
                }
            });
        }
    }
}

