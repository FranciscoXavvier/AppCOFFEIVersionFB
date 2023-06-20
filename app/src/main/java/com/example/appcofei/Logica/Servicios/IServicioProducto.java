package com.example.appcofei.Logica.Servicios;

import com.example.appcofei.Datos.Modelo.Cliente;
import com.example.appcofei.Datos.Modelo.Producto;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IServicioProducto {

    @GET("Productos/Buscar")
    Call<List<Producto>> ConsultarProductos(
            @Query("nombre") String nombre,
            @Query("categoria") String categoria,
            @Query("existencia") String existencia);

    @DELETE("Productos/Eliminar/{id}")
    Call<Void> eliminarProducto (@Path("id") int id);

    @PUT("Productos/Actualizar/{id}")
    Call<Producto> actualizarProducto (@Path("id") int id, @Body Producto producto);

    @POST("Productos/Registrar")
    Call<Producto> registrarProducto (@Body Producto producto);

    @Multipart
    @POST("Productos/SubirImagen")
    Call<ResponseBody> subirImagenProducto(@Part MultipartBody.Part file, @Part("ImagenProducto") RequestBody nombre);

}
