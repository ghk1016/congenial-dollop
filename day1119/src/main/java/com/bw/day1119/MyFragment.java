package com.bw.day1119;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyFragment extends Fragment {


    private static final String TAG = "MyFragment";
    private View inflate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "......................onCreate: ");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_my, container, false);
        Log.d(TAG, "........................onCreateView: ");
        return inflate;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "....................onPause: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "................onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "...................onDestroy: ");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "....................onAttach: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "......................onStop: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, ".........................onResume: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "..........................onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "....................................onStart: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, ".....................................onDetach: ");
    }
}
