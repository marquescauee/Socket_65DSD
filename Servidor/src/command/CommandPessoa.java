package command;

import observer.ObserverPessoa;

public abstract class CommandPessoa implements Command{

	public String [] dados;
	public ObserverPessoa obs;
	
	CommandPessoa(String[] dados, ObserverPessoa obs){
		this.dados= dados;
		this.obs = obs;
	}
	
	public String[] getDados(){
		return dados;
	}

}
