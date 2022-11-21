import java.util.List;

public interface RepositorioCoordenadorInterface {

    List<Coordenador> listarCoordenadores();

    boolean salvarCoordenador(Coordenador coordenador);

    boolean alterarCoordenador(Coordenador coordenador);

    boolean deletarCoordenador(Coordenador coordenador);
}
