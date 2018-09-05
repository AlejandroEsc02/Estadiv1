package com.example.root.esctadiv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText eusername, epassword,erepassword;
    private static String user,pass, repass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        eusername=findViewById(R.id.eusername);
        epassword=findViewById(R.id.epassword);
        erepassword=findViewById(R.id.erepassword);



    }

    public void gologinr(View view){

        user = eusername.getText().toString();
        pass = epassword.getText().toString();
        repass = erepassword.getText().toString();

        if (user.isEmpty() || pass.isEmpty() || repass.isEmpty()){
            Toast.makeText(getApplicationContext(), "Digite todos los campos.",
                    Toast.LENGTH_SHORT).show();
        }else{
            if (repass.equals(pass)){
                Intent intent1 = new Intent();
                intent1.putExtra("Username",user );
                intent1.putExtra("Password", pass);
                setResult(RESULT_OK, intent1);
                finish();
                Toast.makeText(getApplicationContext(), "Registrado.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Contraseñas no iguales.",
                        Toast.LENGTH_SHORT).show();
            }
        }



    }
    public void gologin (View view){
        Intent intent2 = new Intent(RegistroActivity.this,LoginActivity.class);
        startActivity(intent2);
    }
}
