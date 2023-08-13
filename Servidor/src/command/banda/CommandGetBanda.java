package command.banda;

import command.CommandImpl;
import dao.BandaDAO;
import exceptions.banda.BandaException;
import models.Banda;
import observer.Observer;

public class CommandGetBanda extends CommandImpl {

	public CommandGetBanda(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		String nome = dados[1];
		try {
			Banda b =BandaDAO.getInstance().getBandaPorNome(nome);
			obs.setMsg(b.toString());
		} catch (BandaException e) {
			e.printStackTrace();
			obs.setMsg(e.getMessage());
		}
		//obs.setMsg();

	}

}
