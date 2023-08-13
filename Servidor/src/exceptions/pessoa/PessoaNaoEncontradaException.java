package exceptions.pessoa;

public class PessoaNaoEncontradaException extends PessoasException {
	
	public PessoaNaoEncontradaException(String cpf){
		//super("Pessoa nao encontrada com o cpf " + cpf);
		super("Pessoa nao encontrada" );
	}
}
