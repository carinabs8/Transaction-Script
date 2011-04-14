package apresentacao.comandos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Categoria;
import dominio.IncluirPagamentoTS;
import dominio.IncluirProdutoTS;

public class IncluirPagamentoComando implements Command {
	IncluirPagamentoTS incluirPagamentoTS = new IncluirPagamentoTS();
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List vendas = incluirPagamentoTS.getvendas();
		request.setAttribute("vendas", vendas);
		// TODO Auto-generated method stub
		return "/jsps/incluirPagamento.jsp";
	}

}
