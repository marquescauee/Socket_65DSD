package exceptions.pessoa;

public class SemPessoasCadastradasException extends PessoasException{

	public SemPessoasCadastradasException(){
		super("Sem pessoas cadastradas");
	}
}
