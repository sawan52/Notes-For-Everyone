package com.sawankumarsingh.notesforeveryone.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sawankumarsingh.notesforeveryone.R;
import com.sawankumarsingh.notesforeveryone.activities.FetchNotesActivity;
import com.sawankumarsingh.notesforeveryone.classes.SubjectItems;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectsViewHolder> {

    private List<SubjectItems> subjectItemsList;
    private Context mContext;

    public SubjectAdapter(List<SubjectItems> subjectItemsList, Context mContext) {
        this.subjectItemsList = subjectItemsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SubjectAdapter.SubjectsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.list_items_subjects, viewGroup, false);
        return new SubjectsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final SubjectsViewHolder subjectsViewHolder, int position) {

        subjectsViewHolder.linearLayout.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

        subjectsViewHolder.subjectName.setText(subjectItemsList.get(position).getSubjectName());
        subjectsViewHolder.subjectUnit.setText(subjectItemsList.get(position).getSubjectUnit());

        subjectsViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String subjectName = subjectsViewHolder.subjectName.getText().toString();

                Intent intent = new Intent(mContext, FetchNotesActivity.class);
                intent.putExtra("SubjectName", subjectName);
                Toast.makeText(mContext, subjectName, Toast.LENGTH_SHORT).show();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectItemsList.size();
    }

    public static class SubjectsViewHolder extends RecyclerView.ViewHolder{

        TextView subjectName, subjectUnit;
        LinearLayout linearLayout;

        public SubjectsViewHolder(@NonNull View itemView) {
            super(itemView);

            subjectName = itemView.findViewById(R.id.subject_name);
            subjectUnit = itemView.findViewById(R.id.subject_unit);

            linearLayout = itemView.findViewById(R.id.container);

        }
    }
}
