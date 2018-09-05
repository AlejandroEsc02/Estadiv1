package com.example.root.esctadiv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle args;
        args = getIntent().getExtras();
        if (args != null) {
            user = args.getString("Username");
            pass = (args.getString("Password"));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        Intent intent=null;
        switch (id){
            case R.id.cerrarse:
                intent =new Intent();
                setResult(RESULT_OK, intent);
                finish();
                break;

            case R.id.miperfil:
                Intent intent2=new Intent(MainActivity.this,PerfilActivity.class);
                intent2.putExtra("Username",user);
                intent2.putExtra("Password", pass);
                startActivityForResult(intent2, 12345);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 12345 && resultCode == RESULT_OK) {
            if (data.getExtras() !=null) {
                user= data.getExtras().getString("Username");
                pass=data.getExtras().getString("Password");

            }
        }

    }
    @Override
    public void onBackPressed() {
        finishAffinity();

    }
}
