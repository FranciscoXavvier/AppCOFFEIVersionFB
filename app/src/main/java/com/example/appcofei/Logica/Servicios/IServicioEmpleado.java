package com.example.appcofei.Logica.Servicios;

import com.example.appcofei.Datos.Modelo.Cliente;
import com.example.appcofei.Datos.Modelo.Empleado;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IServicioEmpleado {

    @POST("Empleados/Registrar")
    Call<Empleado> RegistrarEmpleado (@Body Empleado empleado);

    @POST("Empleados/IniciarSesion")
    @FormUrlEncoded
    Call<Empleado> IniciarSesion(
            @Field("claveTrabajador") String claveTrabajador,
            @Field("contrasena") String contrasena
    );

}
