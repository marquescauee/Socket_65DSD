package models;

public class Vocalista extends Pessoa{

	public Vocalista(String cpf) {
		super(cpf);
	}

	@Override
	public String comecarShow(String letra) {
		return letra;
	}


}