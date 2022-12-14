import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        List<Usuario> usuarios = usuariosCadastrados();

        Scanner sn = new Scanner(System.in);
        String senhaDigitada=null;
        List<Gerente>gerentes = new ArrayList<>();
        List<Coordenador>coordenadores = new ArrayList<>();


        System.out.println("###### LOGIN SISTEMA #########");
        System.out.print("Digite o usuario: ");
        String usuario = sn.next();
        System.out.print("Digite a senha: ");
        senhaDigitada = sn.next();

        String finalUsuario= usuario;
        String finalSenhaDigitada = senhaDigitada;
        boolean usuarioSistemaExistente = usuarios.stream()
                .filter(n->n.getUsuario().equals(finalUsuario)&& n.getSenha().equals(finalSenhaDigitada))
                .findFirst().isPresent();
        String codigoUsuario=null;
        String nomeUsuarioSistema = null;
        while (!usuarioSistemaExistente){
            System.out.println("****** Usuario Incorreto :( ******");
            System.out.print("Digite o usuario: ");
            usuario = sn.next();
            System.out.print("Digite a senha: ");
            senhaDigitada = sn.next();
            String finalUsuarioN= usuario;
            String finalSenhaDigitadaN = senhaDigitada;
            usuarioSistemaExistente = usuarios.stream()
                    .filter(n->n.getUsuario().equals(finalUsuarioN)&& n.getSenha().equals(finalSenhaDigitadaN))
                    .findFirst().isPresent();
            if(usuarioSistemaExistente) {
                nomeUsuarioSistema =  usuarios.stream()
                        .filter(c -> c.getUsuario().equals(finalUsuarioN))
                        .findFirst().get().getNome();
            }
        }
        System.out.printf("###### BEM VINDO %s  #########\n\n", nomeUsuarioSistema);
        cadastrarUsuarios(sn, gerentes, coordenadores);
        int fimCadastro = 0;
        System.out.print("Escolha\n1 - Sair\n2 - Cadastrar usuario\n:");
        fimCadastro = sn.nextInt();
        while (fimCadastro != 1) {
            cadastrarUsuarios(sn, gerentes, coordenadores);
            System.out.print("Escolha\n1 - Sair\n2 - Cadastrar usuario\n:");
            fimCadastro = sn.nextInt();
        }
        if (!coordenadores.isEmpty()) {
            coordenadores.stream().forEach(c -> System.out.println(c.toString()));
        }
        if (!gerentes.isEmpty()) {
            gerentes.stream().forEach(g -> System.out.println(g.toString()));
        }

    }
    public static void cadastrarUsuarios(Scanner sn, List<Gerente>gerentes, List<Coordenador>coordenadores) {
        String nome = null;
        int tipoFuncao = 0;
        String cpf = null;
        Double horaTrabalhada = 0d;
        String regiao = null;
        Double meta = 0d;
        String loja = null;

		sn = new Scanner(System.in);
        System.out.println("###### CADASTRO DE FUNCIONARIO #########");
        System.out.print("Digite o nome do funcionario: ");
        nome = sn.next();
        System.out.print("Digite o CPF do funcionario: ");
        cpf = sn.next();
        System.out.print("Digite a hora trabalhada do funcionario: ");
        horaTrabalhada = sn.nextDouble();
        System.out.print("Digite a fun????o do funcionario\n1 - Gerente\n2 - Coordenador\n:");
        tipoFuncao = sn.nextInt();
        while (tipoFuncao != 1 && tipoFuncao != 2) {
            System.out.println("Fun??ao incorreta, escolha entre:");
            System.out.print("\n1 - Gerente\n2 - Coordenador\n:");
            tipoFuncao = sn.nextInt();
        }

        //gerente
        if (tipoFuncao == 1) {
            System.out.print("Digite sua Regi??o: ");
            regiao = sn.next();
            System.out.print("Digite a meta da sua Regi??o: ");
            meta = sn.nextDouble();

            Gerente g1 = new Gerente();
            g1.setNome(nome);
            g1.setCpf(cpf);
            Double salarioLiq = g1.calcularSalario(horaTrabalhada);
            g1.setSalarioLiquido(salarioLiq);
            g1.setRegional(regiao);
            g1.setMetaRegional(meta);
            gerentes.add(g1);
        }
        //coordenador
        else {
			sn = new Scanner(System.in);
            System.out.println("Digite o nome da Loja: ");
            loja = sn.next();
            System.out.println("Digite a meta da Loja: ");
            meta = sn.nextDouble();

            Coordenador c1 = new Coordenador();
            c1.setNome(nome);
            c1.setCpf(cpf);
            c1.setSalarioLiquido(c1.calcularSalario(horaTrabalhada));
            c1.setLoja(loja);
            c1.setMetaDaLoja(meta);
            coordenadores.add(c1);
        }
    }
    public static List<Usuario>usuariosCadastrados(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario u1 = new Usuario();
        u1.setUsuario("admin");
        u1.setSenha("admin");
        u1.setNome("Danilo Oliveira");
        usuarios.add(u1);

        Usuario u2 = new Usuario();
        u2.setUsuario("teste");
        u2.setSenha("teste");
        u2.setNome("Teste da Silfva");

        usuarios.add(u2);

        return  usuarios;
    }
}
