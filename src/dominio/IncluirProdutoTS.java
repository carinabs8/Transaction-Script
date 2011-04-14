package dominio;

import infraestrutura.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IncluirProdutoTS {

	public List executar() {
		 return montarListaCategorias();
	}
	
	public List montarListaCategorias() {
		List categorias = null;
		HashMap c = null;
		try {
			DBHelper db = new DBHelper();
			ResultSet resultado = db.abrirSQL("select id, nome from categoriaproduto order by nome");
			
			categorias = new ArrayList();
			
			while(resultado.next()) {
				c = new HashMap();
				c.put("id", resultado.getInt("id"));
				c.put("nome", resultado.getString("nome"));
				
				categorias.add(c);
			}
			
			db.fecharResultSet(resultado);
			db.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorias;
	}
}
