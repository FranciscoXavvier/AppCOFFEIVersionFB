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

import com.example.appcofei.Datos.Modelo.Empleado;
import com.example.appcofei.Logica.RetrofitCliente;
import com.example.appcofei.MainActivity;
import com.example.appcofei.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GUI_CU_09_Registrar_Emplaedo extends AppCompatActivity implements View.OnClickListener {

    private EditText editText_Nombre;
    private EditText editText_ApellidoPaterno;
    private EditText editText_ApellidoMaterno;
    private EditText editText_Correo;
    private EditText editText_Telefono;
    private EditText editText_ClaveTrabajador;
    private EditText editText_Contrasena;
    private EditText editText_ConfirmarContrasena;
    private EditText editText_Cargo;
    private TextView textView_cancelar;
    private Button button_Registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_cu09_registrar_emplaedo);

        editText_Nombre = findViewById(R.id.Activity_GUI_CU_09_Registrar_Empleado_Nombre_EditText);
        editText_ApellidoPaterno = findViewById(R.id.Activity_GUI_CU_09_Registrar_Empleado_APaterno_EditText);
        editText_ApellidoMaterno = findViewById(R.id.Activity_GUI_CU_09_Registrar_Empleado_AMaterno_EditText);
        editText_Correo = findViewById(R.id.Activity_GUI_CU_09_Registrar_Empleado_Correo_EditText);
        editText_Telefono =findViewById(R.id.Activity_GUI_CU_09_Registrar_Empleado_Telefono_EditText);
        editText_ClaveTrabajador = findViewById(R.id.Activity_GUI_CU_09_Registrar_Empleado_ClaveTrabajador_EditText);
        editText_Contrasena = findViewById(R.id.Activity_GUI_CU_09_Registrar_Empleado_Contrasena_EditText);
        editText_ConfirmarContrasena = findViewById(R.id.Activity_GUI_CU_09_Registrar_Empleado_Confirmar_Contrasena_EditText);
        editText_Cargo = findViewById(R.id.Activity_GUI_CU_09_Registrar_Empleado_Cargo_EditText);
        textView_cancelar = findViewById(R.id.Activity_GUI_CU_09_Registrar_Empleado_Cancelar_TextView);
        button_Registrar = findViewById(R.id.Activity_GUI_CU_09_Registrar_Empledo_Registrar_Button);
        button_Registrar.setOnClickListener(this);
        textView_cancelar.setOnClickListener(this);
    }

    private void registrarEmpleado(){
        if(validarFormulario()) {
            Empleado empleado = new Empleado();
            empleado.setNombre(editText_Nombre.getText().toString());
            empleado.setApellidoPaterno(editText_ApellidoPaterno.getText().toString());
            empleado.setApellidoMaterno(editText_ApellidoMaterno.getText().toString());
            empleado.setCorreo(editText_Correo.getText().toString());
            empleado.setNumeroTelefono(editText_Telefono.getText().toString());
            empleado.setClaveTrabajador(editText_ClaveTrabajador.getText().toString().toUpperCase().trim());
            empleado.setContrasena(editText_Contrasena.getText().toString());
            empleado.setEsCuentaConfirmada(true);
            empleado.setCargo(editText_Cargo.getText().toString());

            Call<Empleado> call = RetrofitCliente.getInstanceSinglenton().getApiServicioEmpleado().RegistrarEmpleado(empleado);
            call.enqueue(new Callback<Empleado>() {
                @Override
                public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                    Toast.makeText(GUI_CU_09_Registrar_Emplaedo.this, "Mensaje confirmacion : " + response.code() , Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Empleado> call, Throwable t) {

                }
            });

            irMenuAdministrador();
        }
    }

    private boolean validarFormulario(){
        boolean esFormularioValido = false;
        if(editText_Nombre.getText().toString().isEmpty() || editText_ApellidoPaterno.getText().toString().isEmpty() || editText_ApellidoMaterno.getText().toString().isEmpty() || editText_Correo.getText().toString().isEmpty() || editText_Telefono.getText().toString().isEmpty() || editText_ClaveTrabajador.getText().toString().isEmpty() || editText_Contrasena.getText().toString().isEmpty() || editText_ConfirmarContrasena.getText().toString().isEmpty() || editText_Cargo.getText().toString().isEmpty()){
            Toast.makeText(this,"Los campos no puedene quedar vacios", Toast.LENGTH_SHORT).show();
        }else if(!editText_Contrasena.getText().toString().equals(editText_ConfirmarContrasena.getText().toString())){
            Toast.makeText(this,"Las contrasenas no coinciden", Toast.LENGTH_SHORT).show();
        }else if(editText_Contrasena.getText().toString().length() < 6 || editText_ConfirmarContrasena.getText().toString().length() < 6){
            Toast.makeText(this, "Las contrasenas debe ser mayor o igual a 6 caracteres", Toast.LENGTH_SHORT).show();
        }else if(editText_Telefono.getText().toString().length() != 10 ) {
            Toast.makeText(this, "El telefono solo puede ser igual a 10 numeros", Toast.LENGTH_SHORT).show();
        }else if(!Patterns.EMAIL_ADDRESS.matcher(editText_Correo.getText().toString().trim()).matches()) {
            Toast.makeText(this, "El correo introducido no es valido", Toast.LENGTH_SHORT).show();
        }else if(!editText_ClaveTrabajador.getText().toString().trim().toUpperCase().startsWith("EM") || editText_Telefono.getText().toString().length() != 10 ) {
            Toast.makeText(this, "La clave de trabajador debe ser igual a 10 caracteres y comenzar con EM", Toast.LENGTH_SHORT).show();
        }else{
            esFormularioValido = true;
        }
        return esFormularioValido;
    }

    private void irMenuAdministrador(){
        Intent intent = new Intent( GUI_CU_09_Registrar_Emplaedo.this, GUI_Menu_Administrador.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Activity_GUI_CU_09_Registrar_Empledo_Registrar_Button:
                registrarEmpleado();
                break;
            case R.id.Activity_GUI_CU_09_Registrar_Empleado_Cancelar_TextView:
                irMenuAdministrador();
                break;
        }
    }
}