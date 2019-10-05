package com.example.myfragmentapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCategoryFragment extends Fragment implements View.OnClickListener{

    private TextView tvCategoryName;
    private TextView tvCategoryDescription;
    public static String EXTRA_NAME = "extra_name";
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DetailCategoryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_category, container, false);
        tvCategoryName = view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = view.findViewById(R.id.tv_category_decription);
        Button btnProfile = view.findViewById(R.id.btn_profile);
        Button btnShowDialog = view.findViewById(R.id.btn_show_dialog);

        btnProfile.setOnClickListener(this);
        btnShowDialog.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        tvCategoryDescription.setText(getDescription());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_profile : {
                Intent profileActivity = new Intent(getActivity(), ProfileActivity.class);
                startActivity(profileActivity);
                break;
            }
            case R.id.btn_show_dialog : {
                OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();
                mOptionDialogFragment.setOnOptionDialogListener(new OptionDialogFragment.OnOptionDialogListener() {
                    @Override
                    public void onOptionChoosen(String text) {
                        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
                    }
                });

                FragmentManager mFragmentManager = getChildFragmentManager();
                mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
                break;
            }
        }

    }
}
