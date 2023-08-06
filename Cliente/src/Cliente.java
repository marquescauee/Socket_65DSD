import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("Criando conexão");

		try (Socket conn = new Socket("192.168.1.27", 80);) {
			System.out.println("Conectado!");
			//InputStream in = conn.getInputStream();
			OutputStream out = conn.getOutputStream();
			
//			byte[] dadosBrutos = new byte[1024];
//			int qtdBytesLidos = in.read(dadosBrutos);
//			while(qtdBytesLidos >= 0) {
//				String dadosStr = new String(dadosBrutos, 0, qtdBytesLidos);
//				System.out.println(dadosStr);
//				qtdBytesLidos = in.read(dadosBrutos);
//			}
			String msg = "Vou enviar a operação de salvar uma pessoa";
			out.write(msg.getBytes());
		} catch(UnknownHostException e) {
			System.out.println("Host não encontrado");
			e.printStackTrace();
		}
	}

}
