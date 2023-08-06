import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(80);
		server.setReuseAddress(true);

		while (true) {
			System.out.println("Agurdando conexão");

			try (Socket conn = server.accept();) {
				System.out.println("Conectado com " + conn.getInetAddress().getHostAddress());

				InputStream in = conn.getInputStream();
				byte[] dadosDoCliente = new byte[1024];
				int qtdBytesLidos = in.read(dadosDoCliente);
				while(qtdBytesLidos >= 0) {
					String dadosStr = new String(dadosDoCliente, 0, qtdBytesLidos);
					System.out.println(dadosStr);
					qtdBytesLidos = in.read(dadosDoCliente);
				}
//				
//				OutputStream out = conn.getOutputStream();
//				
//				String msg = "Olá mundo do servidor";
//				out.write(msg.getBytes());
			}
		}

	}
}
