package com.example.appcofei.Datos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfiguracionPerfil {

    @SerializedName("idConfiguracionPerfil")
    @Expose
    private Integer idConfiguracionPerfil;

    @SerializedName("tamanoLetra")
    @Expose
    private Integer tamanoLetra;

    @SerializedName("tipoLetra")
    @Expose
    private String tipoLetra;

    @SerializedName("nombreTema")
    @Expose
    private String nombreTema;

    private Integer codigoRespuestaServidor;

    public ConfiguracionPerfil() {
    }

    public Integer getIdConfiguracionPerfil() {
        return idConfiguracionPerfil;
    }

    public Integer getTamanoLetra() {
        return tamanoLetra;
    }

    public String getTipoLetra() {
        return tipoLetra;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public Integer getCodigoRespuestaServidor() {
        return codigoRespuestaServidor;
    }

    public void setIdConfiguracionPerfil(Integer idConfiguracionPerfil) {
        this.idConfiguracionPerfil = idConfiguracionPerfil;
    }

    public void setTamanoLetra(Integer tamanoLetra) {
        this.tamanoLetra = tamanoLetra;
    }

    public void setTipoLetra(String tipoLetra) {
        this.tipoLetra = tipoLetra;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public void setCodigoRespuestaServidor(Integer codigoRespuestaServidor) {
        this.codigoRespuestaServidor = codigoRespuestaServidor;
    }
}
