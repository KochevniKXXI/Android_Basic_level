package ru.nomad.fragmentobserver;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment implements Observer {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        textView = view.findViewById(R.id.textView);
        return view;
    }

    // Как только пришло событие - обработаем его
    @Override
    public void updateText(String text) {
        textView.setText(text);
    }
}