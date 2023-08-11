package command;

import observer.Observer;
import dao.PessoaDao;

public class CommandEditarPessoa extends CommandPessoa{

	CommandEditarPessoa(String[] dados, Observer obs) {
		super(dados, obs);
	}

	@Override
	public void execute() {
		String msg =PessoaDao.getInstance().atualizarPessoa(dados);
		obs.setMsg(msg);
	}

}
