package apresentacao.comandos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncluirCategoriaComando implements Command {
	
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "/jsps/incluirCategoria.jsp";
	}
	
	

	

}
