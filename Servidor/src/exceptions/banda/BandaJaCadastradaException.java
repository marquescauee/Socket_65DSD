package exceptions.banda;

public class BandaJaCadastradaException extends BandaException {

	public BandaJaCadastradaException(String msg) {
		super("Ja possui uma banda com o nome " + msg);
	}

}
