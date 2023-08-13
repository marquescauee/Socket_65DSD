package dao;

import java.util.ArrayList;
import exceptions.banda.*;
import java.util.List;

import models.Banda;
import models.Pessoa;

public class BandaDAO {
	private static List<Banda> bandas = new ArrayList<>();
	private static BandaDAO instance;

	private BandaDAO() {
	}

	public synchronized static BandaDAO getInstance() {
		if (instance == null) {
			instance = new BandaDAO();
		}
		return instance;
	}

	public synchronized void insertBanda(Banda banda) throws BandaJaCadastradaException {
		for (Banda b : bandas) {
			if (b.getNome().equals(banda.getNome())) {
				throw new BandaJaCadastradaException(banda.getNome());
			}
		}
		bandas.add(banda);
	}

	public synchronized boolean insertIntegrante(String nomeBanda, Pessoa p) throws BandaNaoEncontradaException, BandaException {
		
		for(Banda b : bandas) {
			for(Pessoa pes : b.getIntegrantes()) {
				if (pes.getCpf().equals(p.getCpf())){
					throw new IntegranteJaExistenteException(p.getNome());
				}
			}
			
			if(b.getNome().equals(nomeBanda)) {
				if(b.getQntdIntegrantes() <= b.getIntegrantes().size()) {
					throw new LimiteIntegrantesException();
				}
				b.addIntegrante(p);
				return true;
			}
		}
		throw new BandaNaoEncontradaException(nomeBanda);
	}

	public synchronized boolean removeIntegrante(String nomeBanda, Pessoa p) throws BandaException {
		getBandaPorNome(nomeBanda);

		for (Banda b : bandas) {
			if (b.getNome().equals(nomeBanda)) {
				if (b.removeIntegrantePorCpf(p.getCpf())) {
					return true;
				}
			}
		}
		throw new IntegranteNaoEncontradoException(nomeBanda, p.getNome());
		// return "Nao foi possivel remover o integrante " + p.getNome() + " de " +
		// nomeBanda;
=======
	
	public synchronized String insertIntegrante(String nomeBanda, Pessoa p) {
	
		for(Banda b : bandas) {
			if(b.getNome().equals(nomeBanda) && b.getQntdIntegrantes() > b.getIntegrantes().size()) {
				b.addIntegrante(p);
				return "Integrante " + p.getNome() + " adicionado a banda " + b.getNome();
			}
		}
		return "Banda nao encontrada";
	}
	
	public synchronized String removeIntegrante(String nomeBanda, Pessoa p) {
		for(Banda b : bandas) {
			if(b.getNome().equals(nomeBanda)) {
				if(b.removeIntegrantePorCpf(p.getCpf())) {
					return "Integrante " + p.getNome() + " removido de " + nomeBanda + " com sucesso";
				}
			}		
		}
		return "Nao foi possivel remover o integrante " + p.getNome() + " de " + nomeBanda;
>>>>>>> 16562b59120a32b4fe032311a35883d4471908ae
	}

	public synchronized Banda getBandaPorNome(String nome) throws BandaException {
		if (bandas.isEmpty()) {
			throw new SemBandasCadastradasException();
		}
		for (Banda b : bandas) {
			if (b.getNome().equals(nome)) {
				return b;
			}
		}
		throw new BandaNaoEncontradaException(nome);
	}

	public synchronized List<Banda> getBandas() {
		return bandas;
	}

	public synchronized boolean removeBandaPorNome(String nome) throws BandaException {
		if (bandas.isEmpty()) {
			throw new SemBandasCadastradasException();
		}
		for (Banda b : bandas) {
			if (b.getNome().equals(nome)) {
				bandas.remove(b);
				return true;
			}
		}
		throw new BandaNaoEncontradaException(nome);
	}

	public synchronized boolean atualizarBanda(String[] dados) throws BandaException {
		if (bandas.isEmpty()) {
			throw new SemBandasCadastradasException();
		}
		for (Banda b : bandas) {
			if (b.getNome().equals(dados[1])) {
				b.setAnoLancamentoPrimeiraMusica(Integer.parseInt(dados[2]));
<<<<<<< HEAD
				return true;
=======
				return "Banda atualizada com sucesso";
>>>>>>> 16562b59120a32b4fe032311a35883d4471908ae
			}
		}
		throw new BandaNaoEncontradaException(dados[1]);
	}
}
