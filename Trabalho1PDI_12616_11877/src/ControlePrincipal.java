import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlePrincipal {
	//--------------------------------------------------------------------------------------
	//										ATRIBUTOS
	//--------------------------------------------------------------------------------------	
	private int matrizInteiros[][];
	private int numeroLinhas;
	private int numeroColunas;
	private Pixel matrizPixels[][];
	private ArrayList<Corrida> listaCorridas = new ArrayList<Corrida>();


	//--------------------------------------------------------------------------------------
	//										CONSTRUTOR
	//--------------------------------------------------------------------------------------
	public ControlePrincipal(FrameInternoImagem frameInterno) {
		//TODO
	}


	//--------------------------------------------------------------------------------------
	//										METODOS
	//--------------------------------------------------------------------------------------
	public MatrizImagem mediana(MatrizImagem imagem, String media){
		
		MatrizImagem matrizImagemFundo = imagem;
		
		MatrizImagem matrizResultado;
		ArrayList<Integer> array;
		int meio, mediana;
		
		
		int[][] matrizTemp = new int[imagem.getLinhas()][imagem.getColunas()];
		
		//Percorrendo a imagem de fundo
		for (int i = 0; i < matrizImagemFundo.getLinhas(); i++) {
			for (int j = 0; j < matrizImagemFundo.getColunas(); j++) {				
				array = new ArrayList<Integer>();
				if(i-1>=0)array.add(matrizImagemFundo.matrizPixels[i-1][j].getCor());
				if(i-1>=0 && j+1<matrizImagemFundo.getColunas())array.add(matrizImagemFundo.matrizPixels[i-1][j+1].getCor());
				if(j+1<matrizImagemFundo.getColunas())array.add(matrizImagemFundo.matrizPixels[i][j+1].getCor());
				if(i+1<matrizImagemFundo.getLinhas())array.add(matrizImagemFundo.matrizPixels[i+1][j].getCor());
				if(i+1<matrizImagemFundo.getLinhas() && j+1<matrizImagemFundo.getColunas())array.add(matrizImagemFundo.matrizPixels[i+1][j+1].getCor()); 
				if(i+1<matrizImagemFundo.getLinhas())array.add(matrizImagemFundo.matrizPixels[i+1][j].getCor());
				if(i+1<matrizImagemFundo.getLinhas() && j-1>=0)array.add(matrizImagemFundo.matrizPixels[i+1][j-1].getCor());
				if(j-1>=0)array.add(matrizImagemFundo.matrizPixels[i][j-1].getCor());
				if(i-1>=0 && j-1>=0)array.add(matrizImagemFundo.matrizPixels[i-1][j-1].getCor());
				//Ordenando o array
				Collections.sort(array);
				
				meio = array.size();
				//se for um numero par de numeros, inserir a media dos dois do meio
				if(meio % 2 ==0){
					meio/=2;
					mediana = (array.get(meio-1)+array.get(meio))/2;
					
				}
				//se for um numero impar de numeros, inserir o elemento do meio
				else{
					meio/=2;
					mediana = array.get(meio);
				}
				
				if(mediana>255)
					matrizTemp[i][j] = 255;
				else if(mediana<0)
					matrizTemp[i][j] = 0;
				else
					matrizTemp[i][j] = mediana;		
				
				System.out.println(Integer.toString(i)+" "+Integer.toString(j)+":"+mediana);
			}
		}

		matrizResultado = new MatrizImagem(matrizTemp,matrizImagemFundo.getLinhas(),matrizImagemFundo.getColunas(),matrizImagemFundo.getNomeDoArquivo());
		
		//Grava em arquivo o resultado
		Date data = new Date();
		String strData = new String(data.getYear()+"-"+data.getMonth()+"-"+data.getDay()+"-"+data.getHours()+"-"+data.getMinutes()+"-"+data.getSeconds());
		String nomeDoArquivoResultado = "resultadoDaPimenta_"+matrizImagemFundo.getNomeDoArquivo()+"_"+strData+".txt";

		Arquivo gerenciadorDeArquivo = new Arquivo();
		gerenciadorDeArquivo.gravarNoArquivo(matrizResultado.getLinhas(),matrizResultado.getColunas(),matrizResultado,nomeDoArquivoResultado);
		
		//JFrame jfrResultado =  new JFrame();
		//jfrResultado.setSize(matrizResultado.getColunas(),matrizResultado.getLinhas()+40);
		//jfrResultado.add(matrizResultado);
		//jfrResultado.setVisible(true);
		
		return matrizResultado;
	}
	
	
	
	public MatrizImagem media(MatrizImagem imagem, String media){ 
		int meioMascara, somatorio, numeroCelulasMedia, numeroElementos;
		
		MatrizImagem matrizImagemFundo = imagem;
		
		Arquivo arquivoDeImagemMedia = new Arquivo(media);
		MatrizImagem matrizImagemMascara = arquivoDeImagemMedia.lerDoArquivo();

		MatrizImagem matrizResultado;
		int[][] matrizTemp = new int[matrizImagemFundo.getLinhas()][matrizImagemFundo.getColunas()];
		//Verificando se a mascara é quadrada e de ordem par 
		if((matrizImagemMascara.getLinhas()!=matrizImagemMascara.getColunas())||(matrizImagemMascara.getColunas() % 2 ==0)){			
			JOptionPane.showMessageDialog(null,matrizImagemMascara.getLinhas()+" - "+matrizImagemMascara.getColunas());
			return null;
		}
		
		meioMascara = (matrizImagemMascara.getLinhas()/2);
		numeroCelulasMedia = (matrizImagemMascara.getLinhas());
		//Percorrendo a imagem de fundo
		for (int i = 0; i < matrizImagemFundo.getLinhas(); i++) {
			for (int j = 0; j < matrizImagemFundo.getColunas(); j++) {				
				somatorio=0;
				numeroElementos = 0;
				//Varrendo a matriz da mascara e acumulando os inteiros
				for (int k = 0; k < matrizImagemMascara.getLinhas(); k++) {
					for (int m = 0; m < matrizImagemMascara.getColunas(); m++) {						
						if((i - meioMascara + k >= 0)&&(j - meioMascara + m >= 0)&&(i - meioMascara + k < matrizImagemFundo.getLinhas())&&(j - meioMascara + m < matrizImagemFundo.getColunas())){							
							somatorio+= matrizImagemMascara.matrizPixels[k][m].getCor()*matrizImagemFundo.matrizPixels[i - meioMascara + k ][j - meioMascara + m].getCor();
							numeroElementos++;
						}
					}
				}
				if(numeroElementos!=0){
					if(somatorio/numeroElementos>255)
						matrizTemp[i][j] = 255;
					else if(somatorio/numeroElementos<0)
						matrizTemp[i][j] = 0;
					else
						matrizTemp[i][j] = somatorio/numeroElementos;
				}
				
				
			}
		}
		
		matrizResultado = new MatrizImagem(matrizTemp,matrizImagemFundo.getLinhas(),matrizImagemFundo.getColunas(),matrizImagemFundo.getNomeDoArquivo());
		
		//Grava em arquivo o resultado
		Date data = new Date();
		String strData = new String(data.getYear()+"-"+data.getMonth()+"-"+data.getDay()+"-"+data.getHours()+"-"+data.getMinutes()+"-"+data.getSeconds());
		String nomeDoArquivoResultado = "resultadoDaPimenta_"+matrizImagemFundo.getNomeDoArquivo()+"_"+strData+".txt";

		Arquivo gerenciadorDeArquivo = new Arquivo();
		gerenciadorDeArquivo.gravarNoArquivo(matrizResultado.getLinhas(),matrizResultado.getColunas(),matrizResultado,nomeDoArquivoResultado);		

		//JFrame jfrResultado =  new JFrame();
		//jfrResultado.add(matrizResultado);
		//jfrResultado.setVisible(true);
		
		return matrizResultado;
	}
	
	
	public MatrizImagem sal(MatrizImagem imagem, int pontos){
		MatrizImagem matrizImagemFundo = new MatrizImagem(imagem.getLinhas(),imagem.getColunas(),imagem.getNomeDoArquivo());
		
		//matrizImagemFundo.setMatrizPixels(imagem.getMatrizPixels());
		
		for (int i = 0; i < matrizImagemFundo.getLinhas(); i++) {
			for (int j = 0; j < matrizImagemFundo.getColunas(); j++) {
				matrizImagemFundo.getMatrizPixels()[i][j].setCor(imagem.getMatrizPixels()[i][j].getCor());
			}
		}
		
		
		for (int i = 0; i < pontos; i++) {
			matrizImagemFundo.getMatrizPixels()[(int)(Math.random()*matrizImagemFundo.getLinhas())][(int)(Math.random()*matrizImagemFundo.getColunas())].setCor(255);
		}		
		
		//Grava em arquivo o resultado
		Date data = new Date();
		String strData = new String(data.getYear()+"-"+data.getMonth()+"-"+data.getDay()+"-"+data.getHours()+"-"+data.getMinutes()+"-"+data.getSeconds());
		String nomeDoArquivoResultado = "resultadoDaPimenta_"+matrizImagemFundo.getNomeDoArquivo()+"_"+strData+".txt";

		Arquivo gerenciadorDeArquivo = new Arquivo();
		gerenciadorDeArquivo.gravarNoArquivo(matrizImagemFundo.getLinhas(),matrizImagemFundo.getColunas(),matrizImagemFundo,nomeDoArquivoResultado);		

		//JFrame jfrResultado =  new JFrame();
		//jfrResultado.add(matrizImagemFundo);
		//jfrResultado.setVisible(true);
		
		return matrizImagemFundo;
	}

	
	public MatrizImagem pimenta(MatrizImagem imagem, int pontos){
		MatrizImagem matrizImagemFundo = new MatrizImagem(imagem.getLinhas(),imagem.getColunas(),imagem.getNomeDoArquivo());
		
		//matrizImagemFundo.setMatrizPixels(imagem.getMatrizPixels());
		
		for (int i = 0; i < matrizImagemFundo.getLinhas(); i++) {
			for (int j = 0; j < matrizImagemFundo.getColunas(); j++) {
				matrizImagemFundo.getMatrizPixels()[i][j].setCor(imagem.getMatrizPixels()[i][j].getCor());
			}
		}
		
		
		for (int i = 0; i < pontos; i++) {
			matrizImagemFundo.getMatrizPixels()[(int)(Math.random()*matrizImagemFundo.getLinhas())][(int)(Math.random()*matrizImagemFundo.getColunas())].setCor(0);
		}		
		
		//Grava em arquivo o resultado
		Date data = new Date();
		String strData = new String(data.getYear()+"-"+data.getMonth()+"-"+data.getDay()+"-"+data.getHours()+"-"+data.getMinutes()+"-"+data.getSeconds());
		String nomeDoArquivoResultado = "resultadoDaPimenta_"+matrizImagemFundo.getNomeDoArquivo()+"_"+strData+".txt";

		Arquivo gerenciadorDeArquivo = new Arquivo();
		gerenciadorDeArquivo.gravarNoArquivo(matrizImagemFundo.getLinhas(),matrizImagemFundo.getColunas(),matrizImagemFundo,nomeDoArquivoResultado);		

		//JFrame jfrResultado =  new JFrame();
		//jfrResultado.add(matrizImagemFundo);
		//jfrResultado.setVisible(true);
		
		return matrizImagemFundo;
	}
	
	
	public Float[] equalizar(MatrizImagem imagemOriginal, int nroDeFaixas, Float[] faixaDoHistograma){

		Float[] faixaEqualizada = new Float[nroDeFaixas];
		Float[] diferenca = new Float[nroDeFaixas];
		Float[] faixaSomada = new Float[nroDeFaixas];

		//Calcula somatoria de faixas probabilisticas
		for (int i = 0; i < nroDeFaixas; i++) {
			faixaSomada[i]= new Float(0);
			for (int j = 0; j <= i; j++) {
				faixaSomada[i] += faixaDoHistograma[j];
			}
		}
		
		//Zera histograma equalizado
		for (int i = 0; i < nroDeFaixas; i++) {
			faixaEqualizada[i]= new Float(0);
		}

		//Para cada faixa antiga mapeia uma faixa nova
		for(int i=0; i<nroDeFaixas; i++){
			//Calcula vetor diferencas para o mapeamento
			for(int j=0; j<nroDeFaixas; j++){
				diferenca[j] = Math.abs(faixaSomada[i]-(new Float(j)/new Float(nroDeFaixas)));
			}

			//Encontra nova faixa, ou seja de menor diferenca
			Float menorDiferenca = new Float(Integer.MAX_VALUE);
			int indiceDaNovaFaixa=-1;
			for(int j=0; j<nroDeFaixas; j++){
				if(diferenca[j] < menorDiferenca){
					menorDiferenca = diferenca[j];
					indiceDaNovaFaixa = j;
				}
			}

			//Repassa valor da faixa antiga para faixa nova
			if(indiceDaNovaFaixa<0){
				System.out.println("Indice da nova faixa do histograma equalizado não pode ser calculado.");
			}
			else {
				faixaEqualizada[indiceDaNovaFaixa] += faixaDoHistograma[i];
				
				//--------------Atualiza imagem para equalizacao
				double passo = 255/nroDeFaixas;
				for(int r=0; r<imagemOriginal.getLinhas(); r++){
					for(int s=0; s<imagemOriginal.getColunas(); s++){
						if(Math.round(imagemOriginal.getMatrizPixels()[r][s].getCor()/passo)==i){
							imagemOriginal.getMatrizPixels()[r][s].setCor((int)(indiceDaNovaFaixa*passo));
						}
					}
				}
				//----------------------------------------------
			}
		}
		
		return faixaEqualizada;
	}

	public MatrizImagem getImagemLimiarizada(MatrizImagem imagem){
		int[][] matrizDaImagemLimiarizada = new int[imagem.getLinhas()][imagem.getColunas()];

		//Compara cada valor com o valor limiar t, e binariz a matriz
		for (int i = 0; i < imagem.getLinhas(); i++) {
			for (int j = 0; j < imagem.getColunas(); j++) {
				if(imagem.getMatrizPixels()[i][j].getCor() < imagem.getLimiar())
					matrizDaImagemLimiarizada[i][j] = 0;
				else
					matrizDaImagemLimiarizada[i][j] = 255;
			}
		}
		
		//Grava em arquivo o resultado
		Date data = new Date();
		String strData = new String(data.getYear()+"-"+data.getMonth()+"-"+data.getDay()+"-"+data.getHours()+"-"+data.getMinutes()+"-"+data.getSeconds());
		String nomeDoArquivoResultado = "resultadoDaBinarizacao_"+imagem.getNomeDoArquivo()+"_"+strData+".txt";

		MatrizImagem resultado = new MatrizImagem(matrizDaImagemLimiarizada,imagem.getLinhas(),imagem.getColunas(),nomeDoArquivoResultado);

		Arquivo gerenciadorDeArquivo = new Arquivo();
		gerenciadorDeArquivo.gravarNoArquivo(resultado.getLinhas(),resultado.getColunas(),resultado,nomeDoArquivoResultado);		

		//JFrame jfrResultado =  new JFrame();
		//jfrResultado.add(resultado);
		//jfrResultado.setVisible(true);
		return resultado;
	}


	public Float[] geraHistograma(MatrizImagem imagem, int nroDeFaixas){
		//Variaveis
		Float[] faixa = new Float[nroDeFaixas];
		int[] temp = new int[nroDeFaixas];
		int passo, total;

		total = imagem.getLinhas()*imagem.getColunas();
		passo = 255/nroDeFaixas;
		//Verificando se é possivel calcular o histograma
		if(imagem.getLinhas()>0){
			for (int i = 0; i < imagem.getLinhas(); i++) {
				for (int j = 0; j < imagem.getColunas(); j++) {
					if(Math.floor(imagem.matrizPixels[i][j].getCor()/passo)>nroDeFaixas-1){
						temp[nroDeFaixas-1] += 1;
					}
					else {
						temp[Math.round(imagem.matrizPixels[i][j].getCor()/passo)] += 1;
					}
				}
			}
			for (int i = 0; i < nroDeFaixas; i++) {
				faixa[i] = (float)temp[i]/total;
			}
		}
		return faixa;
	}


	public void identificaCorridas(){
		int i, j;
		boolean corridaEstaAberta;
		Corrida corridaAtual;
		int contadorDeCorridas;

		contadorDeCorridas = 0;
		corridaEstaAberta = false;

		for (i = 0; i < this.numeroLinhas; i++) {
			for (j = 0; j < this.numeroColunas; j++) {
				//Pixel preenchido encontrado
				if(matrizPixels[i][j].getCor()!=0){
					//---Verifica se incrementa corrida atual ou se cria nova corrida
					//Incrementa corrida atual
					if(corridaEstaAberta){
						listaCorridas.get(contadorDeCorridas-1).adicionaCelula(matrizPixels[i][j]);
					}//if: incrementa corrida atual

					//Cria nova corrida
					else{
						contadorDeCorridas++;
						corridaAtual = new Corrida(contadorDeCorridas-1);
						corridaAtual.adicionaCelula(matrizPixels[i][j]);
						listaCorridas.add(corridaAtual);
						corridaEstaAberta=true;
					}//else: cria nova corrida
				}//if: pixel preenchido

				//Pixel NAO preenchido encontrado
				else {
					if(corridaEstaAberta){//Encerrar corrida
						corridaEstaAberta = false;
					}
				}//else: pixel nao preenchido encontrado
			}//for: percorre colunas

			//Quebra de linha > Encerra corrida
			corridaEstaAberta = false;
		}//for: percorre linhas
	}//end method

	//TODO: Fazer colorir
	public void rotular(String fundo){
		/*
		Arquivo arquivoDeImagemFundo = new Arquivo(fundo);
		MatrizImagem matrizPixel = new MatrizImagem(arquivoDeImagemFundo.lerDoArquivo(),arquivoDeImagemFundo.getNroLinhas(),arquivoDeImagemFundo.getNroColunas());
		int rotuloAtual;
		Pixel r = new Pixel(0,0,0,0);
		Pixel t = new Pixel(0,0,0,0);

		rotuloAtual = 0;
		for (int i = 0; i < matrizPixel.getOrdemLinhas() ; i++) {
			for (int j = 0; j < matrizPixel.getOrdemColunas() ; j++) {
				if(matrizPixel.matrizDeInteiros[i][j]==1){
					//Constroi r
					if((i-1)<0 || j<0){
						r.setCor(0);
					}
					else{
						r.setCor(matrizPixel.matrizDeInteiros[i-1][j]);
					}
					//Constroi t
					if(i<0 || (j-1)<0){
						t.setCor(0);
					}
					else{
						t.setCor(matrizPixel.matrizDeInteiros[i][j-1]);
					}					

					//Tratando R e T = 0
					if(r.getCor()==0 && t.getCor()==0 ){
						//novo Rótulo
						matrizPixel.matrizPixels[i][j].setRotulo(++rotuloAtual);
					}

					//Tratando R ou T = 1
					if((r.getCor()==1 && t.getCor()==0)|| (r.getCor()==0 && t.getCor()==1) ){
						//Pega rotulo de quem é igual a 1
						if(r.getCor()==1)
							matrizPixel.matrizPixels[i][j].setRotulo(matrizPixel.matrizPixels[i-1][j].getRotulo());
						if(t.getCor()==1)
							matrizPixel.matrizPixels[i][j].setRotulo(matrizPixel.matrizPixels[i][j-1].getRotulo());
					}

					//Tratando R e T = 1
					if(r.getCor()==1 && t.getCor()==1 ){
						//Se Rotulo de R=Rotulo de T
						if(matrizPixel.matrizPixels[i-1][j].getRotulo()==matrizPixel.matrizPixels[i][j-1].getRotulo()){
							//Rotulo de T=Rotulo de P = Rotulo de R
							matrizPixel.matrizPixels[i][j].setRotulo(matrizPixel.matrizPixels[i][j-1].getRotulo());
						}
						else{
							//	Rotulo de T=Rotulo de P e marca-se equivalencia entra R e T	
							this.equivalenciaRotulos(matrizPixel.matrizPixels[i-1][j].getRotulo(),matrizPixel.matrizPixels[i][j-1].getRotulo(),matrizPixel.matrizPixels[i][j],matrizPixel);
						}
					}
				}
				System.out.print(Integer.toString(matrizPixel.matrizPixels[i][j].getRotulo())+ " ");
			}System.out.print("\n");
		}
		rotuloAtual=1;
	}
	private void equivalenciaRotulos(int rotuloR, int rotuloT, Pixel pixel, MatrizImagem matrizPixel) {
		// TODO Auto-generated method stub

		int novoRotulo = Integer.parseInt(Integer.toString(rotuloR)+Integer.toString(rotuloT));

		for (int i = 0; i < matrizPixel.getOrdemLinhas() ; i++) {
			for (int j = 0; j < matrizPixel.getOrdemColunas() ; j++) {
				if(i!=pixel.getLinha() && j!=pixel.getColuna())
					if(matrizPixel.matrizPixels[i][j].getRotulo()==rotuloR || matrizPixel.matrizPixels[i][j].getRotulo()==rotuloT){
						matrizPixel.matrizPixels[i][j].setRotulo(novoRotulo);
					}
			}
		}
		 */
	}



	public MatrizImagem convoluir(MatrizImagem imagem, String mascara){
		int meioMascara, somatorio;

		MatrizImagem matrizImagemFundo = imagem;

		Arquivo arquivoDeImagemMascara = new Arquivo(mascara);
		MatrizImagem matrizImagemMascara = arquivoDeImagemMascara.lerDoArquivo();

		int[][] matrizTemp = new int[matrizImagemFundo.getLinhas()][matrizImagemFundo.getColunas()];
		//Verificando se a mascara é quadrada e de ordem par 
		if((matrizImagemMascara.getLinhas()!=matrizImagemMascara.getColunas())||(matrizImagemMascara.getColunas() % 2 ==0)){			
			JOptionPane.showMessageDialog(null,matrizImagemMascara.getLinhas()+" - "+matrizImagemMascara.getColunas());
			return null;
		}

		meioMascara = (matrizImagemMascara.getLinhas()/2);

		//Percorrendo a imagem de fundo
		for (int i = 0; i < matrizImagemFundo.getLinhas(); i++) {
			for (int j = 0; j < matrizImagemFundo.getColunas(); j++) {				
				somatorio=0;
				//Varrendo a matriz da mascara e acumulando os inteiros
				for (int k = 0; k < matrizImagemMascara.getLinhas(); k++) {
					for (int m = 0; m < matrizImagemMascara.getColunas(); m++) {						
						if((i - meioMascara + k >= 0)&&(j - meioMascara + m >= 0)&&(i - meioMascara + k < matrizImagemFundo.getLinhas())&&(j - meioMascara + m < matrizImagemFundo.getColunas()))							
							somatorio+= matrizImagemMascara.matrizPixels[k][m].getCor()*matrizImagemFundo.matrizPixels[i - meioMascara + k ][j - meioMascara + m].getCor();
					}
				}
				if(somatorio>255)
					matrizTemp[i][j] = 255;
				else if(somatorio<0)
					matrizTemp[i][j] = 0;
				else
					matrizTemp[i][j] = somatorio;
			}
		}

		//Grava em arquivo o resultado
		Date data = new Date();
		String strData = new String(data.getYear()+"-"+data.getMonth()+"-"+data.getDay()+"-"+data.getHours()+"-"+data.getMinutes()+"-"+data.getSeconds());
		String nomeDoArquivoResultado = "resultadoDaConvolucao_"+matrizImagemFundo.getNomeDoArquivo()+"_"+strData+".txt";

		MatrizImagem resultado = new MatrizImagem(matrizTemp,matrizImagemFundo.getLinhas(),matrizImagemFundo.getColunas(),nomeDoArquivoResultado);

		Arquivo gerenciadorDeArquivo = new Arquivo();
		gerenciadorDeArquivo.gravarNoArquivo(resultado.getLinhas(),resultado.getColunas(),resultado,nomeDoArquivoResultado);		

		//JFrame jfrResultado =  new JFrame();
		//jfrResultado.add(resultado);
		//jfrResultado.setVisible(true);
		return resultado;
	}



	public MatrizImagem escalar(MatrizImagem imagem, int escala){

		int i,j,k,linhas,colunas;

		MatrizImagem matrizImagemFundo = imagem;
		int[][] matrizInteiros,matrizTemp;

		matrizTemp = new int[0][0];
		linhas = colunas = 0;

		linhas 	= imagem.getLinhas()*escala;
		colunas = imagem.getColunas()*escala;


		matrizTemp = new int[linhas][colunas];
		matrizInteiros = new int[linhas][colunas];
		for (i = 0; i < matrizImagemFundo.getLinhas(); i++) {
			for (j = 0; j < matrizImagemFundo.getColunas(); j++) {	
				matrizInteiros[i][j] =  matrizImagemFundo.matrizPixels[i][j].getCor();
			}
		}			

		for (i = 0; i < matrizImagemFundo.getLinhas(); i++) {
			for (j = 0; j < matrizImagemFundo.getColunas(); j++) {					
				for (k = j*escala; k < (j+1)*escala; k++) {
					matrizTemp[i][k] = matrizInteiros[i][j];
				}
			}
		}
		for (i = 0; i < matrizImagemFundo.getLinhas(); i++) {
			for (j = 0; j < colunas; j++) {	
				matrizInteiros[i][j] =  matrizTemp[i][j];
			}
		}			

		for (i = 0; i < colunas; i++) {
			for (j = 0; j < matrizImagemFundo.getLinhas(); j++) {					
				for (k = j*escala; k < (j+1)*escala; k++) {
					matrizTemp[k][i] = matrizInteiros[j][i];
				}
			}
		}

		//Grava em arquivo o resultado
		Date data = new Date();
		String strData = new String(data.getYear()+"-"+data.getMonth()+"-"+data.getDay()+"-"+data.getHours()+"-"+data.getMinutes()+"-"+data.getSeconds());
		String nomeDoArquivoResultado = "resultadoDoEscalamento_"+matrizImagemFundo.getNomeDoArquivo()+"_"+strData+".txt";		//Recupera resultado

		MatrizImagem resultado = new MatrizImagem(matrizTemp,linhas,colunas,nomeDoArquivoResultado);

		Arquivo gerenciadorDeArquivo = new Arquivo();
		gerenciadorDeArquivo.gravarNoArquivo(resultado.getLinhas(),resultado.getColunas(),resultado,nomeDoArquivoResultado);

		//JFrame jfrResultado =  new JFrame();
		//jfrResultado.add(resultado);
		//jfrResultado.setVisible(true);
		
		return resultado;
	}

	public MatrizImagem espelhar(String arquivoDimensoes, MatrizImagem imagem){
		int i,j,linhas,colunas;

		MatrizImagem matrizImagemFundo = imagem;

		linhas = imagem.getLinhas()*2;
		colunas = imagem.getColunas()*2;

		int[][] matrizTemp = new int[linhas][colunas];
		for (i = 0; i < matrizImagemFundo.getLinhas(); i++) {
			for (j = 0; j < matrizImagemFundo.getColunas(); j++) {
				matrizTemp[i][j] = matrizImagemFundo.matrizPixels[i][j].getCor();
				matrizTemp[linhas-i-1][j] = matrizImagemFundo.matrizPixels[i][j].getCor();
				matrizTemp[i][colunas-j-1] = matrizImagemFundo.matrizPixels[i][j].getCor();
				matrizTemp[linhas-i-1][colunas-j-1] = matrizImagemFundo.matrizPixels[i][j].getCor();
			}
		}

		//Grava em arquivo o resultado
		Date data = new Date();
		String strData = new String(data.getYear()+"-"+data.getMonth()+"-"+data.getDay()+"-"+data.getHours()+"-"+data.getMinutes()+"-"+data.getSeconds());
		String nomeDoArquivoResultado = "resultadoDoEspelhamento_"+matrizImagemFundo.getNomeDoArquivo()+"_"+strData+".txt";		//Recupera resultado

		MatrizImagem resultado = new MatrizImagem(matrizTemp,linhas,colunas,nomeDoArquivoResultado);

		Arquivo gerenciadorDeArquivo = new Arquivo();
		gerenciadorDeArquivo.gravarNoArquivo(resultado.getLinhas(),resultado.getColunas(),resultado,nomeDoArquivoResultado);

		//JFrame jfrResultado =  new JFrame();
		//jfrResultado.add(resultado);
		//jfrResultado.setVisible(true);
		
		return resultado;
	}

	public MatrizImagem rotacionar(MatrizImagem imagem, double angulo){
		int i,j, linhas, colunas,x,y;

		//MatrizImagem matrizImagemFundo = imagem;
		//linhas = imagem.getLinhas();
		//colunas = imagem.getColunas();

		//Aumenta a imagem para rotacao
		int diagonal = (int)Math.sqrt(Math.pow(imagem.getLinhas(), 2) + Math.pow(imagem.getColunas(), 2));
		linhas = colunas = diagonal;
		//linhas = 2*imagem.getLinhas();
		//colunas = 2*imagem.getColunas();

		MatrizImagem imagemAumentada = new MatrizImagem(linhas,colunas,"aumentada"+imagem.getNomeDoArquivo());
		for (i = 0; i < imagem.getLinhas(); i++) {
			for (j = 0; j < imagem.getColunas(); j++) {
				imagemAumentada.getMatrizPixels()[i+Math.abs(imagem.getLinhas()-linhas)/2][j+Math.abs(imagem.getColunas()-colunas)/2].setCor(imagem.getMatrizPixels()[i][j].getCor());
			}
		} 

		MatrizImagem matrizImagemFundo = imagemAumentada;

		//Encontra ponto central
		int xCentral = matrizImagemFundo.getLinhas()/2;
		int yCentral = matrizImagemFundo.getColunas()/2;

		int[][] matrizTemp = new int[linhas][colunas];

		for (i = Math.abs(imagem.getLinhas()-matrizImagemFundo.getLinhas())/2; i < (matrizImagemFundo.getLinhas()-Math.abs(imagem.getLinhas()-matrizImagemFundo.getLinhas())/2); i++) {
			for (j = Math.abs(imagem.getColunas()-matrizImagemFundo.getColunas())/2; j < (matrizImagemFundo.getColunas()-Math.abs(imagem.getColunas()-matrizImagemFundo.getColunas())/2); j++) {
				y = yCentral+(int)((j-yCentral)*Math.cos(angulo) - (i-xCentral)*Math.sin(angulo));
				x = xCentral+(int)((i-xCentral)*Math.cos(angulo) + (j-yCentral)*Math.sin(angulo));
				if(x>=0 && x<linhas && y>=0 && y<colunas){
					//if((x+(Math.abs(xCentral-i)))>=0 && (x+(Math.abs(xCentral-i)))<linhas && (y-(Math.abs(yCentral-j)))>=0 && (y-(Math.abs(yCentral-j)))<colunas){
					matrizTemp[x][y] = matrizImagemFundo.matrizPixels[i][j].getCor();
				}		
				else {
					//JOptionPane.showMessageDialog(null, "("+x+">=0 && "+x+"<"+linhas+" && "+y+">=0 && "+y+"<"+colunas+")");
				}
			}
		}

		//Grava em arquivo o resultado
		Date data = new Date();
		String strData = new String(data.getYear()+"-"+data.getMonth()+"-"+data.getDay()+"-"+data.getHours()+"-"+data.getMinutes()+"-"+data.getSeconds());
		String nomeDoArquivoResultado = "resultadoDaRotacao_"+matrizImagemFundo.getNomeDoArquivo()+"_"+strData+".txt";		//Recupera resultado

		MatrizImagem resultado = new MatrizImagem(matrizTemp,linhas,colunas,nomeDoArquivoResultado);

		Arquivo gerenciadorDeArquivo = new Arquivo();
		gerenciadorDeArquivo.gravarNoArquivo(resultado.getLinhas(),resultado.getColunas(),resultado,nomeDoArquivoResultado);

		//JFrame jfrResultado =  new JFrame();
		//jfrResultado.add(resultado);
		//jfrResultado.setVisible(true);
		
		return resultado;
	}


	public int getNumeroDeCorridas(){
		return this.listaCorridas.size();	
	}



	public int[][] getMatrizInteiros() {
		return matrizInteiros;
	}




}//end class


