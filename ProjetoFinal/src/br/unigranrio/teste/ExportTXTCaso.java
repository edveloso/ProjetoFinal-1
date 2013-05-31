package br.unigranrio.teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ExportTXTCaso {

	public static void main(String[] args) {

		try {
			Connection cn = null;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/projetofinal";
			String user = "root";
			String password = "root";

			cn = (Connection) DriverManager.getConnection(url, user, password);
			Statement st = (Statement) cn.createStatement();
			ResultSet res = st
					.executeQuery("SELECT * FROM casodeuso, precondicao, poscondicao, regradenegocio ,requisitonaofuncional "
							+ "WHERE casodeuso.casodeuso_id = regradenegocio.casodeuso_casodeuso_id and "
							+ "casodeuso.casodeuso_id = precondicao.casodeuso_casodeuso_id and "
							+ "casodeuso.casodeuso_id = poscondicao.casodeuso_casodeuso_id and "
							+ "casodeuso.casodeuso_id = requisitonaofuncional.casodeuso_casodeuso_id and "
							+ "casodeuso_id = 1");
			File f = new File("CasoDeUso.txt");
			FileOutputStream fp = new FileOutputStream(f);

			while (res.next()) {
				String casoDeUso_id = res.getString("casodeuso.casoDeUso_Id");
				String casoDeUso_codigo = res.getString("casodeuso.codigo");
				String casoDeUso_nome = res.getString("casodeuso.nome");
				String casoDeUso_objetivo = res.getString("casodeuso.objetivo");
				String casoDeUso_tipo = res.getString("casodeuso.tipo");
				// String projeto_nome = res.getString("projeto.nome");
				String poscondicao_descricao = res
						.getString("poscondicao.descricao");
				String precondicao_descricao = res
						.getString("precondicao.descricao");
				String regradenegocio_descricao = res
						.getString("regradenegocio.descricao");
				String requisitonaofuncional_descricao = res
						.getString("requisitonaofuncional.descricao");

				fp.write(casoDeUso_id.getBytes());
				fp.write(casoDeUso_codigo.getBytes());
				fp.write(casoDeUso_nome.getBytes());
				fp.write(casoDeUso_objetivo.getBytes());
				fp.write(casoDeUso_tipo.getBytes());
				fp.write(poscondicao_descricao.getBytes());
				fp.write(precondicao_descricao.getBytes());
				fp.write(regradenegocio_descricao.getBytes());
				fp.write(requisitonaofuncional_descricao.getBytes());

				String newline = "\r\n";
				fp.write(newline.getBytes());
				System.out.println(casoDeUso_id);
				fp.write(newline.getBytes());
				System.out.println(casoDeUso_codigo);
				fp.write(newline.getBytes());
				System.out.println(casoDeUso_nome);
				fp.write(newline.getBytes());
				System.out.println(casoDeUso_objetivo);
				fp.write(newline.getBytes());
				System.out.println(casoDeUso_tipo);
				fp.write(newline.getBytes());
				System.out.println(poscondicao_descricao);
				fp.write(newline.getBytes());
				System.out.println(precondicao_descricao);
				fp.write(newline.getBytes());
				System.out.println(regradenegocio_descricao);
				fp.write(newline.getBytes());
				System.out.println(requisitonaofuncional_descricao);

			}
			fp.flush();
			fp.close();

			cn.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}