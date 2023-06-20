package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Empleado {

    @SerializedName("idEmpleado")
    @Expose
    private Integer idEmpleado;

    @SerializedName("ConfiguracionPerfil_idConfiguracionPerfil")
    @Expose
    private Integer idConfiguracionPerfil;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("apellidoPaterno")
    @Expose
    private String apellidoPaterno;

    @SerializedName("apellidoMaterno")
    @Expose
    private String apellidoMaterno;

    @SerializedName("contrasena")
    @Expose
    private String contrasena;

    @SerializedName("claveTrabajador")
    @Expose
    private String claveTrabajador;

    @SerializedName("numeroTelefono")
    @Expose
    private String numeroTelefono;

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("correo")
    @Expose
    private String correo;

    @SerializedName("esCuentaConfirmada")
    @Expose
    private Boolean esCuentaConfirmada;

    @SerializedName("cargo")
    @Expose
    private String cargo;

    private Integer codigoRespuestaServidor;
    private ConfiguracionPerfil configuracionPerfilEmpleado;

    public Empleado() {
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public Integer getIdConfiguracionPerfil() {
        return idConfiguracionPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getClaveTrabajador() {
        return claveTrabajador;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getToken() {
        return token;
    }

    public String getCorreo() {
        return correo;
    }

    public Boolean getEsCuentaConfirmada() {
        return esCuentaConfirmada;
    }

    public String getCargo() {
        return cargo;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public ConfiguracionPerfil getConfiguracionPerfilEmpleado() {
        return configuracionPerfilEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setIdConfiguracionPerfil(Integer idConfiguracionPerfil) {
        this.idConfiguracionPerfil = idConfiguracionPerfil;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setClaveTrabajador(String claveTrabajador) {
        this.claveTrabajador = claveTrabajador;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEsCuentaConfirmada(Boolean esCuentaConfirmada) {
        this.esCuentaConfirmada = esCuentaConfirmada;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }

    public void setConfiguracionPerfilEmpleado(ConfiguracionPerfil configuracionPerfilEmpleado) {
        this.configuracionPerfilEmpleado = configuracionPerfilEmpleado;
    }
}
