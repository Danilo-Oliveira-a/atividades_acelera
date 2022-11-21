package br.atos.cadastro_plano_titular.model;

import javax.persistence.*;
import java.io.Serializable;
@Embeddable
public class Endereco implements Serializable {

    private String cidade;
    private String rua;
    private String numero;


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

