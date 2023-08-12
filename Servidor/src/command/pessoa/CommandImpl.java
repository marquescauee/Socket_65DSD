package command.pessoa;

import observer.Observer;

public abstract class CommandImpl implements Command{

	public String [] dados;
	public Observer obs;
	
	public CommandImpl(String[] dados, Observer obs){
		this.dados= dados;
		this.obs = obs;
	}
	
	public String[] getDados(){
		return dados;
	}

}
