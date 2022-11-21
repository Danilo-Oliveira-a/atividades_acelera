package br.com.atos.enums;

public enum TipoFuncionario{

    GERENTE ("Gerente"),
    COORDENADOR("Coordenador");

    private String descricao;

    TipoFuncionario(String descricao) {
        this.descricao=descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
