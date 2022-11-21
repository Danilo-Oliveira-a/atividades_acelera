import java.util.Scanner;

public class Menu {

    public int exibeMenu(Scanner sn, RepositorioGerenteImpl gerenteImpl, RepositorioCoordenadorImpl coordenadorImpl) {
        System.out.print("Escolha" +
                "\n1 - Sair" +
                "\n2 - Listar Funcionarios " +
                "\n3 - Cadastrar Funcionario" +
                "\n4 - Alterar Funcionario" +
                "\n5 - Exluir  Funcionario\n:");
        int opcaoMenu = sn.nextInt();
        if (opcaoMenu == 2)
            listaFuncionarios(gerenteImpl, coordenadorImpl,opcaoMenu);
        else if (opcaoMenu == 3)
            cadastrarFuncionario(gerenteImpl, coordenadorImpl,opcaoMenu,0);
        else if (opcaoMenu == 4)
            alterarFuncionario(gerenteImpl, coordenadorImpl,opcaoMenu);
        else if (opcaoMenu == 5)
            deletarFuncionario(gerenteImpl, coordenadorImpl,opcaoMenu);
        else
            System.out.print("Programa Finalizado!!");

        return opcaoMenu;
    }

    public void mostrarCoordenadores(RepositorioCoordenadorImpl coordenador) {
        System.out.println("===========LISTA DE COORDENADORES ========");
        if (!coordenador.listarCoordenadores().isEmpty()) {
            coordenador.listarCoordenadores().stream().forEach(c -> System.out.println(c.toString()));
        }
        else
            System.out.println("!!!! Nenhum Coordenador Encontrado!!!!! ");
    }
    public void mostrarGerentes(RepositorioGerenteImpl gerente) {
        System.out.println("\n===========LISTA DE GERENTES ========");
        if (!gerente.listarGerentes().isEmpty()) {
            gerente.listarGerentes().stream().forEach(g -> System.out.println(g.toString()));
        }
        else
            System.out.println("!!!! Nenhum Gerente Encontrado!!!!! ");
    }
    public void listaFuncionarios(RepositorioGerenteImpl gerente, RepositorioCoordenadorImpl coordenador, int opcaoMenu) {
        mostrarGerentes(gerente);
        mostrarCoordenadores(coordenador);
    }

    public void cadastrarFuncionario(RepositorioGerenteImpl gerenteImpl, RepositorioCoordenadorImpl coordenadorImpl, int opcaoMenu,int tipoFuncao) {

        String nome = null;

        String cpf = null;
        Double horaTrabalhada = 0d;
        String regiao = null;
        Double meta = 0d;
        String loja = null;

        estiloMenu(opcaoMenu);
        Scanner sn = new Scanner(System.in);
        System.out.print("Digite o nome do funcionario: ");
        nome = sn.nextLine();
        System.out.print("Digite o CPF do funcionario: ");
        cpf = sn.next();
        System.out.print("Digite a hora trabalhada do funcionario: ");
        horaTrabalhada = sn.nextDouble();
        if(tipoFuncao==0) {
            System.out.print("Digite a funcao do funcionario\n1 - Gerente\n2 - Coordenador\n:");
            tipoFuncao = opcao("\n1 - Gerente\n2 - Coordenador\n:");
        }
        //gerente
        if (tipoFuncao == 1) {
            System.out.print("Digite sua Regiao: ");
            regiao = sn.next();
            System.out.print("Digite a meta da sua Regiao: ");
            meta = sn.nextDouble();
            Gerente gerente = new Gerente();
            gerente.setNome(nome);
            gerente.setCpf(cpf);
            Double salarioLiq = gerente.calcularSalario(horaTrabalhada);
            gerente.setSalarioLiquido(salarioLiq);
            gerente.setRegional(regiao);
            gerente.setMetaRegional(meta);
            gerente.setCargo(TipoFuncionario.GERENTE);
            gerenteImpl.salvarGerente(gerente);
        }
        //coordenador
        else {
            sn = new Scanner(System.in);
            System.out.print("Digite o nome da Loja: ");
            loja = sn.nextLine();
            System.out.print("Digite a meta da Loja: ");
            meta = sn.nextDouble();
            Coordenador coordenador = new Coordenador();
            coordenador.setNome(nome);
            coordenador.setCpf(cpf);
            coordenador.setSalarioLiquido(coordenador.calcularSalario(horaTrabalhada));
            coordenador.setLoja(loja);
            coordenador.setMetaDaLoja(meta);
            coordenador.setCargo(TipoFuncionario.COORDENADOR);
            coordenadorImpl.salvarCoordenador(coordenador);
        }

    }

