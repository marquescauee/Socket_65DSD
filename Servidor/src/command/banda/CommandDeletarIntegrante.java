package command.banda;

import command.pessoa.CommandImpl;
import dao.BandaDAO;
import dao.PessoaDAO;
import models.Pessoa;
import observer.Observer;

public class CommandDeletarIntegrante extends CommandImpl {

	public CommandDeletarIntegrante(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		String nomeBanda = dados[1];
		String cpfIntegrante = dados[2];
		
		String[] dadosPessoa = PessoaDAO.getInstance().getPessoaPorCpf(cpfIntegrante).split(";");
		
		if(dadosPessoa [0].equals("Pessoa nao encontrada")) {
			obs.setMsg("Pessoa nao encontrada");
			return ;
		}
		
		Pessoa p = new Pessoa(dadosPessoa[0]);
		p.setNome(dadosPessoa[1]);
		p.setEndereco(dadosPessoa[2]);
		
		
		String msg= BandaDAO.getInstance().removeIntegrante(nomeBanda, p);
		obs.setMsg(msg);

	}

}
