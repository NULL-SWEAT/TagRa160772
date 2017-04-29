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
	public StringBuilder printRec(UniNode<T> node) {
		StringBuilder sb = new StringBuilder();
		String output = "";
		Object id = null, nome = null;
		Method getId = null, getNome = null;
		
		if(!node.isLeaf()) {
			for (UniNode<T> n : node.getFilhos()) {
				
				try {
					getId  = node.getConteudo().getClass().getMethod("getId");
					getNome  = node.getConteudo().getClass().getMethod("getNome");
					id = getId.invoke(n.getConteudo());
					nome = getNome.invoke(n.getConteudo());
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				
				sb.append(appendTab(n));
				sb.append(appendIndice(n).reverse());
				sb.append(id + "\t" + nome + "\n");
				
				sb.append(printRec(n));
				
			}
		}
		return sb;
	}

	
	
	public StringBuilder appendTab(UniNode<T> node) {
		
		StringBuilder sb = new StringBuilder();
		
		if(node.hasPai()) {
			node = node.getPai();
			sb.append("\t" + appendTab(node));
		}
		return sb;
		
	}
	
	public StringBuilder appendIndice(UniNode<T> node) {
		
		StringBuilder sb = new StringBuilder();
		
		if(node.getPai() != null) {
			
			Object id = null;
			Method getId = null;
			
			try {
				getId  = node.getPai().getConteudo().getClass().getMethod("getId");
				id = getId.invoke(node.getPai().getConteudo());
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			
			sb.append("." + id);
			
			sb.append(appendIndice(node.getPai()));
		}
		return sb;
		
	}
}
