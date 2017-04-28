package br.univel.meusTestes;

import java.math.BigDecimal;

import br.univel.minhaArvore.UniArvore;
import br.univel.minhaArvore.UniArvoreImpl;
import br.univel.minhaArvore.UniNode;
import br.univel.minhaArvore.UniNodeImpl;

public class Principal {

	public Principal() {
		
//		Raiz do plano de contas
		Conta despesasOper = new Conta(1, "Despesas Operacionais" , new BigDecimal(0));
		UniNode<Conta> noDespOper = new UniNodeImpl<>(despesasOper);
		
		Conta contaAgua = new Conta(1, "Agua", new BigDecimal(100.25));
		UniNode<Conta> noAgua = new UniNodeImpl<>(contaAgua);
		
		Conta contaAluguel = new Conta(2, "Aluguel", new BigDecimal(100.25));
		UniNode<Conta> noAluguel = new UniNodeImpl<>(contaAluguel);
		
		Conta contaIntTel = new Conta(3, "Internet/telefone", new BigDecimal(100.25));
		UniNode<Conta> noIntTel = new UniNodeImpl<>(contaIntTel);
		
		Conta contaEnergia = new Conta(4, "Energia", new BigDecimal(100));
		UniNode<Conta> noEnergia = new UniNodeImpl<>(contaEnergia);
		
		Conta despesasAdm = new Conta(1, "Despesas Administrativas" , new BigDecimal(0));
		UniNode<Conta> noDespAdm = new UniNodeImpl<>(despesasAdm);
		noDespAdm.addFilho(noAgua);
		noDespAdm.addFilho(noAluguel);
		noDespAdm.addFilho(noIntTel);
		noDespAdm.addFilho(noEnergia);
		
		noDespOper.addFilho(noDespAdm);
		
		Conta beneficios = new Conta(1, "Beneficios", new BigDecimal(15));
		UniNode<Conta> noBeneficios= new UniNodeImpl<>(beneficios);
		
		Conta encargos = new Conta(2, "Encargos", new BigDecimal(20));
		UniNode<Conta> noEncargos = new UniNodeImpl<>(encargos);
		
		Conta salarios = new Conta(3, "Salarios", new BigDecimal(20));
		UniNode<Conta> noSalarios = new UniNodeImpl<>(salarios);
		
		Conta gastosPessoal = new Conta(2, "Gastos com Pessoal" , new BigDecimal(0));
		UniNode<Conta> noGastosPessoal = new UniNodeImpl<>(gastosPessoal);
		noGastosPessoal.addFilho(noBeneficios);
		noGastosPessoal.addFilho(noEncargos);
		noGastosPessoal.addFilho(noSalarios);
		
		noDespOper.addFilho(noGastosPessoal);
		
		Conta servLimp = new Conta(1, "Servicos de Limpeza", new BigDecimal(66.6));
		UniNode<Conta> noServLimp= new UniNodeImpl<>(servLimp);
		
		Conta servMan = new Conta(2, "Encargos", new BigDecimal(211));
		UniNode<Conta> noServMan = new UniNodeImpl<>(servMan);
		
		Conta manLimp = new Conta(3, "Manutencao e Limpeza" , new BigDecimal(0));
		UniNode<Conta> noManLimp = new UniNodeImpl<>(manLimp);
		noManLimp.addFilho(noServLimp);
		noManLimp.addFilho(noServMan);
		
		noDespOper.addFilho(noManLimp);

		//add + contas
		
		UniArvore<Conta> planoContas = new UniArvoreImpl(noDespOper);
		
		BigDecimal somaFilhos = somarFilhos(planoContas.getRaiz());
		System.out.println("\nSoma das Contas: "+ somaFilhos + "\n");
		
		planoContas.mostrarTodosConsole();
		
	}
	
	
	public BigDecimal somarFilhos(UniNode<Conta> node) {

		BigDecimal soma = node.getConteudo().getValor();
		
		if(!node.isLeaf()) {
			for (UniNode<Conta> filho : node.getFilhos()) {
				soma = soma.add(somarFilhos(filho));
			}
		}
		return soma;
	}

	
	public static void main(String[] args) {
	
		new Principal();
	}
}
