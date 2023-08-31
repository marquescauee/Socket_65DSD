package servidor;

import observer.Observer;
import command.CommandFactory;
import command.banda.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import command.pessoa.Command;
import command.pessoa.CommandCriarPessoa;
import exceptions.pessoa.PessoasException;

public class Servidor {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(80);
		server.setReuseAddress(true);

		while (true) {
			System.out.println("Aguardando conexao...");
			try (Socket conn = server.accept();) {
				System.out.println("Conectado com: " + conn.getInetAddress().getHostAddress());

				OutputStream out = conn.getOutputStream();
				InputStream in = conn.getInputStream();

				Observer obs = new Observer();

				byte[] dadosBrutos = new byte[1024];
				int qtdDadosBrutos = in.read(dadosBrutos);

				while (qtdDadosBrutos >= 0) {
					String stringDados = new String(dadosBrutos, 0, qtdDadosBrutos);

					try {
						String[] dados = stringDados.split(";");

						CommandFactory cmdP = new CommandFactory(obs);
						Command command = cmdP.getCommand(dados);
						command.execute();

						out.write(obs.getMsg().getBytes());
						out.close();
						break;
					} catch (Exception e) {
						//e.printStackTrace();
						out.write(new String("Opcao invalida, tente novamente.").getBytes());
						break;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}





