    public void alterarFuncionario(RepositorioGerenteImpl gerenteImpl, RepositorioCoordenadorImpl coordenadorImpl, int opcaoMenu) {
        int tipoFuncao = 0;
        String cpf = null;
        estiloMenu(opcaoMenu);
        System.out.print("Digite a funcao do funcionario\n1 - Gerente\n2 - Coordenador\n:");
        tipoFuncao = opcao("\n1 - Gerente\n2 - Coordenador\n:");

        //existe gerente para alterar
        if(gerenteImpl.listarGerentes()!=null &&
                !gerenteImpl.listarGerentes().isEmpty()) {
            existeFuncionario(gerenteImpl,coordenadorImpl,opcaoMenu,tipoFuncao);
        }
        else{
            naoExisteFuncionarioCadastrado(gerenteImpl,coordenadorImpl,opcaoMenu,tipoFuncao);
        }
    }

    public void excluirFuncionario(RepositorioGerenteImpl gerenteImpl, RepositorioCoordenadorImpl coordenadorImpl, int opcaoMenu,int tipoFuncao) {
        //existe gerente para alterar
        if(gerenteImpl.listarGerentes()!=null &&
                !gerenteImpl.listarGerentes().isEmpty()) {
            existeFuncionario(gerenteImpl,coordenadorImpl,opcaoMenu,tipoFuncao);
        }
        else{
            naoExisteFuncionarioCadastrado(gerenteImpl,coordenadorImpl,opcaoMenu,tipoFuncao);
        }
    }

    private void existeFuncionario(RepositorioGerenteImpl gerenteImpl, RepositorioCoordenadorImpl coordenadorImpl,int opcaoMenu,int tipoFuncao){
        System.out.println("\nEscolha uma opcao abaixo");
        String msgMostrar = "1 - Digite identificador para alterar\n2 - Listar gerentes\n: ";
        if(opcaoMenu==5)
            msgMostrar = "1 - Digite identificador para exluir\n2 - Listar gerentes\n: ";
        System.out.print(msgMostrar);
        int opcao = opcao(msgMostrar);
        if (opcao == 1) {
            //alterar
            if(opcaoMenu==4) {
                if (tipoFuncao == 1) alterar(gerenteImpl, coordenadorImpl, tipoFuncao);
                else if (tipoFuncao == 2) alterar(gerenteImpl, coordenadorImpl, tipoFuncao);
            }//excluir
            else if(opcaoMenu==5) {
                excluir(gerenteImpl,coordenadorImpl,tipoFuncao);
            }

        } else {
            if(tipoFuncao==1)mostrarGerentes(gerenteImpl);
            else if(tipoFuncao==2)mostrarCoordenadores(coordenadorImpl);
            System.out.println("\nEscolha uma opcao abaixo");
            System.out.print(msgMostrar);
            opcao = opcao(msgMostrar);
            if (opcao == 1) {
                //alterar
                if(opcaoMenu==4) {
                    if (tipoFuncao == 1) alterar(gerenteImpl, coordenadorImpl, tipoFuncao);
                    else if (tipoFuncao == 2) alterar(gerenteImpl, coordenadorImpl, tipoFuncao);
                }//excluir
                else if(opcaoMenu==5) {
                    excluir(gerenteImpl,coordenadorImpl,tipoFuncao);
                }
            } else {
                exibeMenu(new Scanner(System.in),gerenteImpl,coordenadorImpl);
            }
        }
    }
    private void naoExisteFuncionarioCadastrado(RepositorioGerenteImpl gerenteImpl, RepositorioCoordenadorImpl coordenadorImpl,int opcaoMenu,int tipoFuncao){
        System.out.print("Nao existe funcionarário cadastrado nesse cargo , deseja cadastrar?");
        String msgNaoExiste = "\n1 - Sim, Cadastrar\n2 - Voltar ao Menu principal\n:";
        System.out.print(msgNaoExiste);
        int opcaoAlteracao = opcao(msgNaoExiste);
        if(opcaoAlteracao==1){
            opcaoMenu =3;
            cadastrarFuncionario(gerenteImpl,coordenadorImpl,opcaoMenu,tipoFuncao);
        }
        else{
            exibeMenu(new Scanner(System.in),gerenteImpl,coordenadorImpl);
        }
    }

