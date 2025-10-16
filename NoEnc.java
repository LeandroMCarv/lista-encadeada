package listaEncadeada;

public class NoEnc {
	private int valor;
	private NoEnc proximo;
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public NoEnc getProximo() {
		return proximo;
	}
	public void setProximo(NoEnc proximo) {
		this.proximo = proximo;
	}
	public NoEnc(int valor) {
		this.valor = valor;
		setProximo(null);
	}
}
