public class Gerente extends Funcionario {

    private int id;
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
                "\nRegiao: " +regional +
                "\nMeta Regional: " +metaRegional +"\n";
    }
}
