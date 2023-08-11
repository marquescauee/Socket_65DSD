package command;

import java.util.ArrayList;
import java.util.List;

import dao.PessoaDao;
import models.Pessoa;
import observer.Observer;

public class CommandGetAllPessoas extends CommandPessoa {

	CommandGetAllPessoas(String[] dados, Observer obs) {
		super(dados, obs);
	}

	@Override
	public void execute() {
		List<Pessoa> pessoas = PessoaDao.getInstance().getPessoas();
		int qntdPessoas = pessoas.size();
		
		String msg  = qntdPessoas + "\n";
		msg = ((qntdPessoas > 0 && qntdPessoas < 10 ) ? "0"  : "") + msg;
		
		for (Pessoa pessoa : pessoas) {
			msg+= pessoa + "\n";
		}
		obs.setMsg(msg);
	}

}
