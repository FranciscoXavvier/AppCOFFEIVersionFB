package com.example.appcofei.GUI.Activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcofei.Datos.Modelo.Producto;
import com.example.appcofei.Logica.RetrofitCliente;
import com.example.appcofei.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GUI_CU_11_Consultar_Producto extends AppCompatActivity {

    TextView nombreTextView;
    TextView cantidadExistenciaTextView;
    TextView tamanoTextView;
    TextView categoriaTextView;
    TextView descripcionTextView;
    TextView marcaTextView;
    TextView precioTextView;
    TextView puntosFidelidadTextView;
    TextView tipoEnvaseTextView;
    ImageView productoImageView;
    Button modificarButton;
    Button eliminarButton;
    AlertDialog.Builder alertBuilder;
    Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_cu11_consultar_producto);
        nombreTextView = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Nombre_TextView);
        cantidadExistenciaTextView = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Cantidad_Existencia_TextView);
        tamanoTextView = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Tamano_TextView);
        categoriaTextView = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Categoria_TextView);
        descripcionTextView = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Descripcion_TextView);
        marcaTextView = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Marca_TextView);
        precioTextView = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Precio_TextView);
        puntosFidelidadTextView = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Puntos_Fidelidad_TextView);
        tipoEnvaseTextView = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Tipo_Envase_TextView);
        productoImageView = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_ImagenProducto_ImageView);
        modificarButton = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Modificar_Button);
        eliminarButton = findViewById(R.id.Activity_GUI_CU_11_Consultar_Producto_Eliminar_Button);
        alertBuilder = new AlertDialog.Builder(this);
        String nombre = getIntent().getExtras().getString("nombre");
        obtenerProduco(nombre);
        modificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irModificarProducto();
            }
        });
        eliminarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertBuilder.setTitle("Eliminar Producto")
                        .setMessage("Esta seguro que desea eliminar el producto")
                        .setCancelable(true)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                eliminarProducto();
                                irGestionarProducto();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });
    }

    private void irGestionarProducto(){
        Intent intent = new Intent( GUI_CU_11_Consultar_Producto.this, GUI_CU_Gestionar_Producto.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void irModificarProducto(){
        Intent intent = new Intent(GUI_CU_11_Consultar_Producto.this, GUI_CU_02_Modificar_Producto.class);
        intent.putExtra("producto", producto);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void obtenerProduco(String nombre){
        Call<List<Producto>> call = RetrofitCliente.getInstanceSinglenton().getApiServicioProducto().ConsultarProductos(nombre, "", "");
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if(response.isSuccessful() && !response.body().isEmpty()){
                    List<Producto> listaProductosRecuperada = response.body();
                    for (int i = 0 ; i < listaProductosRecuperada.size() ; i++) {
                        if(listaProductosRecuperada.get(i).getNombre().equalsIgnoreCase(nombre)){
                            producto = listaProductosRecuperada.get(i);
                        }
                    }
                    if (producto != null){
                        cargarProducto();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Toast.makeText(GUI_CU_11_Consultar_Producto.this, "Mensaje de error al obtener producto : " + t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarProducto(){
        nombreTextView.setText(producto.getNombre());
        cantidadExistenciaTextView.setText(String.valueOf(producto.getCantidadExistencia()));
        tamanoTextView.setText(producto.getTamanoProducto());
        categoriaTextView.setText(producto.getCategoria());
        descripcionTextView.setText(producto.getDescripcion());
        marcaTextView.setText(producto.getMarca());
        precioTextView.setText(String.valueOf(producto.getPrecio()));
        puntosFidelidadTextView.setText(String.valueOf(producto.getPuntosFidelidad()));
        tipoEnvaseTextView.setText(producto.getTipoEnvase());
        Picasso.get().load(producto.getRutaImagen()).into(productoImageView);
    }

    private void eliminarProducto(){
        Call call = RetrofitCliente.getInstanceSinglenton().getApiServicioProducto().eliminarProducto(producto.getIdProducto());
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    Toast.makeText(GUI_CU_11_Consultar_Producto.this, "Mensaje confirmacion : " + response.code() , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(GUI_CU_11_Consultar_Producto.this, "Mensaje de error : " + response.code() + response.message() , Toast.LENGTH_SHORT).show();
                    Log.e("Response error : ", response.message());
                    return;
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(GUI_CU_11_Consultar_Producto.this, "Mensaje de error : " + t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}