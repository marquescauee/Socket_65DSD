package dao;
import java.util.List;

import models.Pessoa;

import java.util.ArrayList;

public class PessoaDao {

	private static List<Pessoa> pessoas = new ArrayList<>();
	private static PessoaDao instance;

	private PessoaDao() {

	}

	public synchronized static PessoaDao getInstance() {
		if (instance == null) {
			instance = new PessoaDao();
		}
		return instance;
	}

	public synchronized void insertPessoa(Pessoa p) {
		pessoas.add(p);
	}

	public synchronized String getPessoaPorCpf(String cpf){
		if(pessoas.isEmpty()) {
			return "Sem pessoas cadastradas";
		}
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf() == cpf) {
				return pessoa.toString();
			}
		}
		return ("Pessoa nao encontrada");
	}
	
	public synchronized List<Pessoa> getPessoas(){
		return pessoas;
	}
	
	public synchronized String removePessoaPorCpf(String cpf) {
		if(pessoas.isEmpty()) {
			return "Sem pessoas cadastradas";
		}
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(cpf)) {
				pessoas.remove(pessoa);
				return "Pessoa deletada com sucesso";
			}
		}
		return "Pessoa inexistente";
	}
	
	public synchronized String atualizarPessoa(String[] dados) {
		if(pessoas.isEmpty()) {
			return "Sem pessoas cadastradas";
		}
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(dados[1])) {
				pessoa.setEndereco(dados[3]);
				pessoa.setNome(dados[2]);
				return "Pessoa atualizada com sucesso";
			}
		}
		return "Pessoa nao encontrada";
	}
	
}
