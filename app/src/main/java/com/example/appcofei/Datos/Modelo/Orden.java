package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.util.List;

public class Orden {

    @SerializedName("idOrden")
    @Expose
    private Integer idOrden;

    @SerializedName("Cliente_idCliente")
    @Expose
    private Integer idCliente;

    @SerializedName("direccionEntrega")
    @Expose
    private String direccionEntrega;

    @SerializedName("estado")
    @Expose
    private String estado;

    @SerializedName("fechaOrden")
    @Expose
    private Date fechaOrden;

    @SerializedName("metodoPago")
    @Expose
    private String metodoPago;

    @SerializedName("totalPagado")
    @Expose
    private Float totalPagado;

    private Integer codigoRespuestaServidor;
    private Cliente cliente;
    private List<Producto> listaProductos;

    public Orden() {
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public Float getTotalPagado() {
        return totalPagado;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setTotalPagado(Float totalPagado) {
        this.totalPagado = totalPagado;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
