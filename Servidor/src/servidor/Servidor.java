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

				Observer obs = new Observer();

				InputStream in = conn.getInputStream();

				byte[] dadosBrutos = new byte[1024];
				int qtdDadosBrutos = in.read(dadosBrutos);

				while (qtdDadosBrutos >= 0) {
					String stringDados = new String(dadosBrutos, 0, qtdDadosBrutos);
					System.out.println(stringDados);

					try {
						String[] splitada = stringDados.split(";");
//
//						Pessoa p = new Pessoa(splitada[1]);
//
//						if (splitada.length > 1) {
//							p.setNome(splitada[2]);
//							p.setEndereco(splitada[3]);
//						}

						CommandFactory cmdP = new CommandFactory(obs);
						Command command = cmdP.getCommand(splitada);

						command.execute();
						//out.write(PessoaDao.getInstance().getPessoaPorCpf(splitada[1]).toString().getBytes());
						out.write(obs.getMsg().getBytes());
						out.close();
						break;
					    //qtdDadosBrutos = in.read(dadosBrutos);
					} catch (Exception e) {
						e.printStackTrace();
						//out.write(new String("opcao invalida, tente novamente.").getBytes());
						break;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}

//
//if(splitada[0].equals("criar")) {
//try {
//Pessoa p = new Pessoa(splitada[2]);
//p.setNome(splitada[1]);
//p.setEndereco(splitada[3]);
//
//command = new  CriarPessoa(p);
//command.execute();
//
//out.write(PessoaDao.getInstance().getPessoaPorCpf(splitada[2]).toString().getBytes());
//}catch(Exception e) {
//out.write(msgErro.getBytes());
//}
//
//
//else {
//out.write(msgErro.getBytes());
//}
//
