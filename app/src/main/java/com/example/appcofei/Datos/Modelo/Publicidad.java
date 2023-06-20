package com.example.appcofei.Datos.Modelo;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Publicidad {

    @SerializedName("idPublicidad")
    @Expose
    private Integer idPublicidad;

    @SerializedName("fechaInicio")
    @Expose
    private Date fechaInicio;

    @SerializedName("fechaFin")
    @Expose
    private Date fechaFin;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("rutaImagen")
    @Expose
    private String rutaImagen;

    private Integer codigoRespuestaServidor;

    public Publicidad() {
    }

    public Integer getIdPublicidad() {
        return idPublicidad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public void setIdPublicidad(Integer idPublicidad) {
        this.idPublicidad = idPublicidad;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }
}
