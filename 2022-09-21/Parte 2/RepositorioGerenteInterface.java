import java.util.List;

public interface RepositorioGerenteInterface {

    List<Gerente> listarGerentes();

    Gerente listarGerentePorId(Gerente gerente);

    boolean salvarGerente(Gerente gerente);

    boolean alterarGerente(Gerente gerente);

    boolean deletarGerente(Gerente gerente);

}