    private void excluir(RepositorioGerenteImpl gerenteImpl, RepositorioCoordenadorImpl coordenadorImpl,int funcao){
        Scanner sn = new Scanner(System.in);
        System.out.print("\nIdentificador: ");
        int id = sn.nextInt();
        if(funcao==1){
            int finalId1 = id;
            boolean existe = gerenteImpl.listarGerentes().stream().filter(d->d.getId()== finalId1).findFirst().isPresent();
            while (!existe) {
                System.out.println("\nNao existe nenhum Gerente com esse identidicador!!: ");
                System.out.print("Insira outro identificador: ");
                id = sn.nextInt();
                int finalId2 = id;
                existe = gerenteImpl.listarGerentes().stream().filter(d->d.getId()== finalId2).findFirst().isPresent();
            }
            Gerente gerente = new Gerente();
            gerente.setId(id);
            gerenteImpl.deletarGerente(gerente);
        }
        else if(funcao==2){
            int finalId = id;
            if(!coordenadorImpl.listarCoordenadores().stream().filter(d->d.getId()==finalId).findFirst().isPresent()){
                System.out.print("\nNao existe nenhum Coordenador com esse identidicador!!: ");
                while (!coordenadorImpl.listarCoordenadores().stream().filter(d->d.getId()==finalId).findFirst().isPresent()) {
                    System.out.println("\nNao existe nenhum Coordenador com esse identidicador!!: ");
                    System.out.print("Insira outro identificador: ");
                    id = sn.nextInt();
                }
            }
            Coordenador coordenador = new Coordenador();
            coordenador.setId(id);
            coordenadorImpl.deletarCoordenador(coordenador);
        }


    }
    private void alterar(RepositorioGerenteImpl gerenteImpl, RepositorioCoordenadorImpl coordenadorImpl, int funcao){
        Scanner sn = new Scanner(System.in);
        System.out.print("\nIdentificador: ");
        int id = sn.nextInt();
        if(funcao==1){
            int finalId1 = id;
            boolean existe = gerenteImpl.listarGerentes().stream().filter(d->d.getId()== finalId1).findFirst().isPresent();
            while (!existe) {
                System.out.println("\nNao existe nenhum Gerente com esse identidicador!!: ");
                System.out.print("Insira outro identificador: ");
                id = sn.nextInt();
                int finalId2 = id;
                existe = gerenteImpl.listarGerentes().stream().filter(d->d.getId()== finalId2).findFirst().isPresent();
            }
        }
        else if(funcao==2){
            int finalId = id;
            if(!coordenadorImpl.listarCoordenadores().stream().filter(d->d.getId()==finalId).findFirst().isPresent()){
                System.out.print("\nNao existe nenhum Coordenador com esse identidicador!!: ");
                while (!coordenadorImpl.listarCoordenadores().stream().filter(d->d.getId()==finalId).findFirst().isPresent()) {
                    System.out.println("\nNao existe nenhum Coordenador com esse identidicador!!: ");
                    System.out.print("Insira outro identificador: ");
                    id = sn.nextInt();
                }
            }
        }

        String msgAlterar = "Escolha a opcao que deseja alterar\n1 - Nome\n2 - Salario\n3 - Nome e Salario\n: ";
        System.out.print(msgAlterar);
        int opcaoAlteracao = opcaoTres(msgAlterar);
        if(opcaoAlteracao==1){
            if(funcao==1) alterarNomeGerente(gerenteImpl,id);
            if(funcao==2) alterarNomeCoordenador(coordenadorImpl,id);
        }
        if(opcaoAlteracao==2){
            if(funcao==1) alterarSalarioGerente(gerenteImpl,id);
            if(funcao==2) alterarSalarioCoordenador(coordenadorImpl,id);
        }
        if(opcaoAlteracao==3){
            if(funcao==1){
                alterarNomeGerente(gerenteImpl,id);
                alterarSalarioGerente(gerenteImpl,id);
            }
            if(funcao==2){
                alterarNomeCoordenador(coordenadorImpl,id);
                alterarSalarioCoordenador(coordenadorImpl,id);
            }
        }
    }

