package droid.demos.com.preferences.views;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import droid.demos.com.preferences.R;
import droid.demos.com.preferences.fragments.FragmentA;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragmentA();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 1) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    private void showFragmentA() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        FragmentA fragmentA = new FragmentA();

        transaction.addToBackStack(FragmentA.TAG);
        transaction.add(R.id.conteinerFragments, fragmentA, FragmentA.TAG).commit();
    }

}
