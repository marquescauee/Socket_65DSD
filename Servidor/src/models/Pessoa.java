package models;
public class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;

    public Pessoa(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
	public String toString() {
		return cpf + ";" +  nome + ";" + endereco ;
	}

    public String comecarShow(String dado) {
        return "Sou apenas um produtor";
    }
}
