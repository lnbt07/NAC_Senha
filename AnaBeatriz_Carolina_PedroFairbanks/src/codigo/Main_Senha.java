package codigo;
import java.util.Scanner;

import codigo.PilhaChar.RetornoChar;

public class Main_Senha {

	public static void main(String[] args) {
		//declaração e inicialização da pilha
		PilhaChar pilha = new PilhaChar();
		pilha.init();
		
		//declaração para utilizar no retorno do pop
		RetornoChar aux = new RetornoChar();
		
		//inicio da declaração do vetor q vai receber e trocar as letras por simbolos ou deixar tudo em maiusculo
		char[] trocar;
		
		Scanner teclado = new Scanner(System.in);
		
		String senha;
		String senhaInvertida = "";
		
		System.out.println("Digite uma senha com caracteres especiais '_' ou '#': ");
		senha = teclado.nextLine();

		//deixar todas as letras maiusculas da senha
		senha = senha.toUpperCase();

		//finalização da declaração do vetor char q recebe os caracteres da senha
		trocar = new char[senha.length()];
		
		//troca das letras da senha pelos simbolos especiais
		trocarLetras(senha, trocar);
		
			
		for (int i = 0; i < senha.length(); i++) {
			if(trocar[i] != '#' && trocar[i] != '_') {
				pilha.push(trocar[i]);
			} else {
				while(pilha.isEmpty() != true) {
					aux = pilha.pop();
					senhaInvertida+=aux.elem;
				}
			}
		}
		System.out.println("Senha criptografada: "+senhaInvertida);
		
		teclado.close();
	}

	private static char[] trocarLetras(String senha, char[] trocar) {
		
		for (int i = 0; i < senha.length(); i++) {
			switch (senha.charAt(i)) {
			case 'A':
				trocar[i] = '@';
				break;
			
			case 'S':
				trocar[i] = '$';
				break;
				
			case 'R':
				trocar[i] = '*';
				break;
				
			case 'E':
				trocar[i] = '&';
				break;
				
			case 'I':
				trocar[i] = '!';
				break;
				
			case 'O':
				trocar[i] = '(';
				break;
				
			case 'U':
				trocar[i] = '+';
				break;
				
			default:
				trocar[i] = senha.charAt(i);
			}
		}
		
		return trocar;		
	}

}