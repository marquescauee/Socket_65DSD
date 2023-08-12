package command.banda;

import command.pessoa.CommandImpl;
import dao.BandaDAO;
import observer.Observer;

public class CommandEditarBanda extends CommandImpl {

	public CommandEditarBanda(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		String msg = BandaDAO.getInstance().atualizarBanda(dados);
		obs.setMsg(msg);
	}

}
