package apresentacao.comandos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.IncluirProdutoTS;


public class IncluirProdutoComando implements Command {

	IncluirProdutoTS incluirProdutoTS = new IncluirProdutoTS();
	
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List categorias = incluirProdutoTS.executar();
		request.setAttribute("categorias", categorias);
		return "/jsps/incluirProduto.jsp";
	}

}
