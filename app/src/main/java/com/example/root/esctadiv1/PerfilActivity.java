package com.example.root.esctadiv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {
    private TextView tdatos;
    String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        tdatos=findViewById(R.id.tdatos);


        Bundle args;
        args = getIntent().getExtras();
        if (args != null) {
            user = args.getString("Username");
            pass = args.getString("Password");
            tdatos.setText("Mi Correo: "+ user);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuperfil,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        Intent intent=null;
        switch (id){
            case R.id.cerrarse:
                Intent intent2 = new Intent(PerfilActivity.this,LoginActivity.class);
                intent2.putExtra("Username",user);
                intent2.putExtra("Password", pass);
                startActivity(intent2);
                break;

            case R.id.principal:
                intent =new Intent();
                setResult(RESULT_OK, intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
