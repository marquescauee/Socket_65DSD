package Command;

import Observer.ObserverPessoa;

public class CommandFactoryPessoa {
	
	private ObserverPessoa observer;
	
	public CommandFactoryPessoa(ObserverPessoa observer){
		this.observer = observer;
	}
	

	public Command getCommand( String[] dados) {
		String command = dados[0];
		switch(command) {
			case "insert": return new CommandCriarPessoa(dados, observer);
			case "delete": return new CommandDeletarPessoa(dados, observer);
			case "update": return new CommandEditarPessoa(dados, observer);
		}
		
		return null;
	}
}
