package net.syarihu.android.viewmodeltest;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.syarihu.android.viewmodeltest.databinding.FragmentABinding;
import net.syarihu.android.viewmodeltest.viewmodel.SharedViewModel;

public class FragmentA extends LifecycleFragment {
    private SharedViewModel model;
    private FragmentABinding binding;

    public static FragmentA newInstance() {
        return new FragmentA();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_a, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        binding.button1.setOnClickListener((View.OnClickListener) getActivity());
        binding.editText.setText(model.getSelected().getValue());
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                model.select(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
