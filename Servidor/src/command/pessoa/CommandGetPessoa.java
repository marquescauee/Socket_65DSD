package command.pessoa;

import command.CommandImpl;
import dao.PessoaDAO;
import exceptions.pessoa.PessoasException;
import observer.Observer;

public class CommandGetPessoa extends CommandImpl {

	
	public CommandGetPessoa(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		String cpf = dados[1];
		String pessoaDados;
		try {
			pessoaDados = PessoaDAO.getInstance().getPessoaPorCpf(cpf);
			obs.setMsg(pessoaDados);
		} catch (PessoasException e) {
			e.printStackTrace();
			obs.setMsg(e.getMessage());
		}
		
	}

}
