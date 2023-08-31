package models;

public class Baixista extends Pessoa{

    public Baixista(String cpf) {
        super(cpf);
    }

    @Override
    public String comecarShow(String letra) {
        return "TUNN TUNN TUNNN";
    }
}




