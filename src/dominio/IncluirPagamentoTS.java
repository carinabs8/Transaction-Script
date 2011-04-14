package dominio;

import infraestrutura.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class IncluirPagamentoTS {

	public List getvendas() {
		List vendas = null;
		HashMap v = null;
		try {
			DBHelper db = new DBHelper();
			ResultSet resultado = db.abrirSQL("select id, datarealizacao from venda order by datarealizacao");
			
			vendas = new ArrayList<Venda>();
			
			while(resultado.next()) {
				v = new HashMap();
				//Venda v = new Venda();
				v.put("id",resultado.getInt("id"));
				v.put("datarealizacao", resultado.getDate("datarealizacao"));
				
				vendas.add(v);
			}
			
			db.fecharResultSet(resultado);
			db.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendas;
	}	
}
