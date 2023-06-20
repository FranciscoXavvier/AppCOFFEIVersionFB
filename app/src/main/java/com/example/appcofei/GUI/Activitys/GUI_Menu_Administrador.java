package com.example.appcofei.GUI.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appcofei.R;

public class GUI_Menu_Administrador extends AppCompatActivity implements View.OnClickListener {

    Button buttonGestionarProducto;
    Button buttonRegistrarEmpelado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_menu_administrador);

        buttonGestionarProducto = findViewById(R.id.Activity_GUI_Menu_Administrador_Gestionar_Producto_Button);
        buttonRegistrarEmpelado = findViewById(R.id.Activity_GUI_Menu_Administrador_Registrar_Empleado_Button);
        buttonGestionarProducto.setOnClickListener(this);
        buttonRegistrarEmpelado.setOnClickListener(this);
    }

    private void irGestionarProducto(){
        Intent intent = new Intent( GUI_Menu_Administrador.this, GUI_CU_Gestionar_Producto.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void irRegistrarEmpleado(){
        Intent intent = new Intent( GUI_Menu_Administrador.this, GUI_CU_09_Registrar_Emplaedo.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Activity_GUI_Menu_Administrador_Gestionar_Producto_Button:
                irGestionarProducto();
                break;
            case R.id.Activity_GUI_Menu_Administrador_Registrar_Empleado_Button:
                irRegistrarEmpleado();
                break;
        }
    }
}