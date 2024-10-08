package command.pessoa;

import java.util.List;

import command.CommandImpl;
import dao.PessoaDAO;
import models.Pessoa;
import observer.Observer;

public class CommandGetAllPessoas extends CommandImpl {

	public CommandGetAllPessoas(String[] dados, Observer obs) {
		super(dados, obs);
	}

	@Override
	public void execute() {
		List<Pessoa> pessoas = PessoaDAO.getInstance().getPessoas();
		int qntdPessoas = pessoas.size();
		
		String msg  = qntdPessoas + "\n";
		msg = ((qntdPessoas > 0 && qntdPessoas < 10 ) ? "0"  : "") + msg;
		
		for (Pessoa pessoa : pessoas) {
			msg+= pessoa + "\n";
		}
		obs.setMsg(msg);
	}

}
