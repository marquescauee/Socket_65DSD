package command.banda;

import command.pessoa.CommandImpl;
import dao.BandaDAO;
import observer.Observer;

public class CommandGetBanda extends CommandImpl {

	public CommandGetBanda(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		String nome = dados[1];
		String bandaDados = BandaDAO.getInstance().getBandaPorNome(nome);
		obs.setMsg(bandaDados);

	}

}
