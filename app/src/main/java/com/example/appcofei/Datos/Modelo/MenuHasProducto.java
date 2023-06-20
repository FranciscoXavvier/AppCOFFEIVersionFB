package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MenuHasProducto {

    @SerializedName("Producto_idProducto")
    @Expose
    private Integer idProducto;

    @SerializedName("Menu_idMenu")
    @Expose
    private Integer idMenu;

    private Integer codigoRespuestaServidor;
    private Producto producto;
    private Menu menu;

    public MenuHasProducto() {
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public Producto getProducto() {
        return producto;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
