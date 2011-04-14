package dominio;

import java.util.Date;

public class Venda {
	private int id;
	private int user_id;
	private Date datarealizacao;
	private int pagamento_id;
	private int total_venda;
	
	public int getTotal_venda() {
		return total_venda;
	}
	public void setTotal_venda(int total_venda) {
		this.total_venda = total_venda;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getDatarealizacao() {
		return datarealizacao;
	}
	public void setDatarealizacao(Date datarealizacao) {
		this.datarealizacao = datarealizacao;
	}
	public int getPagamento_id() {
		return pagamento_id;
	}
	public void setPagamento_id(int pagamento_id) {
		this.pagamento_id = pagamento_id;
	}
	
	
}
