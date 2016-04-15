package servico;

public class ServicoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	
	public ServicoException(String msg, Integer cod){
		super(msg);
		this.codigo = cod;
	}
	
	public Integer getCodigo(){
		return codigo;
	}
}
