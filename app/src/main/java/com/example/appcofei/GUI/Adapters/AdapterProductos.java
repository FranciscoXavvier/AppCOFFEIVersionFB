package com.example.appcofei.GUI.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcofei.Datos.Modelo.Producto;
import com.example.appcofei.GUI.Activitys.GUI_CU_11_Consultar_Producto;
import com.example.appcofei.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterProductos extends BaseAdapter {

    List<Producto> listaProductos;
    Context context;
    TextView nombreTextView;
    TextView marcaTextView;
    TextView cantidadExistenteTextView;
    ImageView productoImageView;
    Button verButton;
    int indexPosicion;

    public AdapterProductos(List<Producto> listaProductos, Context context) {
        this.listaProductos = listaProductos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaProductos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaProductos.get(position).getIdProducto();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        indexPosicion = position;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.lista_productos_layout, parent, false);
        }
        productoImageView = convertView.findViewById(R.id.lista_productos_layout_ImagenProducto_ImageView);
        nombreTextView = convertView.findViewById(R.id.lista_productos_layout_Nombre_TextView);
        marcaTextView = convertView.findViewById(R.id.lista_productos_layout_Marca_TextView);
        cantidadExistenteTextView = convertView.findViewById(R.id.lista_productos_layout_Cantidad_Existente_TextView);
        nombreTextView.setText(listaProductos.get(position).getNombre());
        marcaTextView.setText(listaProductos.get(position).getMarca());
        cantidadExistenteTextView.setText(String.valueOf(listaProductos.get(position).getCantidadExistencia()));
        Picasso.get().load(listaProductos.get(position).getRutaImagen()).into(productoImageView);
        verButton = convertView.findViewById(R.id.lista_productos_layout_Ver_Button);
        verButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irConsultarProducto(listaProductos.get(position).getNombre());
            }
        });
        return convertView;
    }

    private void irConsultarProducto(String nombre){
        Intent intent = new Intent(context, GUI_CU_11_Consultar_Producto.class);
        intent.putExtra("nombre", nombre);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
