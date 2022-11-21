public class Professor extends Pessoa{
   private String disciplina;
   private Double salario;

    public Professor(String nome, String cpf) {
        super(nome, cpf);
    }


    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getSalario() {
        if(salario<0)
            return 0d;
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
