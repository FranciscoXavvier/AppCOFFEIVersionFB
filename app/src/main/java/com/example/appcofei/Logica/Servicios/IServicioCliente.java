package com.example.appcofei.Logica.Servicios;

import com.example.appcofei.Datos.Modelo.Cliente;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IServicioCliente {

    @POST("Clientes/Registrar")
    Call<Cliente> RegistrarCliente (@Body Cliente cliente);

    @POST("Clientes/IniciarSesion")
    @FormUrlEncoded
    Call<Cliente> IniciarSesion(
            @Field("matricula") String matricula,
            @Field("contrasena") String contrasena
    );
}
