package command;

import observer.ObserverPessoa;
import dao.PessoaDao;

public class CommandDeletarPessoa extends CommandPessoa{
	
	public CommandDeletarPessoa(String[] dados, ObserverPessoa obs){
		super(dados, obs);
	}
	
	@Override
	public void execute() {
		String cpf = dados[1];
		String msg = PessoaDao.getInstance().removePessoaPorCpf(cpf);
		obs.setMsg(msg);
	}

}
