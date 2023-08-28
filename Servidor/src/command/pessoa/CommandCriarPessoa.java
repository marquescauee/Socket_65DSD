package command.pessoa;

import command.CommandImpl;
import dao.PessoaDAO;
import exceptions.pessoa.PessoasException;
import models.Pessoa;
import observer.Observer;

public class CommandCriarPessoa extends CommandImpl {

	public CommandCriarPessoa(String[] dados, Observer obs) {
		super(dados, obs);
	}

	@Override
	public void execute() {
		String[] dados = getDados();
		Pessoa p = new Pessoa(dados[1]);

		p.setNome(dados[2]);
		p.setEndereco(dados[3]);

		try {
			PessoaDAO.getInstance().insertPessoa(p);
		} catch (PessoasException e) {
			e.printStackTrace();
		}
	}

}


