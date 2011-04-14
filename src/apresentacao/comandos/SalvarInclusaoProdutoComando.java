package apresentacao.comandos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.salvarProdutoTS;


public class SalvarInclusaoProdutoComando implements Command {
	salvarProdutoTS salvarProdutoTS = new salvarProdutoTS();
	
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pagina = "/jsps/sucesso.jsp";
		
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");
		String categoria = request.getParameter("categoria");
		
		int categoria_id = Integer.parseInt(categoria);
		
		try {
			salvarProdutoTS.executar(codigo, nome, valor, categoria_id);
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			pagina = "/jsps/erro.jsp";
		}
		
		return pagina;
	}

}
