package dominio;

public class Produto {
	private int id;
	private String codigo;
	private String nome;
	private double valor;
	private Categoria categoria;

	public Produto(){
		setCategoria(new Categoria());
	}
	
	public Produto(String codigo, String nome, double valor) {
		this();
		setCodigo(codigo);
		setNome(nome);
		setValor(valor);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
