package apresentacao.comandos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.RelatorioProdutoVendaTS;

public class relatorioProdutoVendaComando implements Command {
	RelatorioProdutoVendaTS relatoriProdutoVendaTS = new RelatorioProdutoVendaTS();
	@SuppressWarnings({ "rawtypes" })
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List vendas_produto = relatoriProdutoVendaTS.executar();
		
		System.out.println(vendas_produto);
		
		//request.setAttribute("item_vendas", listaItemVenda);
		request.setAttribute("vendas_produto", vendas_produto);
		return "/jsps/relatorioProdutoVenda.jsp";
	}

}
