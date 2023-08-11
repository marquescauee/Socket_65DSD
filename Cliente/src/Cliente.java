import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("Criando conexão...");
		
		System.out.println("Digite a opção:");
		Scanner s = new Scanner(System.in);
		String msg = s.next();
		
		try (Socket conn = new Socket("10.15.120.70", 80);) {
			System.out.println("Conectado!");
			InputStream in = conn.getInputStream();
			
			OutputStream out = conn.getOutputStream();
			out.write(msg.getBytes());
			
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
