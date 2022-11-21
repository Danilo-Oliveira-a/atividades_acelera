import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Menu menu = new Menu();
        List<Usuario> usuarios = usuariosCadastrados();
        RepositorioGerenteImpl repositorioGerente = new RepositorioGerenteImpl();
        RepositorioCoordenadorImpl repositorioCoordenador = new RepositorioCoordenadorImpl();

        Scanner sn = new Scanner(System.in);
        String senhaDigitada=null;
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
        if(usuarioSistemaExistente) {
            nomeUsuarioSistema =  usuarios.stream()
                    .filter(c -> c.getUsuario().equals(finalUsuario))
                    .findAny().get().getNome();
        }
        while (!usuarioSistemaExistente){
            System.out.println("****** Usuario Incorreto  ******");
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
                        .findAny().get().getNome();
            }

        }
        System.out.println("\n##########################################################");
        System.out.printf ("######## Seja Bem Vindo %s  ########\n", nomeUsuarioSistema);
        System.out.println("##########################################################\n");
        int opcaoMenu= menu.exibeMenu(sn, repositorioGerente,repositorioCoordenador);
        while (opcaoMenu != 1) {
            opcaoMenu = menu.exibeMenu(sn, repositorioGerente,repositorioCoordenador);
        }
    }


    public static List<Usuario>usuariosCadastrados(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario u1 = new Usuario();
        u1.setUsuario("admin");
        u1.setSenha("admin");
        u1.setNome("Danilo Oliveira");
        usuarios.add(u1);
        return  usuarios;
    }
}
