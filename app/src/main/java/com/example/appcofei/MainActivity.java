package com.example.appcofei;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appcofei.GUI.Activitys.GUI_CU_03_Iniciar_Sesion;
import com.example.appcofei.GUI.Activitys.GUI_CU_04_Registrar_Cliente;
import com.example.appcofei.GUI.Activitys.GUI_CU_Gestionar_Producto;
import com.example.appcofei.Logica.RetrofitCliente;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_Login;
    Button btn_Registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Servicio COFEI");
        btn_Login = findViewById(R.id.Activity_Main_btn_Login);
        btn_Registro = findViewById(R.id.Activity_Main_btn_Registro);
        btn_Login.setOnClickListener(this);
        btn_Registro.setOnClickListener(this);
    }

    private void irIniciarSesion(){
        Intent intent = new Intent( MainActivity.this, GUI_CU_03_Iniciar_Sesion.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void irRegistrarse(){
        Intent intent = new Intent( MainActivity.this, GUI_CU_04_Registrar_Cliente.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Activity_Main_btn_Login:
                irIniciarSesion();
                break;
            case R.id.Activity_Main_btn_Registro:
                irRegistrarse();
                break;
        }
    }
}