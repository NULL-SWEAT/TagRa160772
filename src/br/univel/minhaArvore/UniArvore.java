package br.univel.minhaArvore;


public interface UniArvore<T> {

	public UniNode<T> getRaiz();
	
	public void mostrarTodosConsole();
	
	public String printNodes(UniNode<T> node, Object idx);
	
	public String printV2(UniNode<T> node);
	
}
