package command;

import command.banda.CommandCriarBanda;
import command.banda.CommandDeletarBanda;
import command.banda.CommandDeletarIntegrante;
import command.banda.CommandEditarBanda;
import command.banda.CommandGetAllBandas;
import command.banda.CommandGetBanda;
import command.banda.CommandInserirIntegrante;
import command.desafio.CommandCriarMusico;
import command.pessoa.Command;
import command.pessoa.CommandCriarPessoa;
import command.pessoa.CommandDeletarPessoa;
import command.pessoa.CommandEditarPessoa;
import command.pessoa.CommandGetAllPessoas;
import command.pessoa.CommandGetPessoa;
import command.desafio.CommandTocarMusica;
import observer.Observer;

public class CommandFactory {
	
	private Observer observer;
	
	public CommandFactory(Observer observer){
		this.observer = observer;
	}

	public Command getCommand( String[] dados) {
		String command = dados[0];

		switch(command) {
			case "insert": return new CommandCriarPessoa(dados, observer);
			case "delete": return new CommandDeletarPessoa(dados, observer);
			case "update": return new CommandEditarPessoa(dados, observer);
			case "get": return new CommandGetPessoa(dados, observer);
			case "list": return new CommandGetAllPessoas(dados, observer);

			case "insertBanda": return new CommandCriarBanda(dados, observer);
			case "updateBanda": return new CommandEditarBanda(dados, observer);
			case "deleteBanda": return new CommandDeletarBanda(dados, observer);
			case "insertIntegrante": return new CommandInserirIntegrante(dados, observer);
			case "deleteIntegrante": return new CommandDeletarIntegrante(dados, observer);
			case "getBanda": return new CommandGetBanda(dados, observer);
			case "listBandas": return new CommandGetAllBandas(dados, observer);

			case "insertMusico": return new CommandCriarMusico(dados, observer);
			case "comecarShow": return new CommandTocarMusica(dados, observer);
			//nomeBanda;Can u fill LAMARRR
		}

		//throw new CommandInvalidoException();
		return  null;

	}
}


