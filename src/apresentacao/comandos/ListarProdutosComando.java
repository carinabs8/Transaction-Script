package apresentacao.comandos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.ListarProdutoTS;


public class ListarProdutosComando implements Command {
	ListarProdutoTS listarProdutoTS = new ListarProdutoTS();
	
	@SuppressWarnings("rawtypes")
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List lista = listarProdutoTS.montarListaProdutos();
		request.setAttribute("produtos", lista);
		return "/jsps/listarProdutos.jsp";
	}

}
