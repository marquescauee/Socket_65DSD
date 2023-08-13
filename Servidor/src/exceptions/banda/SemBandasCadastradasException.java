package exceptions.banda;

public class SemBandasCadastradasException extends BandaException {
	public SemBandasCadastradasException(){
		super("Ainda nao ha bandas cadastradas");
	}
}
