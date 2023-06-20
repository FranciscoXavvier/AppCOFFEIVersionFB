package com.example.appcofei.GUI.Activitys;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcofei.Datos.Modelo.Producto;
import com.example.appcofei.Logica.RetrofitCliente;
import com.example.appcofei.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GUI_CU_02_Modificar_Producto extends AppCompatActivity implements View.OnClickListener {

    private EditText nombreEdiText;
    private EditText marcaEditText;
    private EditText descripcionEditText;
    private Spinner categoriaSpinner;
    private EditText precioEdiText;
    private Spinner puntosFidelidadSpinner;
    private EditText tamanoEditText;
    private Spinner tipoEnvaseSpinner;
    private EditText cantidadExistenciaEditText;
    private TextView rutaImgenTextView;
    private Button modificarButton;
    private Button modificarImagenButton;
    private String categoriaSeleccionada;
    private String tipoEnvaseSeleccionado;
    private Uri rutaArchivoUri;
    private String firebaseUrlImage;
    private boolean esImagenCargada;
    Producto producto;

    private StorageReference storageReference;

    public GUI_CU_02_Modificar_Producto() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_cu02_modificar_producto);
        esImagenCargada = false;
        producto = (Producto) getIntent().getSerializableExtra("producto");
        nombreEdiText = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Nombre_EditText);
        marcaEditText = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Marca_EditText);
        descripcionEditText = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Descripcion_EditText);
        categoriaSpinner = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Categoria_Spinner);
        precioEdiText = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Precio_EditText);
        puntosFidelidadSpinner = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Puntos_Fidelidad_Spinner);
        tamanoEditText = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Tamano_Producto_EditText);
        tipoEnvaseSpinner = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Tipo_Envase_Spinner);
        cantidadExistenciaEditText = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Cantidad_Existencia_EditText);
        rutaImgenTextView = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Ruta_Imagen_TextView);
        modificarButton = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Modificar_Button);
        modificarImagenButton = findViewById(R.id.Activity_GUI_CU_02_Modificar_Producto_Modificar_Imagen_Button);

        nombreEdiText.setText(producto.getNombre());
        marcaEditText.setText(producto.getMarca());
        descripcionEditText.setText(producto.getDescripcion());
        precioEdiText.setText(String.valueOf(producto.getPrecio()));
        tamanoEditText.setText(producto.getTamanoProducto());
        cantidadExistenciaEditText.setText(String.valueOf(producto.getCantidadExistencia()));
        rutaImgenTextView.setText(producto.getRutaImagen());

        storageReference = FirebaseStorage.getInstance().getReference();

        modificarButton.setOnClickListener(this);
        modificarImagenButton.setOnClickListener(this);

        llenarSpinners();

        categoriaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoriaSeleccionada = (String) categoriaSpinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tipoEnvaseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoEnvaseSeleccionado = (String) tipoEnvaseSpinner.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void llenarSpinners(){
        String [] listaCategorias = {"Bebida", "Postre", "Golosina", "Platillo"};
        String [] listaEnvases = {"Bolsa", "Botella vidrio", "Botella Plastico", "Lata", "Ninguno"};
        List<Integer> listaPuntosFidelidad = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++)
        {
            listaPuntosFidelidad.add(i);
        }
        categoriaSpinner.setAdapter(new ArrayAdapter<String>(GUI_CU_02_Modificar_Producto.this, android.R.layout.simple_spinner_dropdown_item, listaCategorias));
        tipoEnvaseSpinner.setAdapter(new ArrayAdapter<String>(GUI_CU_02_Modificar_Producto.this, android.R.layout.simple_spinner_dropdown_item, listaEnvases));
        puntosFidelidadSpinner.setAdapter(new ArrayAdapter<Integer>(GUI_CU_02_Modificar_Producto.this, android.R.layout.simple_spinner_dropdown_item, listaPuntosFidelidad));
    }

    private void modificarProducto(){
        if(validarFormulario()) {
            producto.setCategoria(categoriaSeleccionada);
            producto.setCantidadExistencia(Integer.parseInt(cantidadExistenciaEditText.getText().toString()));
            producto.setTamanoProducto(tamanoEditText.getText().toString());
            producto.setDescripcion(descripcionEditText.getText().toString());
            producto.setEsVotable(false);
            producto.setMarca(marcaEditText.getText().toString());
            producto.setTipoEnvase(tipoEnvaseSeleccionado);
            if(esImagenCargada){
                producto.setRutaImagen(firebaseUrlImage);
            }
            producto.setPuntosFidelidad(puntosFidelidadSpinner.getSelectedItemPosition() + 1);
            producto.setNombre(nombreEdiText.getText().toString());
            producto.setPrecio(Float.parseFloat(precioEdiText.getText().toString()));

            Call<Producto> call = RetrofitCliente.getInstanceSinglenton().getApiServicioProducto().actualizarProducto(producto.getIdProducto() , producto);
            call.enqueue(new Callback<Producto>() {
                @Override
                public void onResponse(Call<Producto> call, Response<Producto> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(GUI_CU_02_Modificar_Producto.this, "Mensaje confirmacion1 : " + response.message() , Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(GUI_CU_02_Modificar_Producto.this, "Mensaje de error : " + response.message() , Toast.LENGTH_SHORT).show();
                        Log.e("Response error : ", response.message());
                        return;
                    }
                }

                @Override
                public void onFailure(Call<Producto> call, Throwable t) {
                    Toast.makeText(GUI_CU_02_Modificar_Producto.this, "Mensaje de error : " + t.getMessage() , Toast.LENGTH_SHORT).show();
                }
            });

            Intent intent = new Intent( GUI_CU_02_Modificar_Producto.this, GUI_CU_Gestionar_Producto.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }

    private boolean validarFormulario(){
        boolean esFormularioValido = false;
        if(nombreEdiText.getText().toString().isEmpty() || marcaEditText.getText().toString().isEmpty() || descripcionEditText.getText().toString().isEmpty() || precioEdiText.getText().toString().isEmpty() || tamanoEditText.getText().toString().isEmpty() || cantidadExistenciaEditText.getText().toString().isEmpty()){
            Toast.makeText(this,"Los campos no puedene quedar vacios", Toast.LENGTH_SHORT).show();
        }else if(Integer.parseInt(cantidadExistenciaEditText.getText().toString()) < 0){
            Toast.makeText(this, "Al menos debe haber una cantidad en existencia del producto", Toast.LENGTH_SHORT).show();
        }else if(Float.parseFloat(precioEdiText.getText().toString()) < 0) {
            Toast.makeText(this, "El precio debe ser mayor a cero", Toast.LENGTH_SHORT).show();
        }else{
            esFormularioValido = true;
        }
        return esFormularioValido;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Activity_GUI_CU_02_Modificar_Producto_Modificar_Button:
                modificarProducto();
                break;
            case R.id.Activity_GUI_CU_02_Modificar_Producto_Modificar_Imagen_Button:
                seleccionarImagen();
                break;
        }
    }

    private void seleccionarImagen(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.setType("image/png");
        if(obtenerImagenGaleria !=null){
            obtenerImagenGaleria.launch(intent);
        }
    }

    private void subirImagenFirebase(){
        Date fechaActual = new Date();
        Long fechaMilis = fechaActual.getTime();
        StorageReference filePath = storageReference.child("Productos").child(fechaMilis.toString() + getFileExtension(rutaArchivoUri));
        filePath.putFile(rutaArchivoUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                filePath.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        firebaseUrlImage = task.getResult().toString();
                        rutaImgenTextView.setText(firebaseUrlImage);
                        esImagenCargada = true;
                    }
                });
            }
        });
    }

    private ActivityResultLauncher<Intent> obtenerImagenGaleria = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        rutaArchivoUri = result.getData().getData();
                        subirImagenFirebase();
                    }
                }
            }
    );

    private String getFileExtension(Uri uri){
        ContentResolver contentResolver = GUI_CU_02_Modificar_Producto.this.getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        obtenerImagenGaleria = null;
    }
}