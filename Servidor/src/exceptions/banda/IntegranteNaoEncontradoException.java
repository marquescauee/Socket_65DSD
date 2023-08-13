package exceptions.banda;

public class IntegranteNaoEncontradoException extends BandaException {

	public IntegranteNaoEncontradoException(String nomeBanda, String nomeIntegrante) {
		super("Integrante com o nome " + nomeIntegrante + " nao encontrado na banda " + nomeBanda);
	}

}
