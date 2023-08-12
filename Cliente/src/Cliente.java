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
			System.out.println("Digite a opção desejada no seguinte formato:");
			System.out.println("=====================================================");
			System.out.println("insert;cpf;nome;endereço \t[inserir uma nova pessoa]\n");
			System.out.println("update;cpf;nome;endereço \t[atualizar os dados de uma pessoa]\n");
			System.out.println("delete;cpf \t\t\t[remover uma pessoa]\n");
			System.out.println("get;cpf; \t\t\t[recuperar uma pessoa]\n");
			System.out.println("list \t\t\t\t[recuperar todas as pessoas]\n");

			System.out.println("=====================================================");
			System.out.println("insertBanda;nome;qtdIntegrantes;anoPrimeiraMusica \t[inserir uma nova banda]\n");
			System.out.println("updateBanda;nome;qtdIntegrantes;anoPrimeiraMusica \t[atualizar os dados de uma banda]\n");
			System.out.println("delete;nome \t\t\t\t\t\t[remover uma banda]\n");
			System.out.println("insertIntegrante;nomeBanda;cpf \t\t\t\t[adicionar integrante a uma banda]\n");
			System.out.println("insertIntegrante;nomeBanda;cpf \t\t\t\t[remover integrante de uma banda]\n");
			System.out.println("get;nome; \t\t\t\t\t\t[recuperar uma banda]\n");
			System.out.println("list \t\t\t\t\t\t\t[listar todas as bandas]\n");
			System.out.println("=====================================================");
			
			
			System.out.println("sair \t\t[encerrar a aplicação]\n");

		
			opcao = s.next();

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
				opcao = s.nextLine();
			} catch (UnknownHostException e) {
				System.out.println("Host n�o encontrado");
				e.printStackTrace();
			}
		}
		s.close();
	}

}
