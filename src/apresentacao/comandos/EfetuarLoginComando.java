package apresentacao.comandos;

import infraestrutura.DBHelper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.Usuario;


public class EfetuarLoginComando implements Command {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/jsps/menu.jsp";
		
		try {
			DBHelper db = new DBHelper();
			ResultSet resultado = db.abrirSQL("select nome, login, senha from usuario where login = '" + 
						 					   request.getParameter("login") + "' and senha = '" + 
						 					   request.getParameter("senha") + "'");

			if(resultado.next()) {
				Usuario u = new Usuario();
				u.setNome(resultado.getString("nome").trim());
				u.setLogin(resultado.getString("login").trim());
				u.setSenha(resultado.getString("senha").trim());
				
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuario", u);
				
				db.fecharResultSet(resultado);
				db.desconectar();
			} else {
				request.setAttribute("msgErro", "Login ou senha inválidos.");
				pagina = "/index.jsp";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pagina;
	}

}
