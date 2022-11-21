public class Coordenador extends Funcionario{

    private String loja;
    private Double metaDaLoja;

    Coordenador(String nome, Double salarioLiquido, String cpf, String loja, Double metaDaLoja) {
        super(nome,salarioLiquido,cpf);
        this.loja = loja;
        this.metaDaLoja = metaDaLoja;
    }
    Coordenador(){

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

    @Override
    public Double calcularSalario(Double horaTrabalhada) {
        Double desconto = 1 - 0.07;
        Double salario = (40 * horaTrabalhada*desconto);
        return salario;
    }
    @Override
    public String toString() {
        return "\n----- Coordenador -----\n\nCpf: " +super.getCpf() + "\n" +
                "Nome: " +super.getNome() + "\n" +
                "Salario liquido: " +super.getSalarioLiquido() + "\n" +
                "Loja: " +loja+ "\n" +
                "Meta Loja: " +metaDaLoja +"\n";
    }
}
