package com.example.myflexiblefragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailCategoryFragment extends Fragment implements View.OnClickListener{
    private TextView tvCategoryName, tvCategoryDesc;
    private Button btnProfile, btnShowDialog;
    public static String EXTRA_NAME = "extra_name";
    private String desc;

    public DetailCategoryFragment() {
        // Required empty public constructor
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        View view = inflater.inflate(R.layout.fragment_detail_category, container, false);
        tvCategoryName = (TextView)view.findViewById(R.id.tv_category_description);
        tvCategoryDesc = (TextView)view.findViewById(R.id.tv_category_description);
        btnProfile     = (Button)view.findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(this);
        btnShowDialog  = (Button)view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        assert getArguments() != null;
        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        tvCategoryDesc.setText(getDesc());
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_profile:
                break;
            case R.id.btn_show_dialog:
                OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();
                mOptionDialogFragment.setOnOptionDialogListener(new OptionDialogFragment.OnOptionDialogListener() {
                @Override
                public void onOptionChoosen(String text) {
                       Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
                }});
                FragmentManager mFragmentManager = getChildFragmentManager();
                mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
                break;
        }
    }
}