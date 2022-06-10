package ru.nomad.cityinfo;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// Это activity для портретной реализации
public class CoatOfArmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            // Если устройство перевернули в альбомную ориентацию, то надо эту activity закрыть
            finish();
            return;
        }
        if (savedInstanceState == null) {
            // Если эта activity запускается первый раз (с каждым новым гербом первый раз)
            // то перенаправим параметр фрагменту
            CoatOfArmsFragment details = new CoatOfArmsFragment();
            details.setArguments(getIntent().getExtras());
            // Добавим фрагмент на activity
//            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }

    }
}