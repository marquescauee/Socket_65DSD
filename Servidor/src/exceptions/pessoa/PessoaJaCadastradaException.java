package exceptions.pessoa;

public class PessoaJaCadastradaException extends PessoasException {
	
	public PessoaJaCadastradaException(String msg) {
		super("Ja existe uma pessoa cadastrada com esse cpf: " + msg);
	}

}
