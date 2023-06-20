package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EleccionProducto {

    @SerializedName("Votacion_idVotacion")
    @Expose
    private Integer idVotacion;

    @SerializedName("Producto_idProducto")
    @Expose
    private Integer idProducto;

    @SerializedName("Cliente_idCliente")
    @Expose
    private Integer idCliente;

    private Integer codigoRespuestaServidor;
    private Votacion votacion;
    private Producto producto;
    private Cliente cliente;

    public EleccionProducto() {
    }

    public Integer getIdVotacion() {
        return idVotacion;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public Votacion getVotacion() {
        return votacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdVotacion(Integer idVotacion) {
        this.idVotacion = idVotacion;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }

    public void setVotacion(Votacion votacion) {
        this.votacion = votacion;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
