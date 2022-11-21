package br.com.atos.model;

public class Gerente extends Funcionario {

    private int id;
    private String estado;
    private Double metaEstado;

    Gerente(String nome, Double salarioLiquido,String cpf) {
        super(nome,salarioLiquido,cpf);
    }

    public Gerente() {

    }

  
    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getMetaEstado() {
		return metaEstado;
	}

	public void setMetaEstado(Double metaEstado) {
		this.metaEstado = metaEstado;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Double calcularSalario(Double horaTrabalhada) {
        Double desconto = 1 - 0.15;
        Double salario = (60 * horaTrabalhada*desconto);
        return salario;
    }

    @Override
    public String toString() {
        return  "\nIdentificador: "+id+
                "\nCargo: "+super.getCargo().getDescricao() +
                "\nCpf: "  +super.getCpf()   +
                "\nNome: " +super.getNome() +
                "\nSalario liquido: " +super.getSalarioLiquido()  +
                "\nRegiao: " +estado +
                "\nMeta Regional: " +metaEstado +"\n";
    }
}
