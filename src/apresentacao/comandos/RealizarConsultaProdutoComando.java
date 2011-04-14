package apresentacao.comandos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.RealizarConsultaProdutoTS;


public class RealizarConsultaProdutoComando implements Command {
	RealizarConsultaProdutoTS realizarConsultaProdutoTS = new RealizarConsultaProdutoTS();

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/jsps/detalheProduto.jsp";
		String codigo = request.getParameter("codigo");
		
		try {
			@SuppressWarnings("rawtypes")
			HashMap p = realizarConsultaProdutoTS.busca(codigo);
			
			if (p == null){
				request.setAttribute("naoEncontrou", "Nenhum produto encontrado com o código informado");
				pagina = "/jsps/consultarProduto.jsp";
			}
			else{
			request.setAttribute("produtoConsultado", p);
			}
			
		} catch (SQLException e) {
			request.setAttribute("naoEncontrou", "Nenhum produto encontrado com o código informado");
			pagina = "/jsps/consultarProduto.jsp";
		}
			

		return pagina;
	}
}