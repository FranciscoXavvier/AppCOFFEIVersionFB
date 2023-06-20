package com.example.appcofei.Logica;

import com.example.appcofei.Logica.Servicios.IServicioCliente;
import com.example.appcofei.Logica.Servicios.IServicioEmpleado;
import com.example.appcofei.Logica.Servicios.IServicioProducto;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCliente {

    public static final String BASE_API_URL = "http://192.168.1.6:3000/api/";
    private static RetrofitCliente retrofitSinglenton;
    private Retrofit retrofit;

    private RetrofitCliente(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static synchronized RetrofitCliente getInstanceSinglenton(){
        if(retrofitSinglenton == null){
            retrofitSinglenton = new RetrofitCliente();
        }
        return retrofitSinglenton;
    }

    public IServicioCliente getApiServicioCliente(){
        return retrofit.create(IServicioCliente.class);
    }

    public IServicioProducto getApiServicioProducto(){
        return retrofit.create(IServicioProducto.class);
    }

    public IServicioEmpleado getApiServicioEmpleado(){
        return retrofit.create(IServicioEmpleado.class);
    }
}
