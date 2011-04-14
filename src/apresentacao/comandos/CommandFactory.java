package apresentacao.comandos;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
	private Map<String, Command> comandos;
	
	public CommandFactory() {
		criarMapaComandos();
	}

	public Command obterComando(String comando) {
		return comandos.get(comando);
	}
	
	private void criarMapaComandos() {
		comandos = new HashMap<String, Command>();
		
		comandos.put("login", new EfetuarLoginComando());
		
		comandos.put("listar", new ListarProdutosComando());

		comandos.put("incluir", new IncluirProdutoComando());
		comandos.put("salvarInclusao", new SalvarInclusaoProdutoComando());

		comandos.put("consultar", new ConsultarProdutoComando());
		comandos.put("realizarConsulta", new RealizarConsultaProdutoComando());

		comandos.put("alterar", new AlterarProdutoComando());
		comandos.put("salvarAlteracao", new SalvarAlteracaoProdutoComando());
		
		comandos.put("incluirCategoria", new IncluirCategoriaComando());
		comandos.put("salvarCategoria", new SalvarInclusaoCategoriaComando());
		
		comandos.put("incluirPagamento", new IncluirPagamentoComando());
		comandos.put("salvarPagamento", new salvaPagamentoComando());
		
		comandos.put("relatorio_produto_venda", new relatorioProdutoVendaComando());
		
	}
}
