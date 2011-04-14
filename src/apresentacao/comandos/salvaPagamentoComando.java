package apresentacao.comandos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.IncluirPagamentoTS;
import dominio.salvarPagamentoTS;

public class salvaPagamentoComando implements Command {
	IncluirPagamentoTS incluirPagamentoTS = new IncluirPagamentoTS();
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/jsps/sucesso.jsp";
		
		String data_realizacao = request.getParameter("data_realizacao");
		String total = request.getParameter("total_pagamento");
		String venda = request.getParameter("venda");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dt_realizacao = null;
		
		try {
			dt_realizacao = new java.sql.Date(format.parse(data_realizacao).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		try {
			salvarPagamentoTS.executar(dt_realizacao, total, venda);
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			pagina = "/jsps/erro.jsp";
		}
		
		return pagina;
	}

}
