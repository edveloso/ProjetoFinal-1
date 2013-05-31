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

public class CopyOfExportTXTCasoMarco {

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
					.executeQuery("Select casodeuso.casoDeUso_id as casoDeUso_id, casodeuso.codigo as casodeuso_codigo," +
							"casodeuso.nome as casodeuso_nome, casodeuso.objetivo as casodeuso_objetivo," +
							"casodeuso.tipo as casodeuso_tipo, " +
							"casodeusoator.tipoAtor as cAtor_TipoAtor," +
							"ator.nome as ator_nome," +
							"projeto.nome as projeto_nome," +
							"precondicao.descricao as preCond_Desc," +
							"poscondicao.descricao as posCond_Desc," +
							"regradenegocio.descricao as regra_Desc," +
							"requisitonaofuncional.descricao as requisito_Desc," +
							"fluxo.codigo as fluxo_codigo," +
							"fluxo.nome as fluxo_nome," +
							"fluxo.tipo as fluxo_tipo," +
							"passo.id as passo_id," +
							"passo.codigo as passo_codigo," +
							"passo.acao as passo_acao," +
							"passo.complemento as passo_complemento" +
							"FROM casodeuso" +
							"left outer join precondicao ON casodeuso.casodeuso_id=precondicao.casoDeUso_casoDeUso_id" +
							"left outer join poscondicao ON casodeuso.casodeuso_id=poscondicao.casoDeUso_casoDeUso_id" +
							"left outer join regradenegocio ON casodeuso.casodeuso_id=regradenegocio.casoDeUso_casoDeUso_id" +
							"left outer join requisitonaofuncional ON casodeuso.casodeuso_id=requisitonaofuncional.casoDeUso_casoDeUso_id" +
							"left outer join casodeusoator ON casodeuso.casodeuso_id=casodeusoator.casodeuso_id" +
							"left outer join projeto ON casodeuso.projeto_id=projeto.id" +
							"left outer join ator ON projeto.id=ator.projeto_id" +
							"left outer join fluxo ON casodeuso.casodeuso_id=fluxo.casodeuso_casodeuso_id" +
							"left outer join passo ON fluxo.id=passo.idFluxo" +
							"WHERE" +
							"casodeuso.casodeuso_id=1");
										
			Statement st1 = (Statement) cn.createStatement();
			ResultSet res1 = st1
					.executeQuery("Select casodeuso.casoDeUso_id as casoDeUso_id, casodeuso.codigo as casodeuso_codigo," +
							"casodeuso.nome as casodeuso_nome, casodeuso.objetivo as casodeuso_objetivo," +
							"casodeuso.tipo as casodeuso_tipo, " +
							"casodeusoator.tipoAtor as cAtor_TipoAtor," +
							"ator.nome as ator_nome," +
							"projeto.nome as projeto_nome," +
							"precondicao.descricao as preCond_Desc," +
							"poscondicao.descricao as posCond_Desc," +
							"regradenegocio.descricao as regra_Desc," +
							"requisitonaofuncional.descricao as requisito_Desc," +
							"fluxo.codigo as fluxo_codigo," +
							"fluxo.nome as fluxo_nome," +
							"fluxo.tipo as fluxo_tipo," +
							"passo.id as passo_id," +
							"passo.codigo as passo_codigo," +
							"passo.acao as passo_acao," +
							"passo.complemento as passo_complemento" +
							"FROM casodeuso" +
							"left outer join precondicao ON casodeuso.casodeuso_id=precondicao.casoDeUso_casoDeUso_id" +
							"left outer join poscondicao ON casodeuso.casodeuso_id=poscondicao.casoDeUso_casoDeUso_id" +
							"left outer join regradenegocio ON casodeuso.casodeuso_id=regradenegocio.casoDeUso_casoDeUso_id" +
							"left outer join requisitonaofuncional ON casodeuso.casodeuso_id=requisitonaofuncional.casoDeUso_casoDeUso_id" +
							"left outer join casodeusoator ON casodeuso.casodeuso_id=casodeusoator.casodeuso_id" +
							"left outer join projeto ON casodeuso.projeto_id=projeto.id" +
							"left outer join ator ON projeto.id=ator.projeto_id" +
							"left outer join fluxo ON casodeuso.casodeuso_id=fluxo.casodeuso_casodeuso_id" +
							"left outer join passo ON fluxo.id=passo.idFluxo" +
							"WHERE" +
							"casodeuso.casodeuso_id=1");
			
			File f = new File("CasoDeUso.txt");
			FileOutputStream fp = new FileOutputStream(f);
			
			while (res1.next()){
				String poscondicao_descricao = res1
						.getString("poscondicao.descricao");
				String newline = "\r\n";
				fp.write(poscondicao_descricao.getBytes());
				fp.write(newline.getBytes());
				System.out.println(poscondicao_descricao);
			}

			while (res.next()) {
				String casoDeUso_id = res.getString("casodeuso.casoDeUso_Id");
				String casoDeUso_codigo = res.getString("casodeuso.codigo");
				String casoDeUso_nome = res.getString("casodeuso.nome");
				String casoDeUso_objetivo = res.getString("casodeuso.objetivo");
				String casoDeUso_tipo = res.getString("casodeuso.tipo");
				// String projeto_nome = res.getString("projeto.nome");
				
				String precondicao_descricao = res
						.getString("precondicao.descricao");
				String regradenegocio_descricao = res
						.getString("regradenegocio.descricao");
				String requisitonaofuncional_descricao = res
						.getString("requisitonaofuncional.descricao");

				String newline = "\r\n";
				fp.write(casoDeUso_id.getBytes());
				fp.write(newline.getBytes());
				fp.write(casoDeUso_codigo.getBytes());
				fp.write(newline.getBytes());
				fp.write(casoDeUso_nome.getBytes());
				fp.write(newline.getBytes());
				fp.write(casoDeUso_objetivo.getBytes());
				fp.write(newline.getBytes());
				fp.write(casoDeUso_tipo.getBytes());
				fp.write(newline.getBytes());
				fp.write(precondicao_descricao.getBytes());
				fp.write(newline.getBytes());
				fp.write(regradenegocio_descricao.getBytes());
				fp.write(newline.getBytes());
				fp.write(requisitonaofuncional_descricao.getBytes());
				fp.write(newline.getBytes());
				fp.write(newline.getBytes());
			

				System.out.println(casoDeUso_id);
				System.out.println(casoDeUso_codigo);
				System.out.println(casoDeUso_nome);
				System.out.println(casoDeUso_objetivo);
				System.out.println(casoDeUso_tipo);
				
				System.out.println(precondicao_descricao);
				System.out.println(regradenegocio_descricao);
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