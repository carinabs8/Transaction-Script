package apresentacao.comandos;

import infraestrutura.DBHelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SalvarAlteracaoProdutoComando implements Command {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/jsps/sucesso.jsp";
		try {
			DBHelper db = new DBHelper();
			String sql = "update produto set codigo = '" + request.getParameter("codigo") + "', ";
			sql += "nome = '" + request.getParameter("nome") + "', valor = " + request.getParameter("valor");
			sql += ", idcategoria = " + request.getParameter("categoria") + " where id = " + request.getParameter("id");
			
			db.executarSQL(sql);
			db.desconectar();
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			pagina = "/jsps/erro.jsp";
		}
		
		return pagina;
	}

}
