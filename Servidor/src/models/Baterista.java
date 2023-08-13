package models;

public class Baterista extends Pessoa{

	public Baterista(String cpf) {
		super(cpf);
	}
	
	public String batucar() {
		return "tunts tats   tunts tats";
	}

}
