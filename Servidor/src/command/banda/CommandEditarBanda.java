package command.banda;

import command.CommandImpl;
import dao.BandaDAO;
import exceptions.banda.BandaException;
import models.Banda;
import observer.Observer;

public class CommandEditarBanda extends CommandImpl {

	public CommandEditarBanda(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
	try {
		BandaDAO.getInstance().atualizarBanda(dados);
		obs.setMsg("Banda atualizada com sucesso" );
	} catch (BandaException e) {
		e.printStackTrace();
		obs.setMsg(e.getMessage());
	}
	//	obs.setMsg(msg);
	}

}
