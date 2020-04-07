package br.fiap.Senha.Main;
import java.util.Scanner;

import br.fiap.Senha.Pilha.PilhaChar;
import br.fiap.Senha.Pilha.PilhaChar.RetornoChar;

public class Main_Senha {

	public static void main(String[] args) {
		PilhaChar pilha = new PilhaChar();
		pilha.init();
		
		RetornoChar aux = new RetornoChar();
		
		Scanner teclado = new Scanner(System.in);
		
		String senha;
		String senhaInvertida = "";
		
		System.out.println("Digite uma senha com caracteres especiais '_' ou '#': ");
		senha = teclado.nextLine();
		
		for (int i = 0; i < senha.length(); i++) {
			if(senha.charAt(i) != '#' || senha.charAt(i) != '_') {
				pilha.push(senha.charAt(i));
			} else {
				while(pilha.isEmpty() != true) {
					aux = pilha.pop();
					senhaInvertida+= aux;
				}
				senhaInvertida+=senha.charAt(i);
			}
		}
		System.out.println("Senha invertida: "+senhaInvertida);
		
		teclado.close();
	}

}
