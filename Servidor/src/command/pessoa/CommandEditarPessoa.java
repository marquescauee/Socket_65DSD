package command.pessoa;

import observer.Observer;
import dao.PessoaDAO;

public class CommandEditarPessoa extends CommandImpl {

	CommandEditarPessoa(String[] dados, Observer obs) {
		super(dados, obs);
	}

	@Override
	public void execute() {
		String msg =PessoaDAO.getInstance().atualizarPessoa(dados);
		obs.setMsg(msg);
	}

}
