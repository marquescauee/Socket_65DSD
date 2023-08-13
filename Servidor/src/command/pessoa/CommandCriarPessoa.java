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
		String[] splitada = getDados();
		Pessoa p = new Pessoa(splitada[1]);

		p.setNome(splitada[2]);
		p.setEndereco(splitada[3]);

		
		try {
			PessoaDAO.getInstance().insertPessoa(p);
			//obs.setMsg("Pessoa " + p + " inserida com sucesso");
		} catch (PessoasException e) {
			e.printStackTrace();
			//obs.setMsg(e.getMessage());
		}
	}

}
