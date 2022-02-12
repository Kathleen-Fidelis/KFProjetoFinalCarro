package br.com.model;

import java.lang.ref.WeakReference;


public class TesteConexao {

	public static void main(String[] args) {
		
		//Teste de conexão
		Conexao c = new Conexao();
		c.getConnection();
		WeakReference ref = new WeakReference<Object>(c);
		c = null;
		//System.gc(); //Garbage Collector
		while(ref.get() != null) {
	       System.gc();
	       System.out.println(".");
	     }
		c = new Conexao();
		c.getConnection();


	}

}
