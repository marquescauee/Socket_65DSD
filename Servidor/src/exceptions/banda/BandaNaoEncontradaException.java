package exceptions.banda;

public class BandaNaoEncontradaException extends BandaException {

	public BandaNaoEncontradaException(String msg) {
		super("Banda com o nome " + msg + " nao encontrada");
	}

}
