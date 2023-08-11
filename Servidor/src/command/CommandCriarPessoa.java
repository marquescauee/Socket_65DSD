package command;

import dao.PessoaDao;
import models.Pessoa;
import observer.Observer;

public class CommandCriarPessoa extends CommandPessoa {

	public CommandCriarPessoa(String[] dados, Observer obs) {
		super(dados, obs);
	}

	@Override
	public void execute() {
		String[] splitada = getDados();
		Pessoa p = new Pessoa(splitada[1]);

		p.setNome(splitada[2]);
		p.setEndereco(splitada[3]);

		
		PessoaDao.getInstance().insertPessoa(p);
	    //String msg = PessoaDao.getInstance().insertPessoa(p);
	    //obs.setMsg(msg);
	}

}
