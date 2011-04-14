package apresentacao.comandos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Categoria;
import dominio.IncluirCategoriaTS;
import dominio.IncluirProdutoTS;

public class SalvarInclusaoCategoriaComando implements Command {
	IncluirCategoriaTS categoria = new IncluirCategoriaTS();
	
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String pagina = "/jsps/sucesso.jsp";
		String nome = request.getParameter("nome");
		try {
			categoria.adicionar(nome);
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			pagina = "/jsps/erro.jsp";
		}
		
		return pagina;
	}

}
