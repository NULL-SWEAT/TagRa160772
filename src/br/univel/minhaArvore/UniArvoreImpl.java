package br.univel.minhaArvore;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.univel.meusTestes.Conta;
import br.univel.minhaArvore.UniNodeImpl;

public class UniArvoreImpl<T> implements UniArvore<T> {

	private UniNode<T> raiz;

	public UniArvoreImpl(UniNode<T> noRaiz) {
		this.raiz = noRaiz;
	}
	
	@Override
	public UniNode<T> getRaiz() {
		return raiz;
	}
	
	
	@Override
	public void mostrarTodosConsole() {
		
		String saida = "";

		if(raiz != null) {
			saida += raiz.getConteudo().toString() + "\n";
			
			Method getId = null;
			Object id = null;
			
			try {
				getId  = raiz.getConteudo().getClass().getMethod("getId");
				id = getId.invoke(raiz.getConteudo());
			} catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			
			int idx = 1;
			saida += printNodes(raiz, id);
		}
		else System.out.println("Arvore vazia.");
		
		System.out.println(saida);
	}
	
	@Override
	public String printNodes(UniNode<T> node, Object idx) {
		
		String saida = "\t";

		if(!node.isLeaf()) {
			for (UniNode<T> filho : node.getFilhos()) {
				
				if(filho.isLeaf()) saida += "\t" + idx + ".";

				Method getId = null;
				Object id = null;
				
				try {
					getId  = filho.getConteudo().getClass().getMethod("getId");
					id = getId.invoke(node.getConteudo());
				} catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
				
				saida += id + "." + filho.getConteudo().toString() + "\n";
				
				saida += printNodes(filho, idx);

			}
		}
		
		return saida;
	}

}
