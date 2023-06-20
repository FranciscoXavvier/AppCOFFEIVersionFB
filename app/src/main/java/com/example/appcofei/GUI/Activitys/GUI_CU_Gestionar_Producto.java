package com.example.appcofei.GUI.Activitys;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appcofei.Datos.Modelo.Producto;
import com.example.appcofei.GUI.Adapters.AdapterProductos;
import com.example.appcofei.Logica.RetrofitCliente;
import com.example.appcofei.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GUI_CU_Gestionar_Producto extends AppCompatActivity implements View.OnClickListener{

    ListView listView;
    List<Producto> listaProductos;
    FloatingActionButton agregarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_cu_gestionar_producto);
        listView = findViewById(R.id.Activity_GUI_CU_Gestionar_Producto_ListView);
        agregarButton = findViewById(R.id.Activity_GUI_CU_Gestionar_Producto_Agregar_Button);
        agregarButton.setOnClickListener(this);
        obtenerTodosProductos();
    }

    private void irRegistroProducto(){
        Intent intent = new Intent( GUI_CU_Gestionar_Producto.this, GUI_CU_01_Registrar_Producto.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void obtenerTodosProductos(){
        Call<List<Producto>> call = RetrofitCliente.getInstanceSinglenton().getApiServicioProducto().ConsultarProductos("", "", "");
        call.enqueue(new Callback<List<Producto>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if(response.isSuccessful()){
                    listaProductos = response.body();
                    AdapterProductos productosAdapter = new AdapterProductos(listaProductos, getApplicationContext());
                    listView.setAdapter(productosAdapter);
                }else{
                    Toast.makeText(GUI_CU_Gestionar_Producto.this, "Mensaje de error : " + response.message() , Toast.LENGTH_SHORT).show();
                    Log.e("Response error : ", response.message());
                    return;
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Toast.makeText(GUI_CU_Gestionar_Producto.this, "Mensaje de erro : " + t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRestart(){
        super.onRestart();
        obtenerTodosProductos();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Activity_GUI_CU_Gestionar_Producto_Agregar_Button:
                irRegistroProducto();
                break;
        }
    }
}