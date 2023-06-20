package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Votacion {

    @SerializedName("idVotacion")
    @Expose
    public Integer idVotacion;

    @SerializedName("fechaInicioVotacion")
    @Expose
    public Date fechaInicioVotacion;

    @SerializedName("fechaCierreVotacion")
    @Expose
    public Date fechaCierreVotacion;

    public Integer codigoRespuestaServidor;

    public Votacion() {
    }

    public Integer getIdVotacion() {
        return idVotacion;
    }

    public Date getFechaInicioVotacion() {
        return fechaInicioVotacion;
    }

    public Date getFechaCierreVotacion() {
        return fechaCierreVotacion;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public void setIdVotacion(Integer idVotacion) {
        this.idVotacion = idVotacion;
    }

    public void setFechaInicioVotacion(Date fechaInicioVotacion) {
        this.fechaInicioVotacion = fechaInicioVotacion;
    }

    public void setFechaCierreVotacion(Date fechaCierreVotacion) {
        this.fechaCierreVotacion = fechaCierreVotacion;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }
}
