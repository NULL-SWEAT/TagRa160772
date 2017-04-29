package br.univel.minhaArvore;

import java.lang.reflect.Method;

public interface UniArvore<T> {

	public UniNode<T> getRaiz();
	
	public StringBuilder printRec(UniNode<T> node);
	
}
