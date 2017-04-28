package br.univel.minhaArvore;

import java.util.ArrayList;
import java.util.List;

public class UniNodeImpl<T> implements UniNode<T> {
	
	private UniNode<T> pai;
	private List<UniNode<T>> filhos;
	private T conteudo;
	
	public UniNodeImpl(T t) {
		this.conteudo = t;
	}

	@Override
	public UniNode<T> getPai() {
		return pai;
	}

	@Override
	public void setPai(UniNode<T> pai) {
		this.pai = pai;
	}
	
	@Override
	public List<UniNode<T>> getFilhos() {
		return filhos;
	}

	@Override
	public void addFilho(UniNode<T> node) {
		if(this.filhos == null) {
			this.filhos = new ArrayList<UniNode<T>>();
		}
		node.setPai(node);
		this.filhos.add(node);
	}

	@Override
	public boolean isLeaf() {
		return this.filhos == null;
	}
	
	@Override
	public T getConteudo() {
		return this.conteudo;
	}

}
