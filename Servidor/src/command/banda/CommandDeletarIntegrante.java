package command.banda;

import command.CommandImpl;
import dao.BandaDAO;
import dao.PessoaDAO;
import exceptions.banda.BandaException;
import exceptions.pessoa.PessoasException;
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
		
		String[] dadosPessoa;
		try {
			dadosPessoa = PessoaDAO.getInstance().getPessoaPorCpf(cpfIntegrante).split(";");
			
			Pessoa p = new Pessoa(dadosPessoa[0]);
			p.setNome(dadosPessoa[1]);
			p.setEndereco(dadosPessoa[2]);
			
			BandaDAO.getInstance().removeIntegrante(nomeBanda, p);
			obs.setMsg("Integrante " + p.getNome() + " removido com sucesso");
		} catch (PessoasException | BandaException e ) {
			e.printStackTrace();
			obs.setMsg(e.getMessage());
		}
	}

}
