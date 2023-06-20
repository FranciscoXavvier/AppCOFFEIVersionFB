package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cliente {

    @SerializedName("idCliente")
    @Expose
    private Integer idCliente;

    @SerializedName("Tarjeta_idTarjeta")
    @Expose
    private Integer idTarjeta;

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

    @SerializedName("matricula")
    @Expose
    private String matricula;

    @SerializedName("numeroTelefono")
    @Expose
    private String numeroTelefono;

    @SerializedName("correo")
    @Expose
    private String correo;

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("esCuentaConfirmada")
    @Expose
    private Boolean esCuentaConfirmada;

    private Integer codigoRespuestaServidor;
    private Tarjeta tarjetaCliente;
    private ConfiguracionPerfil configuracionPerfilCliente;

    public Cliente() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public Integer getIdConfiguracionPerfil() {
        return idConfiguracionPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getToken() {
        return token;
    }

    public Boolean getEsCuentaConfirmada() {
        return esCuentaConfirmada;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public Tarjeta getTarjetaCliente() {
        return tarjetaCliente;
    }

    public ConfiguracionPerfil getConfiguracionPerfilCliente() {
        return configuracionPerfilCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public void setIdConfiguracionPerfil(Integer idConfiguracionPerfil) {
        this.idConfiguracionPerfil = idConfiguracionPerfil;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setEsCuentaConfirmada(Boolean esCuentaConfirmada) {
        this.esCuentaConfirmada = esCuentaConfirmada;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }

    public void setTarjetaCliente(Tarjeta tarjetaCliente) {
        this.tarjetaCliente = tarjetaCliente;
    }

    public void setConfiguracionPerfilCliente(ConfiguracionPerfil configuracionPerfilCliente) {
        this.configuracionPerfilCliente = configuracionPerfilCliente;
    }
}
