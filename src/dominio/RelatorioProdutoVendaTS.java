package dominio;

import infraestrutura.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RelatorioProdutoVendaTS {
	@SuppressWarnings({ "rawtypes" })
	public List executar() {
		List venda_produto = vendaProduto();
		return venda_produto;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List vendaProduto() {
		List venda_produto = null;
		HashMap v = null;
		try {
			DBHelper db = new DBHelper();
			String sql = "SELECT V.id as venda_id, IV.produto_id, P.nome, IV.quantidade FROM venda V INNER JOIN itemvenda IV ON V.id = IV.venda_id INNER JOIN public.produto P ON IV.produto_id = P.id";
			ResultSet resultado = db.abrirSQL(sql);
			
			venda_produto = new ArrayList();
			
			while(resultado.next()) {
				v = new HashMap();
				//Venda v = new Venda();
				v.put("venda_id", resultado.getInt("venda_id"));
				v.put("produto_id", resultado.getInt("produto_id"));
				v.put("nome", resultado.getInt("nome"));
				v.put("quantidade", resultado.getInt("quantidade"));
				
				venda_produto.add(v);
			}

			db.fecharResultSet(resultado);
			db.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return venda_produto;
	}

	//SELECT SUM(P.valor) FROM venda V INNER JOIN itemvenda IV ON V.id = IV.venda_id INNER JOIN public.produto P ON IV.produto_id = P.id group by IV.produto_id, V.datarealizacao

}
