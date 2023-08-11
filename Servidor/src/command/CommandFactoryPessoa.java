package command;

import observer.Observer;

public class CommandFactoryPessoa {
	
	private Observer observer;
	
	public CommandFactoryPessoa(Observer observer){
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
		}
		
		return null;
	}
}
