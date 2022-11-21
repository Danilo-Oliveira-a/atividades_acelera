package br.com.atos.model;


public class Coordenador extends Funcionario {

    private int id;
    private String loja;
    private Double metaDaLoja;

    Coordenador(String nome, Double salarioLiquido, String cpf, String loja, Double metaDaLoja) {
        super(nome,salarioLiquido,cpf);
        this.loja = loja;
        this.metaDaLoja = metaDaLoja;
    }
 

    public Coordenador() {
		
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public Double getMetaDaLoja() {
        return metaDaLoja;
    }

    public void setMetaDaLoja(Double metaDaLoja) {
        this.metaDaLoja = metaDaLoja;
    }

    public Double calcularSalario(Double horaTrabalhada) {
        Double desconto = 1 - 0.07;
        Double salario = (40 * horaTrabalhada*desconto);
        return salario;
    }
    @Override
    public String toString() {
        return  "\nIdentificador: "+id+
                "\nCargo: "+super.getCargo().getDescricao() +
                "\nCpf: "  +super.getCpf()   +
                "\nNome: " +super.getNome() +
                "\nSalario liquido: " +super.getSalarioLiquido()  +
                "\nLoja: " +loja +
                "\nMeta Loja: " +metaDaLoja +"\n";
    }
}
