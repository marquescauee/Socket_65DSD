package command.pessoa;

import command.banda.CommandCriarBanda;
import command.banda.CommandDeletarBanda;
import command.banda.CommandDeletarIntegrante;
import command.banda.CommandEditarBanda;
import command.banda.CommandGetAllBandas;
import command.banda.CommandGetBanda;
import command.banda.CommandInserirIntegrante;
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
			case "updateBanda": return new CommandDeletarBanda(dados, observer);
			case "deleteBanda": return new CommandEditarBanda(dados, observer);
			case "insertIntegrante": return new CommandInserirIntegrante(dados, observer);
			case "deleteIntegrante": return new CommandDeletarIntegrante(dados, observer);
			case "getBanda": return new CommandGetBanda(dados, observer);
			case "listBandas": return new CommandGetAllBandas(dados, observer);
		}
		
		return null;
	}
}
