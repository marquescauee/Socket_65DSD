package command.banda;

import command.CommandImpl;
import dao.BandaDAO;
import exceptions.banda.BandaException;
import models.Pessoa;
import observer.Observer;

import java.util.List;

public class CommandTocarMusica extends CommandImpl {

    public CommandTocarMusica(String[] dados, Observer observer) {
        super(dados, observer);
    }

    @Override
    public void execute() {
        String nome = dados[0];
        try {
            List<Pessoa> integrantes = BandaDAO.getInstance().getBandaPorNome(nome).getIntegrantes();

            StringBuilder msg = new StringBuilder();
            for (Pessoa integrante: integrantes ) {
                msg.append(integrante.getNome()).append(": ").append(integrante.comecarShow(dados[1])).append("\n");
            }

            obs.setMsg(msg.toString());
        } catch (BandaException e) {
            e.printStackTrace();
            obs.setMsg(e.getMessage());
        }
        //obs.setMsg(msg);
    }

}
