import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;


public class Arquivo {

	//--------------------------------------------------------------------------------------
	//										ATRIBUTOS
	//--------------------------------------------------------------------------------------
	private String nomeDoArquivo = new String();
	private int nroLinhas;
	private int nroColunas;
	private MatrizImagem imagem;
	
	//--------------------------------------------------------------------------------------
	//										CONSTRUTOR
	//--------------------------------------------------------------------------------------
	//Construtor para arquvos recem criados
	public Arquivo() {
		nomeDoArquivo = null;
	}
	public Arquivo(String nome) {
		nomeDoArquivo = nome;
	}//end construtor
	
	
	
	//--------------------------------------------------------------------------------------
	//										METODOS
	//--------------------------------------------------------------------------------------
	
	
/*
 	===================================================
	NÃO APAGAR : 		    até o fechamento do projeto
	===================================================
	public int[][] lerDoArquivo(){
		//Variaveis
		int[][] matrizDePixel = new int[0][0];
		this.nroLinhas = 0;
		this.nroColunas = 0;
		
		try
		{
			FileReader reader = new FileReader(nomeDoArquivo);
			BufferedReader leitor = new BufferedReader(reader);

			String linha = null;

			int contLinha = 0;
			String[] strLinha;
			while((linha = leitor.readLine()) != null) {
				//---Obtem nro de linhas e nro de colunas
				if(contLinha==0){
					strLinha = linha.split("\\s");
					nroLinhas = Integer.parseInt(strLinha[0]);
					nroColunas = Integer.parseInt(strLinha[1]);
					matrizDePixel = new int[nroLinhas][nroColunas];
				}//if primeira linha metadados
				//---Obtem valores da matriz
				else {
					strLinha = linha.split("\\s");
					for(int contColuna=0; contColuna<nroColunas; contColuna++){
						matrizDePixel[(contLinha-1)][contColuna] = Integer.parseInt(strLinha[contColuna]);  
					}//for
				}//else demais linhas, valores binarios da matriz
				contLinha++;				
			}//while

			leitor.close();
			reader.close();

		}
		catch (FileNotFoundException FNFe) {
			JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo");			
		}
		catch (IOException IOe) {
			JOptionPane.showMessageDialog(null,IOe.getMessage());
		}
		
		return matrizDePixel;
	}//end method
*/
	
	public MatrizImagem lerDoArquivo(){
		//Variaveis
		this.nroLinhas = 0;
		this.nroColunas = 0;
		
		try
		{
			FileReader reader = new FileReader(nomeDoArquivo);
			BufferedReader leitor = new BufferedReader(reader);

			String linha = null;

			int contLinha = 0;
			String[] strLinha;
			while((linha = leitor.readLine()) != null) {
				//---Obtem nro de linhas e nro de colunas
				if(contLinha==0){
					strLinha = linha.split("\\s");
					nroLinhas = Integer.parseInt(strLinha[0]);
					nroColunas = Integer.parseInt(strLinha[1]);

					//Instancia imagem
					this.imagem = new MatrizImagem(nroLinhas,nroColunas,this.nomeDoArquivo);
					this.imagem.setLinhas(nroLinhas);
					this.imagem.setColunas(nroColunas);
				}
				//---Obtem valores da matriz
				else {
					strLinha = linha.split("\\s");
					for(int contColuna=0; contColuna<nroColunas; contColuna++){
						//Le valores inteiros do arquivo
						//imagem.getMatrizDePixels()[(contLinha-1)][contColuna].setCor(Integer.parseInt(strLinha[contColuna]));
						//JOptionPane.showMessageDialog(null, "cor: "+Integer.parseInt(strLinha[contColuna]));
						imagem.setPixel((contLinha-1), contColuna, Integer.parseInt(strLinha[contColuna]), 0);
					}
				}
				contLinha++;				
			}

			leitor.close();
			reader.close();

		}
		catch (FileNotFoundException FNFe) {
			JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo");			
		}
		catch (IOException IOe) {
			JOptionPane.showMessageDialog(null,IOe.getMessage());
		}
		
		//JOptionPane.showMessageDialog(null, "imagem: ["+imagem.getOrdemLinhas()+"]["+imagem.getOrdemColunas()+"]");
		return this.imagem;
	}//end method
	
	
	public MatrizImagem leImagem(String arquivoDimensoes, String arquivoImagem){
		//Variaveis
		MatrizImagem imagem;
		this.nroLinhas = 0;
		this.nroColunas = 0;
		//Lendo as dimensoes
		try
		{
			FileReader readerDimensoes = new FileReader(arquivoDimensoes);
			BufferedReader leitor = new BufferedReader(readerDimensoes);			
			String[] strLinha;
			String linha = null;
			linha = leitor.readLine();
			strLinha = linha.split("\\s");
			nroLinhas = Integer.parseInt(strLinha[0]);
			nroColunas = Integer.parseInt(strLinha[1]);
			leitor.close();
			readerDimensoes.close();

		}
		catch (FileNotFoundException FNFe) {
			JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo1");			
		}
		catch (IOException IOe) {
			JOptionPane.showMessageDialog(null,IOe.getMessage());
		}
		
		imagem = new MatrizImagem(nroLinhas,nroColunas,this.nomeDoArquivo);
		
		//Lendo a imagem
		try
		{
			FileReader readerImagem = new FileReader(arquivoImagem);
			BufferedReader leitorImagem = new BufferedReader(readerImagem);	
			String linhaImagem = null;
			int contLinha = 0;
			
			String[] strLinhaImagem;
			//while((linhaImagem = leitorImagem.readLine()) != null) {
			while(contLinha<nroLinhas){
				linhaImagem = leitorImagem.readLine();
				strLinhaImagem = linhaImagem.split("\\s");
				for(int contColuna=0; contColuna<nroColunas; contColuna++){
					//matrizDePixel[contLinha][contColuna] = Integer.parseInt(strLinhaImagem[contColuna]);
					imagem.getMatrizPixels()[contLinha][contColuna].setCor(Integer.parseInt(strLinhaImagem[contColuna]));
				}//for
				contLinha++;
			}//while
			leitorImagem.close();
			readerImagem.close();
		}
		catch (FileNotFoundException FNFe) {
			JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo2");			
		}
		catch (IOException IOe) {
			JOptionPane.showMessageDialog(null,IOe.getMessage());
		}
		
		return imagem;
	}//end method
	
	
	
	
	public void gravarNoArquivo(int linhas, int colunas, MatrizImagem matriz, String nomeDoArquivo){
		FileOutputStream fos;
	    
	    try {
	      File file= new File(nomeDoArquivo);
	      fos = new FileOutputStream(file);
	      PrintStream dos = new PrintStream(fos);
	      dos.print(linhas+" "+colunas);
	      dos.println();
	      for(int x=0; x<linhas; x++){
	    	  for(int y=0; y<colunas; y++){
				  dos.print(matriz.getMatrizPixels()[x][y].getCor());	
	    		  if(y!=colunas-1){
	    			  dos.print (" ");
	    		  }	
	    		  
	    	  }
	    	  dos.println();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}



	public int getNroLinhas() {
		return nroLinhas;
	}

	public void setNroLinhas(int nroLinhas) {
		this.nroLinhas = nroLinhas;
	}

	public int getNroColunas() {
		return nroColunas;
	}

	public void setNroColunas(int nroColunas) {
		this.nroColunas = nroColunas;
	}
	public String getNomeDoArquivo() {
		return nomeDoArquivo;
	}
	public void setNomeDoArquivo(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}
	
}
