package com.futurelens.screenui.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import androidx.appcompat.widget.Toolbar;

import com.futurelens.screenui.R;

public class AddMemberActivity extends AppCompatActivity {

    Toolbar toolbar;
    RadioButton radioButton1,radioButton2,radioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        setSupportActionBar(toolbar);

        radioButton1 = findViewById(R.id.radio1);
        radioButton2 = findViewById(R.id.radio2);
        radioButton3 = findViewById(R.id.radio3);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.radio1:
                if (checked)
                    break;
            case R.id.radio2:
                if (checked)
                    break;
            case R.id.radio3:
                if (checked)
                    break;
        }
    }
}
