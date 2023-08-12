package command.pessoa;

import observer.Observer;
import dao.PessoaDAO;

public class CommandDeletarPessoa extends CommandImpl {
	
	public CommandDeletarPessoa(String[] dados, Observer obs){
		super(dados, obs);
	}
	
	@Override
	public void execute() {
		String cpf = dados[1];
		String msg = PessoaDAO.getInstance().removePessoaPorCpf(cpf);
		obs.setMsg(msg);
	}

}
