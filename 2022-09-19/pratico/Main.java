import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Aluno a1 = new Aluno("Teste Da Silva", "000.654.123-00");
        a1.setTurma("Java Noturno");
        a1.setAdvertencia("Nenhuma");

        Aluno a2 = new Aluno("Paulo Da Silva", "432.654.123-12");
        a2.setTurma("Java Matutino");
        a2.setAdvertencia("Nenhuma");

        Aluno a3 = new Aluno("Danilo Da Silva", "432.654.123-12");
        a3.setTurma("Java Noturno");
        a3.setAdvertencia("Nenhuma");

        List<Aluno> alunos = Arrays.asList(a1,a2,a3);

        Professor p1 = new Professor("Joao Carlos Da Silva", "123.654.790-00");
        p1.setDisciplina("Java");
        p1.setSalario(5000d);

        System.out.println("***************************************");
        System.out.println("Professor: " + p1.getNome());
        System.out.println("CPF: " + p1.getCpf());
        System.out.println("Disciplina: " + p1.getDisciplina());
        System.out.println("Salario: " + p1.getSalario());
        System.out.println("***************************************");
        alunos.stream().forEach(a->{
            System.out.println("---------------------------------");
            System.out.println("Aluno: " + a.getNome());
            System.out.println("CPF: " + a.getCpf());
            System.out.println("turma: " + a.getTurma());
            System.out.println("advertencia: " + a.getAdvertencia());

        });

    }
}