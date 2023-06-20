package com.example.appcofei.GUI.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcofei.Datos.Modelo.Cliente;
import com.example.appcofei.Logica.RetrofitCliente;
import com.example.appcofei.MainActivity;
import com.example.appcofei.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GUI_CU_04_Registrar_Cliente extends AppCompatActivity implements View.OnClickListener {

    private EditText editText_Nombre;
    private EditText editText_ApellidoPaterno;
    private EditText editText_ApellidoMaterno;
    private EditText editText_Correo;
    private EditText editText_Telefono;
    private EditText editText_Matricula;
    private EditText editText_Contrasena;
    private EditText editText_ConfirmarContrasena;
    private TextView textView_cancelar;
    private Button button_Registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_cu04_registrar_cliente);

        editText_Nombre = findViewById(R.id.Activity_GUI_CU_04_Registrar_Cliente_Nombre_EditText);
        editText_ApellidoPaterno = findViewById(R.id.Activity_GUI_CU_04_Registrar_Cliente_APaterno_EditText);
        editText_ApellidoMaterno = findViewById(R.id.Activity_GUI_CU_04_Registrar_Cliente_AMaterno_EditText);
        editText_Correo = findViewById(R.id.Activity_GUI_CU_04_Registrar_Cliente_Correo_EditText);
        editText_Telefono =findViewById(R.id.Activity_GUI_CU_04_Registrar_Cliente_Telefono_EditText);
        editText_Matricula = findViewById(R.id.Activity_GUI_CU_04_Registrar_Cliente_Matricula_EditText);
        editText_Contrasena = findViewById(R.id.Activity_GUI_CU_04_Registrar_Cliente_Contrasena_EditText);
        editText_ConfirmarContrasena = findViewById(R.id.Activity_GUI_CU_04_Registrar_Cliente_Confirmar_Contrasena_EditText);
        textView_cancelar = findViewById(R.id.Activity_GUI_CU_04_Registrar_Cliente_Cancelar_TextView);
        button_Registrarse = findViewById(R.id.Activity_GUI_CU_04_Registrar_Cliente_Registrarse_Button);
        button_Registrarse.setOnClickListener(this);
        textView_cancelar.setOnClickListener(this);
    }

    private void registrarCliente(){
        if(validarFormulario()) {
            Cliente cliente = new Cliente();
            cliente.setNombre(editText_Nombre.getText().toString().trim());
            cliente.setApellidoPaterno(editText_ApellidoPaterno.getText().toString().trim());
            cliente.setApellidoMaterno(editText_ApellidoMaterno.getText().toString().trim());
            cliente.setCorreo(editText_Correo.getText().toString().trim());
            cliente.setNumeroTelefono(editText_Telefono.getText().toString().trim());
            cliente.setMatricula(editText_Matricula.getText().toString().toUpperCase().trim());
            cliente.setContrasena(editText_Contrasena.getText().toString());
            cliente.setEsCuentaConfirmada(true);

            Call<Cliente> call = RetrofitCliente.getInstanceSinglenton().getApiServicioCliente().RegistrarCliente(cliente);
            call.enqueue(new Callback<Cliente>() {
                @Override
                public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                    Toast.makeText(GUI_CU_04_Registrar_Cliente.this, "Mensaje confirmacion : " + response.code() , Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Cliente> call, Throwable t) {

                }
            });

            irMain();
        }
    }

    private boolean validarFormulario(){
        boolean esFormularioValido = false;
        if(editText_Nombre.getText().toString().isEmpty() || editText_ApellidoPaterno.getText().toString().isEmpty() || editText_ApellidoMaterno.getText().toString().isEmpty() || editText_Correo.getText().toString().isEmpty() || editText_Telefono.getText().toString().isEmpty() || editText_Matricula.getText().toString().isEmpty() || editText_Contrasena.getText().toString().isEmpty() || editText_ConfirmarContrasena.getText().toString().isEmpty()){
            Toast.makeText(this,"Los campos no puedene quedar vacios", Toast.LENGTH_SHORT).show();
        }else if(!editText_Contrasena.getText().toString().equals(editText_ConfirmarContrasena.getText().toString())) {
            Toast.makeText(this, "Las contrasenas no coinciden", Toast.LENGTH_SHORT).show();
        }else if(editText_Contrasena.getText().toString().length() < 6 || editText_ConfirmarContrasena.getText().toString().length() < 6){
            Toast.makeText(this, "Las contrasenas debe ser mayor o igual a 6 caracteres", Toast.LENGTH_SHORT).show();
        }else if(editText_Telefono.getText().toString().length() != 10 ) {
            Toast.makeText(this, "El telefono solo puede ser igual a 10 numeros", Toast.LENGTH_SHORT).show();
        }else if(!Patterns.EMAIL_ADDRESS.matcher(editText_Correo.getText().toString().trim()).matches()){
            Toast.makeText(this,"El correo introducido no es valido", Toast.LENGTH_SHORT).show();
        }else if(!editText_Matricula.getText().toString().trim().toUpperCase().startsWith("ZS") || editText_Telefono.getText().toString().length() != 10 ) {
            Toast.makeText(this, "La matricula debe ser igual a 10 caracteres y comenzar con ZS", Toast.LENGTH_SHORT).show();
        }else{
            esFormularioValido = true;
        }
        return esFormularioValido;
    }

    private void irMain(){
        Intent intent = new Intent( GUI_CU_04_Registrar_Cliente.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Activity_GUI_CU_04_Registrar_Cliente_Registrarse_Button:
                registrarCliente();
                break;
            case R.id.Activity_GUI_CU_04_Registrar_Cliente_Cancelar_TextView:
                irMain();
                break;
        }
    }
}