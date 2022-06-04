package ru.nomad.lesson3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER_KEY = "CounterKey";
    public static final String EXTRA_TEXT = "ExtraText";
    public static final String EXTRA_CLASS = "ExtraClass";
    public static final int REQUEST_CODE = 13;
    private int increment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            increment = savedInstanceState.getInt(COUNTER_KEY);
        }

        final TextView textCounter = findViewById(R.id.text_counter);
        final Button button = findViewById(R.id.button);
        final Button button1 = findViewById(R.id.button_to_second);
        final EditText editText = findViewById(R.id.edit_text);
        final EditText editNumber = findViewById(R.id.edit_text2);

        textCounter.setText("Inc " + increment);
        button.setOnClickListener(v -> {
            increment++;
            textCounter.setText("Inc " + increment);
        });

        button1.setOnClickListener(v -> {
            Parcel parcel = new Parcel();
            parcel.text = editText.getText().toString();
            parcel.number = Integer.parseInt(editNumber.getText().toString());
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra(EXTRA_TEXT, editText.getText().toString());
            intent.putExtra(EXTRA_CLASS, parcel);
            startActivityForResult(intent, REQUEST_CODE);
        });
        Toast.makeText(getApplicationContext(),"Main - onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            EditText editNumber = findViewById(R.id.edit_text2);
            editNumber.setText(data.getStringExtra(MainActivity2.NUMBER));
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_KEY, increment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Main - onStart()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Main - onResume()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Main - onPause()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Main - onStop()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Main - onRestart()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Main - onDestroy()", Toast.LENGTH_SHORT).show();
    }
}