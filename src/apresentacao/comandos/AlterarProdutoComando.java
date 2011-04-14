package apresentacao.comandos;

import infraestrutura.DBHelper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.IncluirProdutoTS;
import dominio.Produto;


public class AlterarProdutoComando extends IncluirProdutoComando {
	IncluirProdutoTS ts = new IncluirProdutoTS();
	
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categorias", ts.montarListaCategorias());
		
		try {
			String sql = "select p.id, p.codigo, p.nome, p.valor, p.categoria_id, c.nome as nome_cat ";
			sql += "from produto as p inner join categoriaproduto as c on p.categoria_id = c.id ";
			sql += "where p.id = " + request.getParameter("prod");
			
			DBHelper db = new DBHelper();

			ResultSet resultado = db.abrirSQL(sql);
			
			if(resultado.next()){
				Produto p = new Produto();
				p.setId(resultado.getInt("id"));
				p.setCodigo(resultado.getString("codigo").trim());
				p.setNome(resultado.getString("nome").trim());
				p.setValor(resultado.getDouble("valor"));
				p.getCategoria().setId(resultado.getInt("categoria_id"));
				p.getCategoria().setNome(resultado.getString("nome_cat").trim());
				
				request.setAttribute("produto", p);
			}

			db.fecharResultSet(resultado);
			db.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/jsps/alterarProduto.jsp";
	}
}