    private void alterarNomeGerente(RepositorioGerenteImpl gerenteImpl,int id){
        Scanner sn = new Scanner(System.in);
        System.out.print("Digite o nome do funcionario: ");
        String nome = sn.nextLine();
        Gerente gerente = new Gerente();
        gerente.setId(id);
        gerente.setNome(nome);
        gerenteImpl.alterarGerente(gerente);
    }
    private void alterarSalarioGerente(RepositorioGerenteImpl gerenteImpl,int id){
        Scanner sn = new Scanner(System.in);
        System.out.print("Digite o nome do funcionario: ");
        String nome = sn.nextLine();
        Gerente gerente = new Gerente();
        gerente.setId(id);
        gerente.setNome(nome);
        gerenteImpl.alterarGerente(gerente);
    }
    private void alterarNomeCoordenador(RepositorioCoordenadorImpl coordenadorImpl,int id){
        Scanner sn = new Scanner(System.in);
        System.out.print("Digite o nome do funcionario: ");
        String nome = sn.nextLine();
        Coordenador coordenador = new Coordenador();
        coordenador.setId(id);
        coordenador.setNome(nome);
        coordenadorImpl.alterarCoordenador(coordenador);
    }
    private void alterarSalarioCoordenador(RepositorioCoordenadorImpl coordenadorImpl,int id){
        Scanner sn = new Scanner(System.in);
        System.out.print("Digite o nome do funcionario: ");
        String nome = sn.nextLine();
        Coordenador coordenador = new Coordenador();
        coordenador.setId(id);
        coordenador.setNome(nome);
        coordenadorImpl.alterarCoordenador(coordenador);
    }
    public void deletarFuncionario(RepositorioGerenteImpl gerenteImpl, RepositorioCoordenadorImpl coordenadorImpl , int opcaoMenu) {
        int tipoFuncao = 0;
        String cpf = null;
        estiloMenu(opcaoMenu);
        System.out.print("Digite a funcao do funcionario\n1 - Gerente\n2 - Coordenador\n:");
        tipoFuncao = opcao("\n1 - Gerente\n2 - Coordenador\n:");
        excluirFuncionario(gerenteImpl,coordenadorImpl,opcaoMenu,tipoFuncao);
    }
    public void estiloMenu(int opcaoMenu){
        String funcionario="Funcionario";
        String tipoEstiloMenu = null;
        if(opcaoMenu==2){
            tipoEstiloMenu = "Lista";
            funcionario="Funcionarios";
        }
        if(opcaoMenu==3)tipoEstiloMenu = "Cadastro";
        if(opcaoMenu==4)tipoEstiloMenu = "Edicao";
        if(opcaoMenu==5)tipoEstiloMenu = "Exclusao";
        System.out.println("\n#############################################");
        System.out.printf     ("######## %s de %s  ########\n", tipoEstiloMenu,funcionario);
        System.out.println    ("#############################################\n");
    }

    public int opcao(String msgDaOpcao){
        Scanner sn = new Scanner(System.in);
        int opcao = sn.nextInt();
        while (opcao != 1 && opcao != 2) {
            System.out.println("\nOpcao incorreta!!");
            System.out.println("\nEscolha uma das opcoes abaixo");
            System.out.print(msgDaOpcao);
            opcao = sn.nextInt();
        }
        return opcao;
    }
    public int opcaoTres(String msgEscola){
        Scanner sn = new Scanner(System.in);
        int opcaoAlteracao = sn.nextInt();
        while (opcaoAlteracao != 1 && opcaoAlteracao != 2 &&opcaoAlteracao!=3) {
            System.out.println("\nOpcao incorreta!!");
            System.out.println("\nEscolha uma das opcoes abaixo");
            System.out.print(msgEscola);
            opcaoAlteracao = sn.nextInt();
        }
        return opcaoAlteracao;
    }


}

