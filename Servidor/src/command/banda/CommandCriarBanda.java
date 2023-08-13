package command.banda;

import command.CommandImpl;
import dao.BandaDAO;
import exceptions.banda.BandaJaCadastradaException;
import models.Banda;
import observer.Observer;

public class CommandCriarBanda extends CommandImpl {

	public CommandCriarBanda(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		String[] splitada = getDados();
		Banda banda = new Banda();
		
		banda.setNome(splitada[1]);
		banda.setQntdIntegrantes(Integer.parseInt(splitada[2]));
		banda.setAnoLancamentoPrimeiraMusica(Integer.parseInt(splitada[3]));
		try {
			BandaDAO.getInstance().insertBanda(banda);
		} catch (BandaJaCadastradaException e) {
			e.printStackTrace();
			obs.setMsg(e.getMessage());
		}
	}

}
