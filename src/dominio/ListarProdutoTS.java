package dominio;

import infraestrutura.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListarProdutoTS {

	public List montarListaProdutos() {
		List lista = null;
		HashMap produto = null;
		try {
			DBHelper db = new DBHelper();
			String sql = "select p.id, p.codigo, p.nome, p.valor, p.categoria_id, c.nome as nome_cat ";
			sql += "from produto as p inner join categoriaproduto as c on p.categoria_id = c.id order by p.nome";
			ResultSet resultado = db.abrirSQL(sql);
			
			lista = new ArrayList();
			
			while(resultado.next()) {
				produto = new HashMap();
				produto.put("id", resultado.getInt("id"));
				produto.put("codigo", resultado.getString("codigo"));
				produto.put("nome", resultado.getString("nome").trim());
				produto.put("valor", resultado.getDouble("valor"));
				produto.put("categoria_id", resultado.getInt("categoria_id"));
				produto.put("nome_cat", resultado.getString("nome_cat").trim());
				lista.add(produto);
			}

			db.fecharResultSet(resultado);
			db.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
