package com.example.myfragmentapp;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnChoose;
    private Button btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbSaf;
    private RadioButton rbMou;
    private RadioButton rbLvg;
    private RadioButton rbMoyes;
    private OnOptionDialogListener onOptionDialogListener;

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
    }

    public OptionDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose = view.findViewById(R.id.btn_choose);
        btnClose = view.findViewById(R.id.btn_close);
        rgOptions = view.findViewById(R.id.rg_option);
        rbLvg = view.findViewById(R.id.rb_lvg);
        rbMou = view.findViewById(R.id.rb_mou);
        rbMoyes = view.findViewById(R.id.rb_moyes);
        rbSaf = view.findViewById(R.id.rb_saf);

        btnClose.setOnClickListener(this);
        btnChoose.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close : {
                getDialog().cancel();
                break;
            }

            case R.id.btn_choose : {
                int checkedRadioGroupId = rgOptions.getCheckedRadioButtonId();
                if (checkedRadioGroupId != -1) {
                    String coach = null;
                    switch (checkedRadioGroupId) {
                        case R.id.rb_saf: {
                            coach = rbSaf.getText().toString().trim();
                            break;
                        }
                        case R.id.rb_mou : {
                            coach = rbMou.getText().toString().trim();
                            break;
                        }
                        case R.id.rb_lvg : {
                            coach = rbLvg.getText().toString().trim();
                            break;
                        }
                        case R.id.rb_moyes : {
                            coach = rbMoyes.getText().toString().trim();
                            break;
                        }
                    }
                    getOnOptionDialogListener().onOptionChoosen(coach);
                    getDialog().cancel();
                }
            }
        }
    }

    public interface OnOptionDialogListener {
        void onOptionChoosen(String text);
    }
}
