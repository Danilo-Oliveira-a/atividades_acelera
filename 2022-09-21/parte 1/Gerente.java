public class Gerente extends  Funcionario{

    private String regional;
    private Double metaRegional;

    Gerente(String nome, Double salarioLiquido,String cpf) {
        super(nome,salarioLiquido,cpf);
    }

    public Gerente() {

    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public Double getMetaRegional() {
        return metaRegional;
    }

    public void setMetaRegional(Double metaRegional) {
        this.metaRegional = metaRegional;
    }
    @Override
    public Double calcularSalario(Double horaTrabalhada) {
        Double desconto = 1 - 0.15;
        Double salario = (60 * horaTrabalhada*desconto);
        return salario;
    }

    @Override
    public String toString() {
        return "\n----- Gerente -----\nCpf: " +super.getCpf() + "\n" +
                "Nome: " +super.getNome() + "\n" +
                "Salario liquido: " +super.getSalarioLiquido() + "\n" +
                "Regiao: " +regional+ "\n" +
                "Meta Regional: " +metaRegional +"\n";
    }
}
