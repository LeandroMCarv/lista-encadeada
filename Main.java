package listaEncadeada;

public class Main {
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		lista.adicionarNo(new NoEnc(4));
		lista.adicionarNo(new NoEnc(12));
		lista.adicionarNo(new NoEnc(3));
		System.out.println(lista.toString());
		lista.adicionarNo(new NoEnc(14));
		System.out.println(lista.toString());
	}
}