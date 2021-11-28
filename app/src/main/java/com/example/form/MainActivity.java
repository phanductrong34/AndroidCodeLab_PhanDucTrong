package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText editName, editEmail , editPhone, editMSSV, editBirth;
    public CheckBox accept;
    public ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editPhone = findViewById(R.id.edit_Phone);
        editMSSV = findViewById(R.id.edit_MSSV);
        editBirth = findViewById(R.id.edit_birth);
        accept = findViewById(R.id.checkbox_accept);
        scrollView = findViewById(R.id.scrollView);

    }
    private boolean isEmpty(EditText editText){
        if(editText.getText().toString().length() == 0){
            return true;
        }else return false;
    }

    private final void focusOnView(EditText editText){
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.smoothScrollTo(0, editText.getTop());
            }
        });
    }

    public void submitForm(View view) {
        if(isEmpty(editName)){
            editName.setError("Bạn phải điền mục Họ tên");
            Toast.makeText(getBaseContext(),"Bạn phải điền mục Họ tên",Toast.LENGTH_LONG).show();
            focusOnView(editName);
        }else if(isEmpty(editMSSV)){
            editMSSV.setError("Bạn phải điền mục MSSV");
            Toast.makeText(this,"Bạn phải điền mục MSSV",Toast.LENGTH_LONG).show();
            focusOnView(editMSSV);
        }else if(isEmpty(editEmail)){
            editEmail.setError("Bạn phải điền mục Email");
            Toast.makeText(this,"Bạn phải điền mục Email",Toast.LENGTH_LONG).show();
            focusOnView(editEmail);
        }else if(isEmpty(editBirth)){
            editBirth.setError("Bạn phải điền mục Ngày Sinh");
            Toast.makeText(this,"Bạn phải điền mục Ngày Sinh",Toast.LENGTH_LONG).show();
            focusOnView(editBirth);
        }else if (isEmpty(editPhone)){
            editPhone.setError("Bạn phải điền mục Số Điện Thoại");
            Toast.makeText(this,"Bạn phải điền mục Số Điện Thoại",Toast.LENGTH_LONG).show();
            focusOnView(editPhone);
        }else if(!accept.isChecked()){
            Toast.makeText(this,"Bạn phải tick nút đồng ý",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Bạn đã đăng ký thành công", Toast.LENGTH_LONG).show();
        }
    }
}