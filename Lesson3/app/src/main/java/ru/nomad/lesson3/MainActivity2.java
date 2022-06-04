package ru.nomad.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    public static final String NUMBER = "Number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Parcel parcel = (Parcel) getIntent().getExtras().getSerializable(MainActivity.EXTRA_CLASS);
        final Button button = findViewById(R.id.button_back);
        final TextView textView = findViewById(R.id.text_view);
        final EditText editText = findViewById(R.id.edit_text3);
        final TextView textView1 = findViewById(R.id.text_view3);

        String text = getIntent().getExtras().getString(MainActivity.EXTRA_TEXT);
        textView.setText(text);
        textView1.setText(parcel.text);
        editText.setText(((Integer) parcel.number).toString());

        button.setOnClickListener(v -> {
            switch (v.getId()) {
                case R.id.button_back:
                    Intent intentResult = new Intent();
                    intentResult.putExtra(NUMBER, editText.getText().toString());
                    setResult(Activity.RESULT_OK, intentResult);
                    finish();
                    break;
                default:
                    break;
            }
        });
        Toast.makeText(getApplicationContext(),"Second - onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Second - onStart()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Second - onResume()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Second - onPause()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Second - onStop()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Second - onRestart()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Second - onDestroy()", Toast.LENGTH_SHORT).show();
    }

}