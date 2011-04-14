package apresentacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apresentacao.comandos.Command;
import apresentacao.comandos.CommandFactory;


/**
 * Servlet implementation class AppServlet
 */
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandFactory cmdMngr = new CommandFactory();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
    }

    protected void processaRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command cmd = cmdMngr.obterComando(request.getParameter("cmd"));

		if(cmd != null) {
			String pagina = cmd.executar(request, response);
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
		}
		else {
			response.sendRedirect("/LojaVirtual/jsps/notFound.jsp");
		}
	}

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
	}
}