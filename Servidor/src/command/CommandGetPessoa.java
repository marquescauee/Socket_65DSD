package command;

import dao.PessoaDao;
import observer.Observer;

public class CommandGetPessoa extends CommandPessoa {

	
	public CommandGetPessoa(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		String cpf = dados[1];
		String pessoaDados = PessoaDao.getInstance().getPessoaPorCpf(cpf);
		this.obs.setMsg(pessoaDados);
	}

}
