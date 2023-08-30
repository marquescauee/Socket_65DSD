package command.desafio;

import command.CommandImpl;
import dao.PessoaDAO;
import exceptions.pessoa.PessoasException;
import models.*;
import observer.Observer;

public class CommandCriarMusico extends CommandImpl {

    public CommandCriarMusico(String[] dados, Observer observer) {
        super(dados, observer);
    }
    @Override
    public void execute() {
        Pessoa musico  = null;

        switch (dados[4].toLowerCase()){
            case "vocalista" : musico = new Vocalista(dados[1]); break;

            case "baterista" : musico = new Baterista(dados[1]); break;

            case "baixista" : musico = new Baixista(dados[1]); break;

            case "guitarrista" : musico = new Guitarrista(dados[1]); break;

            default: musico = new Pessoa(dados[1]);
        }

        musico.setNome(dados[2]);
        musico.setEndereco(dados[3]);

        obs.setMsg("Inserido com sucesso");
        try {
            PessoaDAO.getInstance().insertPessoa(musico);
        } catch (PessoasException e) {
            e.printStackTrace();
            obs.setMsg("Deu erro");
        }
    }
}
