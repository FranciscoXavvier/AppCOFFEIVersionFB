package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Producto implements Serializable {

    @SerializedName("idProducto")
    @Expose
    private Integer idProducto;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("cantidadExistencia")
    @Expose
    private Integer cantidadExistencia;

    @SerializedName("tamanoProducto")
    @Expose
    private String tamanoProducto;

    @SerializedName("categoria")
    @Expose
    private String categoria;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("marca")
    @Expose
    private String marca;

    @SerializedName("precio")
    @Expose
    private Float precio;

    @SerializedName("puntosFidelidad")
    @Expose
    private Integer puntosFidelidad;

    @SerializedName("rutaImagen")
    @Expose
    private String rutaImagen;

    @SerializedName("esVotable")
    @Expose
    private Boolean esVotable;

    @SerializedName("tipoEnvase")
    @Expose
    private String tipoEnvase;

    private Integer codigoRespuestaServidor;

    public Producto() {
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidadExistencia() {
        return cantidadExistencia;
    }

    public String getTamanoProducto() {
        return tamanoProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public Float getPrecio() {
        return precio;
    }

    public Integer getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public Boolean getEsVotable() {
        return esVotable;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadExistencia(Integer cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public void setTamanoProducto(String tamanoProducto) {
        this.tamanoProducto = tamanoProducto;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setPuntosFidelidad(Integer puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void setEsVotable(Boolean esVotable) {
        this.esVotable = esVotable;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }

    @Override
    public String toString(){
        return "ID: " + getIdProducto() + "Nombre: " + getNombre() + "Precio: " + getPrecio();
    }
}
