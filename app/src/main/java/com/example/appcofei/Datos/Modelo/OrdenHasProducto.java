package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrdenHasProducto {

    @SerializedName("Producto_idProducto")
    @Expose
    private Integer idProducto;

    @SerializedName("Orden_idOrden")
    @Expose
    private Integer idOrden;

    @SerializedName("cantidadProducto")
    @Expose
    private Integer cantidadProducto;

    @SerializedName("subtotal")
    @Expose
    private String subTotal;

    private Integer codigoRespuestaServidor;
    private List<Orden> listaOrdenes;
    private List<Producto> listaProductos;

    public OrdenHasProducto() {
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public List<Orden> getListaOrdenes() {
        return listaOrdenes;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }

    public void setListaOrdenes(List<Orden> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
