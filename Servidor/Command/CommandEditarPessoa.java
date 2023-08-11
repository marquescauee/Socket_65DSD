package Command;

import Observer.ObserverPessoa;
import dao.PessoaDao;

public class CommandEditarPessoa extends CommandPessoa{

	CommandEditarPessoa(String[] dados, ObserverPessoa obs) {
		super(dados, obs);
	}

	@Override
	public void execute() {
		String msg =PessoaDao.getInstance().atualizarPessoa(dados);
		obs.setMsg(msg);
	}

}
