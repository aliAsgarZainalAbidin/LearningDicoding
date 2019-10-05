package com.example.myfragmentapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
        Button btnDetailCategory1 = view.findViewById(R.id.btn_detail_category1);

        btnDetailCategory.setOnClickListener(this);
        btnDetailCategory1.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_detail_category : {
                DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();

                Bundle mBundle = new Bundle();
                mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");

                String description = "Kategory ini akan berisi produk-produk lifestyle";
                mDetailCategoryFragment.setArguments(mBundle);
                mDetailCategoryFragment.setDescription(description);

                FragmentManager mFragmentManager = getFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame_container, mDetailCategoryFragment, mDetailCategoryFragment.getClass().getSimpleName());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;
            }

            case R.id.btn_detail_category1 : {
                DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();

                Bundle mBundle = new Bundle();
                mBundle.putString(mDetailCategoryFragment.EXTRA_NAME, "Kategori Makanan");
                mDetailCategoryFragment.setArguments(mBundle);

                mDetailCategoryFragment.setDescription("Ini Detail Category Fragment Makanan");

                FragmentManager mFragmentManager = getFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame_container, mDetailCategoryFragment, mDetailCategoryFragment.getClass().getSimpleName());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;
            }
        }
    }
}
