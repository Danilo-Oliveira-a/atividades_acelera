public class Aluno extends Pessoa{
   private String turma;
   private String advertencia;


    public Aluno(String nome, String cpf) {
        super(nome, cpf);
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(String advertencia) {
        this.advertencia = advertencia;
    }
}
