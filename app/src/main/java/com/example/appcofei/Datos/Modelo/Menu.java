package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Menu {

    @SerializedName("idMenu")
    @Expose
    private Integer idMenu;

    @SerializedName("idPublicidad")
    @Expose
    private Integer idPublicidad;

    @SerializedName("fechaInicio")
    @Expose
    private Date fechaInicio;

    @SerializedName("fechaExpiracion")
    @Expose
    private Date fechaExpiracion;

    @SerializedName("nombreProductoGanador")
    @Expose
    private String nombreProductoGanador;

    private Integer codigoRespuestaServidor;

    public Menu() {
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public Integer getIdPublicidad() {
        return idPublicidad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public String getNombreProductoGanador() {
        return nombreProductoGanador;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public void setIdPublicidad(Integer idPublicidad) {
        this.idPublicidad = idPublicidad;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public void setNombreProductoGanador(String nombreProductoGanador) {
        this.nombreProductoGanador = nombreProductoGanador;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }
}
