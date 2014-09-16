package br.com.caelum.vraptor.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

//Walter hatsune miku Herondina Rodrigies De Almeida mangaká fanfic vocaloid bilieber selenator nyanyan cat watashi 4chan messi

//treze doze onze dez nove oito sete seis cinco quatro tres dois um zero

public class TesteAbreviacao {

	public String abrevia(String nomeCompleto) {
		Set<String> PREPOSICOES = new HashSet<String>(Arrays.asList(new String[] { "DA", "DOS", "DE", "DAS", "DO" }));
		System.out.println("Nome entrada: " + nomeCompleto + "\n");
		nomeCompleto = limpaNome(nomeCompleto);
		String partes[] = nomeCompleto.split(" ");
		int k;
		String nomeRetorno = "";
		
		String abreviados = "";
		
			for (int i = 0; i < partes.length; i++) {
				if(partes[i].length() == 1){
					abreviados = abreviados + " " + partes[i];
				} 
			}

			for (k = 0; k < partes.length; k++) {
				
				if (k == 0 || k == (partes.length - 1) || partes[k].length() == 1) {
					nomeRetorno = nomeRetorno + " " + partes[k] + " ";
					nomeRetorno = limpaNome(nomeRetorno);
				} else if (!PREPOSICOES.contains(partes[k].toUpperCase())) {
					String nomeTeste = nomeRetorno + " " + partes[k] + " " + partes[partes.length - 1] + " " + abreviados;
					if (nomeTeste.length() <= 40) {
						nomeRetorno = nomeRetorno + " " + partes[k] + " ";
					} else {
						nomeRetorno = nomeRetorno + " " + partes[k].charAt(0) + " ";
					}
				}
			}
			
			nomeRetorno = limpaNome(nomeRetorno); 
			
			if (nomeRetorno.length() > 40) {
				System.out.println("Nome para o recursivo: " + nomeRetorno);
				nomeRetorno = abrevia(nomeRetorno);
				
			}
			return nomeRetorno;
	}


	private String invert(String nomeCompleto) {
		
		String[] partes = nomeCompleto.split(" ");
		String retorno = "";
		
		for (int i = partes.length -1; i >-1 ; i--) {
			retorno = retorno + " " + partes[i];
		}
		return retorno;
		
	}


	public String limpaNome(String nome){
		String retorno = nome.replaceAll("  ", " ");
		return retorno.trim();
	}

	public static void main(String[] args) {

		TesteAbreviacao t = new TesteAbreviacao();
		String nomeCompletoInvertido = t.invert(JOptionPane.showInputDialog(null, "Entre com o nome completo: "));
		String nomeRetorno = t.abrevia(nomeCompletoInvertido);

		nomeRetorno = t.invert(nomeRetorno);
		JOptionPane.showMessageDialog(null, nomeRetorno + " - "+nomeRetorno.length());
		System.exit(0);
	}

}
