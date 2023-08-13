package dao;
import java.util.List;

import exceptions.pessoa.PessoaJaCadastradaException;
import exceptions.pessoa.PessoaNaoEncontradaException;
import exceptions.pessoa.PessoasException;
import exceptions.pessoa.SemPessoasCadastradasException;
import models.Pessoa;

import java.util.ArrayList;

public class PessoaDAO {

	private static List<Pessoa> pessoas = new ArrayList<>();
	private static PessoaDAO instance;

	private PessoaDAO() {

	}

	public synchronized static PessoaDAO getInstance() {
		if (instance == null) {
			instance = new PessoaDAO();
		}
		return instance;
	}

	public synchronized void insertPessoa(Pessoa p) throws PessoaJaCadastradaException  {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(p.getCpf())) {
				throw new PessoaJaCadastradaException(p.getCpf());
			}
		}
		pessoas.add(p);
	}
	
	public synchronized String getPessoaPorCpf(String cpf) throws PessoasException{
		if(pessoas.isEmpty()) {
			throw new SemPessoasCadastradasException();
		}
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(cpf)) {
				return pessoa.toString();
			}
		}
		 throw new PessoaNaoEncontradaException(cpf);
	}
	
	public synchronized List<Pessoa> getPessoas(){
		return pessoas;
	}
	
	public synchronized boolean removePessoaPorCpf(String cpf) throws PessoasException {
		if(pessoas.isEmpty()) {
			throw new SemPessoasCadastradasException();
		}
		Pessoa pRemover = null;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(cpf)) {
				pRemover = pessoa;
			}
		}
		if (pRemover != null) {
			pessoas.remove(pRemover);
			return true;
		}
		
		throw new PessoaNaoEncontradaException(cpf);
	}
	
	public synchronized Pessoa atualizarPessoa(String[] dados) throws PessoasException {
		if(pessoas.isEmpty()) {
			throw new SemPessoasCadastradasException();
		}
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(dados[1])) {
				pessoa.setEndereco(dados[3]);
				pessoa.setNome(dados[2]);
				return pessoa;
			}
		}
		 throw new PessoaNaoEncontradaException(dados[1]);
	}
	
}
