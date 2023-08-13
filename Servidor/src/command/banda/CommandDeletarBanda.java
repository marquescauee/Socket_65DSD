package command.banda;

import command.CommandImpl;
import dao.BandaDAO;
import exceptions.banda.BandaException;
import observer.Observer;

public class CommandDeletarBanda extends CommandImpl {

	public CommandDeletarBanda(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		String nome = dados[1];
		try {
			BandaDAO.getInstance().removeBandaPorNome(nome);
			obs.setMsg("Banda " + nome + "  removida com sucesso");
		} catch (BandaException e) {
			e.printStackTrace();
			obs.setMsg(e.getMessage());
		}
		//obs.setMsg(msg);
	}

}
