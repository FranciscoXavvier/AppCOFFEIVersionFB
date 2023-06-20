package com.example.appcofei.GUI.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcofei.Datos.Modelo.Cliente;
import com.example.appcofei.Datos.Modelo.Empleado;
import com.example.appcofei.Logica.RetrofitCliente;
import com.example.appcofei.R;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GUI_CU_03_Iniciar_Sesion extends AppCompatActivity implements View.OnClickListener {

    private String matricula = "";
    private String contrasena = "";

    private Empleado empleadoLogueado;
    private Cliente clienteLogueado;

    private EditText editTextMatricula;
    private EditText editTextContrasena;
    private Button buttonIniciarSesion;
    private TextView registrateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_cu03_iniciar_sesion);

        editTextMatricula = findViewById(R.id.Activity_GUI_CU_03_Iniciar_Sesion_Matricula_EditText);
        editTextContrasena = findViewById(R.id.Activity_GUI_CU_03_Iniciar_Sesion_Contrasena_EditText);
        registrateTextView = findViewById(R.id.Activity_GUI_CU_03_Iniciar_Sesion_Registrate_TextView);
        buttonIniciarSesion = findViewById(R.id.Activity_GUI_CU_03_Iniciar_Sesion_Login_Button);
        buttonIniciarSesion.setOnClickListener(this);
        registrateTextView.setOnClickListener(this);
    }

    private void iniciarSesion(){
        if(validarFormulario()){
            matricula = editTextMatricula.getText().toString().trim();
            contrasena = editTextContrasena.getText().toString().trim();
            if (matricula.toUpperCase().startsWith("EM"))
            {
                solicitarSesionEmpleado(matricula, contrasena);
            }
            else if (matricula.toUpperCase().startsWith("ZS"))
            {
                solicitarSesionCliente(matricula, contrasena);
            }
        }
    }

    private void solicitarSesionCliente(String matricula, String contrasena){
        Call<Cliente> call = RetrofitCliente.getInstanceSinglenton().getApiServicioCliente().IniciarSesion(matricula, contrasena);
        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if (response.isSuccessful()){
                    clienteLogueado = response.body();
                    if(clienteLogueado!=null){
                        irMenuCliente();
                    }else{
                        Toast.makeText(GUI_CU_03_Iniciar_Sesion.this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(GUI_CU_03_Iniciar_Sesion.this, "Mensaje : " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Toast.makeText(GUI_CU_03_Iniciar_Sesion.this, "Mensaje de error : " + t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void solicitarSesionEmpleado(String matricula, String contrasena){
        Call<Empleado> call = RetrofitCliente.getInstanceSinglenton().getApiServicioEmpleado().IniciarSesion(matricula, contrasena);
        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (response.isSuccessful()){
                    empleadoLogueado = response.body();
                    if(empleadoLogueado!=null){
                        irMenuAdministrador();
                    }else{
                        Toast.makeText(GUI_CU_03_Iniciar_Sesion.this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(GUI_CU_03_Iniciar_Sesion.this, "Mensaje : " + response.message(), Toast.LENGTH_SHORT).show();
                }            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Toast.makeText(GUI_CU_03_Iniciar_Sesion.this, "Mensaje de erro : " + t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validarFormulario(){
        boolean esFormularioValido = false;
        if (editTextMatricula.getText().toString().isEmpty()) Toast.makeText(GUI_CU_03_Iniciar_Sesion.this, "Ingrese la matricula por favor" , Toast.LENGTH_SHORT).show();
        else if (editTextMatricula.getText().toString().isEmpty()) Toast.makeText(GUI_CU_03_Iniciar_Sesion.this, "Ingrese la contrasena por favor" , Toast.LENGTH_SHORT).show();
        else if (editTextMatricula.getText().toString().length() != 10 || !(editTextMatricula.getText().toString().toUpperCase().startsWith("EM") || (editTextMatricula.getText().toString().toUpperCase().startsWith("ZS")))) Toast.makeText(GUI_CU_03_Iniciar_Sesion.this, "La clave de trabajador debe comenzar con EM o ZS y debe estar seguida por 8 numeros solamente ejemplo : ZS12345678" , Toast.LENGTH_SHORT).show();
        else if (editTextContrasena.getText().toString().length() < 6) Toast.makeText(GUI_CU_03_Iniciar_Sesion.this, "La contraseña no puede ser menor a seis caracteres" , Toast.LENGTH_SHORT).show();
        else esFormularioValido = true;
        return esFormularioValido;
    }

    private void irMenuAdministrador(){
        Intent intent = new Intent( GUI_CU_03_Iniciar_Sesion.this, GUI_Menu_Administrador.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void irMenuCliente(){
        Intent intent = new Intent( GUI_CU_03_Iniciar_Sesion.this, GUI_Menu_Cliente.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void irRegistro(){
        Intent intent = new Intent( GUI_CU_03_Iniciar_Sesion.this, GUI_CU_04_Registrar_Cliente.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Activity_GUI_CU_03_Iniciar_Sesion_Login_Button:
                iniciarSesion();
                break;
            case R.id.Activity_GUI_CU_03_Iniciar_Sesion_Registrate_TextView:
                irRegistro();
                break;
        }
    }
}