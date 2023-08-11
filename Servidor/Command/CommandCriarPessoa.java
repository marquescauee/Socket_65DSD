package Command;

import Observer.ObserverPessoa;
import dao.PessoaDao;
import models.Pessoa;

public class CommandCriarPessoa extends CommandPessoa {

	public CommandCriarPessoa(String[] dados, ObserverPessoa obs) {
		super(dados, obs);
	}

	@Override
	public void execute() {
		String[] splitada = getDados();
		Pessoa p = new Pessoa(splitada[1]);

		p.setNome(splitada[2]);
		p.setEndereco(splitada[3]);

	    PessoaDao.getInstance().insertPessoa(p);
	    obs.setMsg("criado");
	}

}
