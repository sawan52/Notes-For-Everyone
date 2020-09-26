package com.sawankumarsingh.notesforeveryone.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sawankumarsingh.notesforeveryone.R;
import com.sawankumarsingh.notesforeveryone.adapters.SubjectAdapter;
import com.sawankumarsingh.notesforeveryone.classes.SubjectItems;

import java.util.ArrayList;
import java.util.List;

public class SecondYearFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<SubjectItems> subjectItemsList;

    public SecondYearFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.second_year_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_second_year_subjects);

        SubjectAdapter subjectAdapter = new SubjectAdapter(subjectItemsList, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(subjectAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        subjectItemsList = new ArrayList<>();

        // 3rd Semester Subjects
        subjectItemsList.add(new SubjectItems("Computer Organisation", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Discrete Mathematics", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Digital Logic Design", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Data Structure", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Human Values", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Mathematics 3", "Unit 1-5"));

        // 4th Semester Subjects
        subjectItemsList.add(new SubjectItems("Linear Algebra", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Microprocessor", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Operating System", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Software Engineering", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Theory of Automata and Formal Languages", "Unit 1-5"));
        subjectItemsList.add(new SubjectItems("Environment Ecology", "Unit 1-5"));

    }
}

