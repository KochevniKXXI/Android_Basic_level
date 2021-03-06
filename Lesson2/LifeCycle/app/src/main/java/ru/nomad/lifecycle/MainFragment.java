package ru.nomad.lifecycle;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    final String TAG = this.getClass().getSimpleName();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Toast.makeText(context, "onAttache()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onAttache()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "???????????? ????????????! Fragment";
        } else {
            instanceState = "?????????????????? ????????????! Fragment";
        }
        Toast.makeText(getContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, instanceState + " - onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getContext(), "onCreateView()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreateView()");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "???????????? ????????????! Fragment";
        } else {
            instanceState = "?????????????????? ????????????! Fragment";
        }
        Toast.makeText(getContext(), instanceState + " - onActivityCreated()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, instanceState + " - onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "Fragment - onStart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Fragment - onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "Fragment - onResume()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Fragment - onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "Fragment - onPause()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Fragment - onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), "Fragment - onStop()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Fragment - onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "Fragment - onDestroyView()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Fragment - onDestroyView()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getContext(), "Fragment - onDetach()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Fragment - onDetach()");
    }
}