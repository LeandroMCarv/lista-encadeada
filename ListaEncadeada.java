package listaEncadeada;

public class ListaEncadeada {
	private NoEnc cabeca;

	public NoEnc getCabeca() {
		return cabeca;
	}

	public void setCabeca(NoEnc cabeca) {
		this.cabeca = cabeca;
	}

	public ListaEncadeada() {
		this.cabeca=null;
	}
	
	public boolean estaVazia() {
		return this.cabeca==null;
	}
	
	public void adicionarNo(NoEnc no) {
		if(estaVazia()) {
			//se estiver vazia, adiciona o no na cabeça.
			this.cabeca=no;
		}
		else {
			//se nao estiver vazia:
			NoEnc noTemp = this.cabeca;
			NoEnc noAnt = null;
			//percorre toda a lista (caso necessario) e insere na ordem crescente, isto é, quando o valor do no passado é
			//menor que o proximo no da lista
			while(noTemp!=null&&noTemp.getValor()<no.getValor()) {
				noAnt=noTemp;
				noTemp=noTemp.getProximo();
			}
			//se a cabeca for maior do que o no passado:
			if(noAnt==null) {
				//o novo no aponta para a cabeca anterior
				no.setProximo(this.cabeca);
				//o novo no passa a ser a cabeça
				this.cabeca=no;
			}else {
				//se nao for inserido na cabeça, sera inserido no meio ou no fim, entao o no anterior aponta para o novo no e o novo no aponta
				//para o antigo proximo no do anterior.
				noAnt.setProximo(no);
				no.setProximo(noTemp);
			}
		}
		
/*		Adicionar de forma nao organizada
//		else {
//			NoEnc noTemp = this.cabeca;
//			while(noTemp!=null) {
//				noTemp=noTemp.getProximo();
//			}
//			noTemp.setProximo(no);
//		}
//		no.setProximo(null);
*/
	}
	
	public void adicionarNaCabeca(NoEnc no) {
		//verifica se esta vazia
		if(estaVazia()) {
			//se estiver, adiciona na cabeca
			this.cabeca=no;
		}
		else {
			//caso contrario:
			NoEnc noTemp = this.cabeca;
			//a cabeca passa a ser o novo no
			this.cabeca=no;
			//o novo no aponta para a antiga cabeca com a ajuda de um no temporario/auxiliar
			no.setProximo(noTemp);
		}
	}
	
	
	public void removerNo(int valor) {
		//verifica se há algo para remover
		if(!estaVazia()) {
			NoEnc noTemp = this.cabeca;
			NoEnc noAnt = null;
			//verifica se o no a ser removido é a cabeça
			if(noTemp.getValor()==valor) {
				//se for, a cabeça atual passa a ser o proximo no depois da cabeça
				this.cabeca=noTemp.getProximo();
				//entao a antiga cabeça passa a apontar para null
				noTemp.setProximo(null);
			}
			//caso o no a ser removido nao seja a cabeça
			else {
				//percorre toda a lista em busca do valor ate que encontre o valor, ou nao
				while(noTemp!=null&&noTemp.getValor()!=valor) {
					noAnt = noTemp;
					noTemp = noTemp.getProximo();
				}
				//se encontrado
				if(noTemp!=null) {
					//o no anterior aponta para o proximo ao no a ser removido
					noAnt.setProximo(noTemp.getProximo());
					//e entao o no a ser removido passa a apontar para null
					noTemp.setProximo(null);
				}
			}
		}
	}
	
	public void limparLista() {
		//verifica se há conteúdo para ser limpo
		if(!estaVazia()) {
			NoEnc noTemp = this.cabeca;
			//passa por toda a lista limpando os sucessores da cabeça
			while(noTemp!=null) {
				NoEnc proximo = noTemp.getProximo();
				noTemp.setProximo(null);
				noTemp = proximo;
			}
			//após isso, desreferencia a cabeça e assim, a lista está limpa
			this.cabeca=null;
		}
	}
	
	public NoEnc buscarNo(int valor) {
		NoEnc noEncontrado = null;
		//verifica se a lista tem algo para ser buscado
		if(!estaVazia()) {
			//percorre a lista enquanto nao encontra o valor e enquanto nao chega ao fim
			for(NoEnc noTemp = this.cabeca;noTemp!=null;noTemp=noTemp.getProximo()) {
				if(noTemp.getValor()==valor) {
					//se encontrado, retorna o no
					noEncontrado = noTemp;
					return noEncontrado;
				}
			}
		}
		//se nao encontrar nada, retorna null
		return null;
	}
	
	public String toString() {
		if(estaVazia()) {
			return "";
		}
		String retorno = "";
		for(NoEnc noTemp=this.cabeca;noTemp!=null;noTemp=noTemp.getProximo()) {
			retorno += noTemp.getValor();
			if(noTemp.getProximo()!=null) {
				retorno+=",";
			}
		}
		return retorno;
	}
	
}