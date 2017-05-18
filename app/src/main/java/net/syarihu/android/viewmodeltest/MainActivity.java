package net.syarihu.android.viewmodeltest;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;

import net.syarihu.android.viewmodeltest.viewmodel.SharedViewModel;

public class MainActivity extends LifecycleActivity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewModelProviders.of(this).get(SharedViewModel.class);
        replaceFragment(FragmentA.newInstance());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            replaceFragment(FragmentB.newInstance());
        } else {
            replaceFragment(FragmentA.newInstance());
        }
    }

    public void replaceFragment(LifecycleFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.content, fragment)
                .commit();
    }

}
