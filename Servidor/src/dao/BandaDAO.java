package dao;

import java.util.ArrayList;
import java.util.List;

import models.Banda;
import models.Pessoa;

public class BandaDAO {
	private static List<Banda> bandas = new ArrayList<>();
	private static BandaDAO instance;
	
	private BandaDAO() {}
	
	public synchronized static BandaDAO getInstance() {
		if (instance == null) {
			instance = new BandaDAO();
		}
		return instance;
	}
	
	public synchronized void insertBanda(Banda banda)  {
		for (Banda b : bandas) {
			if (b.getNome().equals(banda.getNome())) {
				return ;
			}
		}
		bandas.add(banda);
	}
	
	public synchronized void insertIntegrante(String nomeBanda, Pessoa p) {
		for(Banda b : bandas) {
			if(b.getNome().equals(nomeBanda) && b.getQntdIntegrantes() < b.getIntegrantes().size()) {
				b.addIntegrante(p);
			}
		}
	}
	
	public synchronized void removeIntegrante(String nomeBanda, Pessoa p) {
		for(Banda b : bandas) {
			if(b.getNome().equals(nomeBanda) && b.getIntegrantes().contains(p)) {
				b.removeIntegrante(p);
			}
		}
	}
	
	public synchronized String getBandaPorNome(String nome){
		if(bandas.isEmpty()) {
			return "Sem bandas cadastradas";
		}
		for (Banda b : bandas) {
			if (b.getNome().equals(nome)) {
				return b.toString();
			}
		}
		return ("Banda nao encontrada");
	}
	
	public synchronized List<Banda> getBandas(){
		return bandas;
	}
	
	public synchronized String removeBandaPorNome(String nome) {
		if(bandas.isEmpty()) {
			return "Sem bandas cadastradas";
		}
		for (Banda b : bandas) {
			if (b.getNome().equals(nome)) {
				bandas.remove(b);
				return "Banda deletada com sucesso";
			}
		}
		return "Banda inexistente";
	}
	
	public synchronized String atualizarBanda(String[] dados) {
		if(bandas.isEmpty()) {
			return "Sem bandas cadastradas";
		}
		for (Banda b : bandas) {
			if (b.getNome().equals(dados[1])) {
				b.setAnoLancamentoPrimeiraMusica(Integer.parseInt(dados[3]));
				return "Banda atualizada com sucesso";
			}
		}
		return "Banda nao encontrada";
	}
}
