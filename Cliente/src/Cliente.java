import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
	
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("sair")) {
			System.out.println("Digite a opção desejada no seguinte formato:");
			System.out.println("=====================================================");
			System.out.println("insert;cpf;nome;endereço \t[inserir uma nova pessoa]\n");
			System.out.println("update;cpf;nome;endereço \t[atualizar os dados de uma pessoa]\n");
			System.out.println("delete;cpf \t\t\t[remover uma pessoa]\n");
			System.out.println("get;cpf; \t\t\t[recuperar uma pessoa]\n");
			System.out.println("getAll \t\t\t\t[recuperar todas as pessoas]\n");
			System.out.println("sair \t\t\t\t[encerrar a aplicação]\n");

			
			Scanner s = new Scanner(System.in);
			opcao = s.next();
			
			if(opcao.equalsIgnoreCase("sair")) continue;
			
			try (Socket conn = new Socket("10.15.120.70", 80);) {
				System.out.println("Conectado!");
				InputStream in = conn.getInputStream();
				
				OutputStream out = conn.getOutputStream();
				out.write(opcao.getBytes());
				
				byte[] dadosBrutos = new byte[1024];
				int qtdDadosBrutos = in.read(dadosBrutos);
				while(qtdDadosBrutos >= 0) {
					String stringDados = new String(dadosBrutos, 0, qtdDadosBrutos);
					System.out.println(stringDados);
					qtdDadosBrutos = in.read(dadosBrutos);
				}
			} catch(UnknownHostException e) {
				System.out.println("Host não encontrado");
				e.printStackTrace();
			} finally {
				s.close();
			}
		}
	}

}
