package com.example.root.esctadiv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText eusername,epassword;
    String name,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eusername=findViewById(R.id.eusername);
        epassword=findViewById(R.id.epassword);

        Bundle args;
        args = getIntent().getExtras();
        if (args != null) {
            name = args.getString("Username");
            pass = args.getString("Password");


        }
    }

    public void gomain (View view){
        String name1,pass1;
        name1= eusername.getText().toString();
        pass1=epassword.getText().toString();

        if (name1.equals(name) && pass1.equals(pass)){
            Intent intent1 = new Intent(LoginActivity.this,MainActivity.class);
            intent1.putExtra("Username", name1);
            intent1.putExtra("Password", pass1);
            startActivityForResult(intent1, 1234);
            eusername.setText("");
            epassword.setText("");
        }else {
            if (name1.isEmpty() || pass1.isEmpty()){
                Toast.makeText(getApplicationContext(), "Digite todos los campos.",
                        Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(getApplicationContext(), "Revisa Contraseña o Usuario.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void goregistro (View view){
        Intent intent2 =new Intent(LoginActivity.this,RegistroActivity.class);
        startActivityForResult(intent2, 1234);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            if (data.getExtras() !=null) {
                name= data.getExtras().getString("Username");
                pass=data.getExtras().getString("Password");

            }
        }

    }
}
