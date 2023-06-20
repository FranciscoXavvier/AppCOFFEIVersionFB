package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tarjeta {

    @SerializedName("idTarjeta")
    @Expose
    public Integer idTarjeta;

    @SerializedName("numeroTarjeta")
    @Expose
    public String numeroTarjeta;

    @SerializedName("cuentaPaypal")
    @Expose
    public String cuentaPaypal;

    @SerializedName("dinero")
    @Expose
    public Float dinero;

    @SerializedName("puntosAcumulados")
    @Expose
    public Integer puntosAcumulados;

    public Integer codigoRespuestaServidor;

    public Tarjeta() {
    }

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getCuentaPaypal() {
        return cuentaPaypal;
    }

    public Float getDinero() {
        return dinero;
    }

    public Integer getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setCuentaPaypal(String cuentaPaypal) {
        this.cuentaPaypal = cuentaPaypal;
    }

    public void setDinero(Float dinero) {
        this.dinero = dinero;
    }

    public void setPuntosAcumulados(Integer puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }
}
