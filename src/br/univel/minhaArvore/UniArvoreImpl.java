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
	
//-----------------------------------------WIP---------------------------------	
	public void printV2(UniNode<T> node) {
		String output = "";
		
		if(node == null) return;
		
		Method getId = null, getNome = null;
		Object id = null, nome = null;
		
		try {
			getId  = node.getConteudo().getClass().getMethod("getId");
			id = getId.invoke(node.getConteudo());
			getNome  = node.getConteudo().getClass().getMethod("getNome");
			nome = getNome.invoke(node.getConteudo());
		} catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
	}

	public String appendTab(UniNode<T> node) {
		
		UniNode<T> aux = node;
		String str = "";
		
		while(aux.getPai() != null) {
			aux = node.getPai();
			str += "\t";
		}
		str += "\t";
		return str;
		
	}
}
