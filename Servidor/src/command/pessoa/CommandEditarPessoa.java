package command.pessoa;

import observer.Observer;
import command.CommandImpl;
import dao.PessoaDAO;
import exceptions.pessoa.PessoasException;
import models.Pessoa;

public class CommandEditarPessoa extends CommandImpl {

	public CommandEditarPessoa(String[] dados, Observer obs) {
		super(dados, obs);
	}

	@Override
	public void execute() {
		try {
			Pessoa p = PessoaDAO.getInstance().atualizarPessoa(dados);
			obs.setMsg("Pessoa atualizada com sucesso"); // para: " + p);
		} catch (PessoasException e) {
			e.printStackTrace();
			obs.setMsg(e.getMessage());
		}
		
	}

}
