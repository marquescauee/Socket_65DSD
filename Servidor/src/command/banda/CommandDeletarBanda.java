package command.banda;

import command.pessoa.CommandImpl;
import dao.BandaDAO;
import observer.Observer;

public class CommandDeletarBanda extends CommandImpl {

	public CommandDeletarBanda(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		String nome = dados[1];
		String msg = BandaDAO.getInstance().removeBandaPorNome(nome);
		obs.setMsg(msg);
	}

}
