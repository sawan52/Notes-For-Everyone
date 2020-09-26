package com.sawankumarsingh.notesforeveryone.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sawankumarsingh.notesforeveryone.R;
import com.sawankumarsingh.notesforeveryone.activities.FetchNotesActivity;
import com.sawankumarsingh.notesforeveryone.adapters.SubjectAdapter;
import com.sawankumarsingh.notesforeveryone.classes.SubjectItems;

import java.util.ArrayList;
import java.util.List;

public class ThirdYearFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private List<SubjectItems> subjectItemsList;


    public ThirdYearFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.third_year_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_third_year_subjects);

        SubjectAdapter subjectAdapter = new SubjectAdapter(subjectItemsList, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(subjectAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        subjectItemsList = new ArrayList<>();

        // 5rd Semester Subjects
        subjectItemsList.add(new SubjectItems("Computer Graphics", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Compiler Design", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Design and Development of Applications", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Computer Network", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Sociology", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Industrial Management", "Unit 1-5"));

        // 6th Semester Subjects
//        subjectItemsList.add(new SubjectItems("Linear Algebra", "Unit 1-5"));
//        subjectItemsList.add(new SubjectItems("Microprocessor", "Unit 1-5"));
//        subjectItemsList.add(new SubjectItems("Operating System", "Unit 1-5"));
//        subjectItemsList.add(new SubjectItems("Software Engineering", "Unit 1-5"));
//        subjectItemsList.add(new SubjectItems("Theory of Automata and Formal Languages", "Unit 1-5"));
//        subjectItemsList.add(new SubjectItems("Environment Ecology", "Unit 1-5"));

    }
}

