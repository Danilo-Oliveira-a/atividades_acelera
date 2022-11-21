import java.util.ArrayList;
import java.util.List;

public class RepositorioGerenteImpl implements RepositorioGerenteInterface{


    private List<Gerente> gerentes = new ArrayList<>();
    boolean sucesso = true;

    @Override
    public List<Gerente> listarGerentes() {
        return this.gerentes;
    }

    @Override
    public Gerente listarGerentePorId(Gerente gerente) {
        return  new Gerente();
    }

    @Override
    public boolean salvarGerente(Gerente gerente) {
        try{
            gerentes = listarGerentes();
            int id = gerentes!=null?gerentes.size()>0?gerentes.size()+1:1:1;
            gerente.setId(id);
            gerentes.add(gerente);
            System.out.println("\nGerente cadastrado com sucesso!!\n");
        }
        catch (Exception exception){
            sucesso =false;
            System.out.println("\ncatch: Erro ao alterar gerente!!!!\n");
        }
        return sucesso;
    }

    @Override
    public boolean alterarGerente(Gerente gerente) {
        try {
            gerentes = listarGerentes();
            if(!gerentes.stream()
                    .filter(g->g.getId()==gerente.getId()).findFirst().isPresent()){
                System.out.printf("\nNenhum gerente encontrado com esse cpf: %s",gerente.getCpf());
                return false;
            }
            for (Gerente g:gerentes) {
                if(g.getId()==gerente.getId()){
                    //g.setCargo(gerente.getCargo());
                    //g.setMetaRegional(gerente.getMetaRegional());
                   // g.setRegional(gerente.getRegional());
                    if(gerente.getNome()!=null &&!gerente.getNome().equals("") )
                        g.setNome(gerente.getNome());
                    if(gerente.getSalarioLiquido()!=null && gerente.getSalarioLiquido()!=0 )
                        g.setSalarioLiquido(gerente.getSalarioLiquido());
                    //g.setCpf(gerente.getCpf());
                    System.out.println("\nGerente alterado com sucesso!!\n");
                    return true;
                }
            }
        }
        catch (Exception exception){
            System.out.println("\ncatch: Erro ao alterar gerente!!!!\n");
            sucesso =false;
        }
        return sucesso;
    }

    @Override
    public boolean deletarGerente(Gerente gerente) {
        try {
            gerentes = listarGerentes();
            if(!gerentes.stream()
                    .filter(g->g.getId()==gerente.getId()).findFirst().isPresent()){
                System.out.printf("\nNenhum gerente encontrado com esse cpf: %s",gerente.getCpf());
                return false;
            }
            Gerente gerenteRemover= new Gerente();
            for (Gerente g:gerentes) {
                if(g.getId()==gerente.getId()){
                    gerenteRemover = g;
                   break;
                }
            }
            gerentes.remove(gerenteRemover);
            System.out.println("\nGerente deletado com sucesso!!\n");
        }
        catch (Exception exception){
            System.out.println("\ncatch: Erro ao alterar gerente!!!!\n");
            sucesso =false;
        }
        return sucesso;
    }
}
