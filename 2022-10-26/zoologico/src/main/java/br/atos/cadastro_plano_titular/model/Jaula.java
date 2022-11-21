package br.atos.cadastro_plano_titular.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_JAULA")
public class Jaula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int numeroJaula;
    private String nomeZoologico;
    private String bloco;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="TB_CUIDADOR_JAULA",
            joinColumns={@JoinColumn(name="cuidador_id")},
            inverseJoinColumns={@JoinColumn(name="jaula_id")})
    private List<Cuidador> cuidadores;


    public String getNomeZoologico() {
        return nomeZoologico;
    }

    public void setNomeZoologico(String nomeZoologico) {
        this.nomeZoologico = nomeZoologico;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public int getNumeroJaula() {
        return numeroJaula;
    }

    public void setNumeroJaula(int numeroJaula) {
        this.numeroJaula = numeroJaula;
    }

    public List<Cuidador> getCuidadores() {
        return cuidadores;
    }

    public void setCuidadores(List<Cuidador> cuidadores) {
        this.cuidadores = cuidadores;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
