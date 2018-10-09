package pe.edu.upeu.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity implements View.OnClickListener{

    private Button reg;
    private TextView tvLogin;
    private EditText etUser, etPass;
    private DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        db = new DbHelper(this);
        reg = (Button)findViewById(R.id.btnReg);
        tvLogin = (TextView)findViewById(R.id.tvLogin);
        etUser = (EditText)findViewById(R.id.etuser);
        etPass = (EditText)findViewById(R.id.etPass);
        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnReg:
                registar();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(RegistrarActivity.this,MainActivity.class));
                finish();
                break;
            default:

        }

    }
    private void registar(){
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();
        if(user.isEmpty() && pass.isEmpty()){
            displayToast("Usuario/contraseña erroneos");
        }else{
            db.addUser(user,pass);
            displayToast("Usuario registrado");
            finish();
        }
    }
    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
