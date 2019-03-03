package ru.geekbrains.lifecycle;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private static final String TAG_FRAG_1 = "MyFrag1 ";

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG_FRAG_1, "onCreateView()");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG_FRAG_1, "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG_FRAG_1, "onCreate()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG_FRAG_1, "onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG_FRAG_1, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG_FRAG_1, "onResume()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG_FRAG_1, "onSaveInstanceState()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG_FRAG_1, "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG_FRAG_1, "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG_FRAG_1, "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG_FRAG_1, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG_FRAG_1, "onDetach()");
    }
}
