/**
 * @author  Tiam Abderezai
 */
package com.example.passwordstrengthexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements TextWatcher {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_password = findViewById(R.id.et_password);
        et_password.addTextChangedListener(this);
    }


    private void enterPassword(String password) {
        TextView tv_maximum = findViewById(R.id.tv_maximum);
        TextView tv_special = findViewById(R.id.tv_special);
        TextView tv_number = findViewById(R.id.tv_number);
        TextView tv_upper = findViewById(R.id.tv_upper);
        TextView tv_lower = findViewById(R.id.tv_lower);
        if (!(password.length() <= 8)) {
            tv_maximum.setTextColor(Color.GREEN);
        } else {
            tv_maximum.setTextColor(Color.RED);
        }
        if (isSpecial(password)) {
            tv_special.setTextColor(Color.GREEN);
        } else {
            tv_special.setTextColor(Color.RED);
        }
        if (isNumber(password)) {
            tv_number.setTextColor(Color.GREEN);
        } else {
            tv_number.setTextColor(Color.RED);
        }
        if (isUpperCase(password)) {
            tv_upper.setTextColor(Color.GREEN);
        } else {
            tv_upper.setTextColor(Color.RED);
        }
        if (isLowerCase(password)) {
            tv_lower.setTextColor(Color.GREEN);
        } else {
            tv_lower.setTextColor(Color.RED);
        }

    }


    // Used to validate password
    // See https://stackoverflow.com/questions/36574183/how-to-validate-password-field-in-android
    // See https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
    public static boolean isSpecial(String s) {
        Pattern p
                = Pattern.compile(
                "(?=.*[@$!%*#?&])[A-Za-z \\d@$!%*#?&]*");
        return !TextUtils.isEmpty(s) && p.matcher(s).matches();
    }
    public static boolean isNumber(String s) {
        Pattern p
                = Pattern.compile(
                "(?=.*\\d)[A-Za-z \\d@$!%*#?&]*");
        return !TextUtils.isEmpty(s) && p.matcher(s).matches();
    }
    public static boolean isUpperCase(String s) {
        Pattern p
                = Pattern.compile(
                "(?=.*[A-Z])[A-Za-z \\d@$!%*#?&]*");
        return !TextUtils.isEmpty(s) && p.matcher(s).matches();
    }

    public static boolean isLowerCase(String s) {
        Pattern p
                = Pattern.compile(
                "(?=.*[a-z])[A-Za-z \\d@$!%*#?&]*");
        return !TextUtils.isEmpty(s) && p.matcher(s).matches();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        enterPassword(charSequence.toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {
    }
}