package command.banda;

import java.util.List;

import command.CommandImpl;
import dao.BandaDAO;
import models.Banda;
import observer.Observer;

public class CommandGetAllBandas extends CommandImpl {

	public CommandGetAllBandas(String[] dados, Observer observer) {
		super(dados, observer);
	}

	@Override
	public void execute() {
		List<Banda> bandas = BandaDAO.getInstance().getBandas();
		int qntdBandas = bandas.size();
		
		String msg = qntdBandas + "\n";
		msg = ((qntdBandas > 0 && qntdBandas < 10 ) ? "0"  : "") + msg;
		
		for(Banda b : bandas) {
			msg += b + "\n";
		}
		
		obs.setMsg(msg);

	}

}
