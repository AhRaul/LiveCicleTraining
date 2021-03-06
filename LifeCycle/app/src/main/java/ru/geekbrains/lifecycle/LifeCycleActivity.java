package ru.geekbrains.lifecycle;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String KEY = "Counter";
    private static final String TAG = "MyApp";

    private BlankFragment blancFragment;
    private int counter;                    // Счетчик

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        blancFragment = new BlankFragment();

        String instanceState;
        if (savedInstanceState == null)
            instanceState = "Первый запуск!";
        else
            instanceState = "Повторный запуск!";

        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, instanceState + " - onCreate()");

        // Получить Presenter
        final LifeCyclePresenter presenter = LifeCyclePresenter.getInstance();

        final TextView textCounter = findViewById(R.id.textCounter);     // Текст
        // Выводим счетчик в поле
        counter = presenter.getCounter();
        textCounter.setText(String.valueOf(counter));

        Button button = findViewById(R.id.button);         // Кнопка
        button.setOnClickListener(new View.OnClickListener() {      // Обработка нажатий
            @Override
            public void onClick(View v) {
                presenter.incrementCounter();   // Увеличиваем счетчик на единицу
                // Выводим счетчик в поле
                counter = presenter.getCounter();
                textCounter.setText(String.valueOf(counter));
            }
        });

        Button bAddFragment = findViewById(R.id.buttonAddFragment);
        bAddFragment.setOnClickListener(new ListenerOnAdd(blancFragment));

        Button bRemoveFragment = findViewById(R.id.buttonRemoveFragment);
        bRemoveFragment.setOnClickListener(new ListenerOnRemove(blancFragment));
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);

        saveInstanceState.putInt(KEY, counter);               // Сохраняем счетчик
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);

        counter = saveInstanceState.getInt(KEY);              // Восстанавливаем счетчик
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()",
                Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Повторный запуск!! - onRestoreInstanceState()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroy()");
    }

    private class ListenerOnAdd implements View.OnClickListener {

        private final Fragment fragment;

        private ListenerOnAdd(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            addFragment();
        }

        // Добавить фрагмент
        private void addFragment() {
            // открыть транзакцию
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            // добавить фрагмент
            fragmentTransaction.add(R.id.fragment_in_main, fragment);
            fragmentTransaction.addToBackStack("");
            // закрыть транзакцию
            fragmentTransaction.commit();
        }
    }
    private class ListenerOnRemove implements View.OnClickListener {

        private final Fragment fragment;

        private ListenerOnRemove(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            removeFragment();
        }

        // удалить фрагмент
        private void removeFragment() {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();
        }
    }
}
