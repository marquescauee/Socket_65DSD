package models;

import java.util.ArrayList;
import java.util.List;

public class Banda {
    private String nome;
    private int qntdIntegrantes;
    private int anoLancamentoPrimeiraMusica;
    private List<Pessoa> integrantes = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addIntegrante(Pessoa p) {
    	this.integrantes.add(p);
    }
    
    public void removeIntegrante(Pessoa p) {
    	this.integrantes.remove(p);
    }
    
    public boolean removeIntegrantePorCpf(String cpf) {
    	for(Pessoa p : integrantes) {
    		if(p.getCpf().equals(cpf)) {
    			integrantes.remove(p);
    			return true;
    		}
    	}
    	return false;
    }
    
    public List<Pessoa> getIntegrantes() {
		return integrantes;
	}

    public int getQntdIntegrantes() {
        return qntdIntegrantes;
    }

    public void setQntdIntegrantes(int qntdIntegrantes) {
        this.qntdIntegrantes = qntdIntegrantes;
    }

    public int getAnoLancamentoPrimeiraMusica() {
        return anoLancamentoPrimeiraMusica;
    }

    public void setAnoLancamentoPrimeiraMusica(int anoLancamentoPrimeiraMusica) {
        this.anoLancamentoPrimeiraMusica = anoLancamentoPrimeiraMusica;
    }

    
    
	@Override
	public String toString() {
		String integrantesToString = "";
		
		for(Pessoa p : integrantes) {
			integrantesToString += "\t ->" + p + "\n";
		}
		
		return nome + ";" + qntdIntegrantes + ";" + anoLancamentoPrimeiraMusica + "\n" + integrantesToString;
	}
}
