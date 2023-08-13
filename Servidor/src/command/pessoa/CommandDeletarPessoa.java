package command.pessoa;

import observer.Observer;
import command.CommandImpl;
import dao.PessoaDAO;
import exceptions.pessoa.PessoasException;

public class CommandDeletarPessoa extends CommandImpl {
	
	public CommandDeletarPessoa(String[] dados, Observer obs){
		super(dados, obs);
	}
	
	@Override
	public void execute() {
		String cpf = dados[1];
		try {
			PessoaDAO.getInstance().removePessoaPorCpf(cpf);
			//obs.setMsg("Pessoa com cpf " + cpf + " removida com sucesso");
			obs.setMsg("Pessoa removida com sucesso");
		} catch (PessoasException e) {
			e.printStackTrace();
			obs.setMsg(e.getMessage());
		}
		//obs.setMsg(msg);
	}

}
