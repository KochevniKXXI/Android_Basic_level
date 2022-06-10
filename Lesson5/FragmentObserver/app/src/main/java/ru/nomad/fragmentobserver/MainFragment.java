package ru.nomad.fragmentobserver;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    private Publisher publisher; // Обработчик подписок

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        publisher = ((PublishGetter) context).getPublisher(); // получим обработчика подписок
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container,
                false);
        final EditText textView = view.findViewById(R.id.editText);
        Button button = view.findViewById(R.id.button); // По этой кнопке будем отправлять события
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textView.getText().toString();
                publisher.notify(text); // Отправить изменившуюся строку
            }
        });
        return view;
    }
}