package dominio;

import infraestrutura.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class RealizarConsultaProdutoTS {

	public HashMap busca(String codigo) throws SQLException {
		HashMap p = null;
		
		DBHelper db = new DBHelper();
		String sql = "select p.id, p.codigo, p.nome, p.valor, p.categoria_id, c.nome as nome_cat ";
		sql += "from produto as p inner join categoriaproduto as c on p.categoria_id = c.id ";
		sql += "where p.codigo = '" + codigo + "'";

		ResultSet resultado = db.abrirSQL(sql);

		if(resultado.next()){
			p = new HashMap();
			p.put("id", resultado.getInt("id"));
			p.put("codigo", resultado.getString("codigo").trim());
			p.put("nome", resultado.getString("nome").trim());
			p.put("valor", resultado.getDouble("valor"));
			p.put("categoria_id",resultado.getInt("categoria_id"));
			p.put("nome_cat", resultado.getString("nome_cat").trim());
			
		}

		db.fecharResultSet(resultado);
		db.desconectar();
		return p;
		
	}

}
