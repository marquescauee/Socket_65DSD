import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {

		String opcao = "";
		Scanner s = new Scanner(System.in);
		
		while (!opcao.equalsIgnoreCase("sair")) {
			System.out.println("Digite a opcao desejada no seguinte formato:");
			System.out.println("=====================================================");
			System.out.println("insert;cpf;nome;endereco \t[inserir uma nova pessoa]\n");
			System.out.println("update;cpf;nome;endereco \t[atualizar os dados de uma pessoa]\n");
			System.out.println("delete;cpf \t\t\t[remover uma pessoa]\n");
			System.out.println("get;cpf; \t\t\t[recuperar uma pessoa]\n");
			System.out.println("list \t\t\t\t[recuperar todas as pessoas]\n");

			System.out.println("=====================================================");
			System.out.println("insertBanda;nome;qtdIntegrantes;anoPrimeiraMusica \t[inserir uma nova banda]\n");
			System.out.println("updateBanda;nome;anoPrimeiraMusica \t\t\t[atualizar os dados de uma banda]\n");
			System.out.println("deleteBanda;nome \t\t\t\t\t[remover uma banda]\n");
			System.out.println("insertIntegrante;nomeBanda;cpf \t\t\t\t[adicionar integrante a uma banda]\n");
			System.out.println("deleteIntegrante;nomeBanda;cpf \t\t\t\t[remover integrante de uma banda]\n");
			System.out.println("getBanda;nome; \t\t\t\t\t\t[recuperar uma banda]\n");
			System.out.println("listBandas \t\t\t\t\t\t[listar todas as bandas]\n");
			System.out.println("=====================================================");
			
			System.out.println("insertMusico;cpf;nome;endereco;tipo \t[inserir uma nova pessoa]\n");
			System.out.println("comecarShow;banda;letra");
			System.out.println("=====================================================");
						
			System.out.println("sair \t\t[encerrar a aplicacao]\n");

			opcao = s.nextLine();

			if(opcao.equals("sair")) {
				break;
			}
			
			try (Socket conn = new Socket("10.15.120.70", 80);) {
				InputStream in = conn.getInputStream();

				OutputStream out = conn.getOutputStream();
				out.write(opcao.getBytes());

				byte[] dadosBrutos = new byte[1024];
				int qtdDadosBrutos = in.read(dadosBrutos);
				while (qtdDadosBrutos >= 0) {
					String stringDados = new String(dadosBrutos, 0, qtdDadosBrutos);
					System.out.println("===================================\n");
					System.out.println(stringDados);
					System.out.println("===================================\n");
					qtdDadosBrutos = in.read(dadosBrutos);
				}
			
			} catch (UnknownHostException e) {
				System.out.println("Host nao encontrado");
				e.printStackTrace();
			}
		}
		s.close();
	}

}
