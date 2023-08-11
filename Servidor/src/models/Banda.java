package models;
public class Banda {
    private String nome;
    private int qntdIntegrantes;
    private int anoLancamentoPrimeiraMusica;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
