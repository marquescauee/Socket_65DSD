package models;
public class Banda {
    private String nome;
    private int qntdIntegrantes;
    private int anoLacamentoPrimeiraMusica;

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

    public int getAnoLacamentoPrimeiraMusica() {
        return anoLacamentoPrimeiraMusica;
    }

    public void setAnoLacamentoPrimeiraMusica(int anoLacamentoPrimeiraMusica) {
        this.anoLacamentoPrimeiraMusica = anoLacamentoPrimeiraMusica;
    }
}
