package com.example.secondactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.name);
        Password=(EditText)findViewById(R.id.password);
        Info =(TextView) findViewById(R.id.textView);
        Login=(Button)findViewById(R.id.button);

        Info.setText("No of Attempts Remaing:5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }
    private void validate(String userName,String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent=new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("No of Attempts Remaining:" +String.valueOf(counter));
            if (counter==0){
                Login.setEnabled(false);
            }
        }
    }
    public void onBackPressed(){
        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Confirm Exit......!!");
        alertDialogBuilder.setIcon(R.drawable.ic_exit_to_app_black_24dp);
        alertDialogBuilder.setMessage("Are you sure you want to exit");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"you clicked on cancel",Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();


    }
}
