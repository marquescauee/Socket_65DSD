package exceptions.banda;

public class IntegranteJaExistenteException extends BandaException {

	public IntegranteJaExistenteException(String nomeIntegrante) {
		super("Integrante " + nomeIntegrante + " ja faz parte da banda.");
	}

}
