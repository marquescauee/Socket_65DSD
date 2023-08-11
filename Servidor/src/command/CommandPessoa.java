package command;

import observer.Observer;

public abstract class CommandPessoa implements Command{

	public String [] dados;
	public Observer obs;
	
	CommandPessoa(String[] dados, Observer obs){
		this.dados= dados;
		this.obs = obs;
	}
	
	public String[] getDados(){
		return dados;
	}

}
