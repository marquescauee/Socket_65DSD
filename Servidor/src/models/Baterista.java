package models;

public class Baterista extends Pessoa{

    public Baterista(String cpf) {
        super(cpf);
    }

    @Override
    public String comecarShow(String letra) {
        return "Tunts tats.. tunts tats";
    }

}