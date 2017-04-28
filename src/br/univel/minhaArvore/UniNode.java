package br.univel.minhaArvore;

import java.util.List;

public interface UniNode<T> {
	
	public UniNode<T> getPai();
	
	public void setPai(UniNode<T> pai);
	
	public List<UniNode<T>> getFilhos();
	
	public void addFilho(UniNode<T> node);
	
	public boolean isLeaf();
	
	public T getConteudo();

}
