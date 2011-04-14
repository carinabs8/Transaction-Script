package dominio;

import infraestrutura.DBHelper;

import java.sql.SQLException;

public class IncluirCategoriaTS {
	
	public void adicionar(String nome) throws SQLException {

		DBHelper db = new DBHelper();
		String sql = "insert into categoriaproduto(nome) values('";
		sql += nome + "'"  + ")";			
		
		db.executarSQL(sql);
		db.desconectar();
	}

}
