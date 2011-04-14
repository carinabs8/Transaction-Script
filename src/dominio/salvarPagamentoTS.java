package dominio;

import infraestrutura.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class salvarPagamentoTS {
	
	public static void executar(Date dt_realizacao, String total, String venda) throws SQLException {
		int user_id = getUser(venda);
		adicionar(dt_realizacao, total,venda, user_id);
		
	}
	
	public static int getUser(String venda) throws SQLException {
		DBHelper db = new DBHelper();
		int client_id = 0;
		
		ResultSet resultado = db.abrirSQL("select cliente_id from venda where id ="+ venda);			
		while(resultado.next()) {
			client_id = resultado.getInt("cliente_id");
			System.out.print(client_id);
		}
		db.fecharResultSet(resultado);
		db.desconectar();
		return client_id;
	}
	
	public static void adicionar(java.util.Date dt_realizacao, String total,
			String venda, int user_id) throws SQLException {
		DBHelper db = new DBHelper();
		String sql = "insert into pagamento(datarealizacao, total, idvenda, cliente_id) values('";
		sql += dt_realizacao + "'" +"," + "'"+ total+ "'"+ ","+venda+ ","+ user_id+")";			
		
		db.executarSQL(sql);
		db.desconectar();
		
	}

	
		
}
