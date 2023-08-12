package command.pessoa;

import dao.PessoaDAO;
import observer.Observer;

public class CommandGetPessoa extends CommandImpl {

	
	public CommandGetPessoa(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		String cpf = dados[1];
		String pessoaDados = PessoaDAO.getInstance().getPessoaPorCpf(cpf);
		obs.setMsg(pessoaDados);
	}

}
