package dominio;

import java.sql.SQLException;

import infraestrutura.DBHelper;

public class salvarProdutoTS {

	public void executar(String codigo, String nome, String valor,
			int categoria_id) throws SQLException {
		DBHelper db = new DBHelper();
		String sql = "insert into produto(codigo, nome, valor, categoria_id) values('";
		sql += codigo + "', '" + nome;
		sql += "', " + valor + ", " + categoria_id + ")";
		
		db.executarSQL(sql);
		db.desconectar();
		
	}

}
