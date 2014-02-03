import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MatrizImagem extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//--------------------------------------------------------------------------------------
	//										ATRIBUTOS
	//--------------------------------------------------------------------------------------
	int linhas;
	int colunas;
	int limiar;
	int matrizDeInteiros[][];
	int[][] imagemBinarizada;
	boolean plotarImagemBinarizada= false;	
	Pixel matrizPixels[][];
	JToggleButton matrizBotoes[][];
	private String nomeDoArquivo;

	//--------------------------------------------------------------------------------------
	//										CONSTRUTOR
	//--------------------------------------------------------------------------------------
	public MatrizImagem(int[][] matrizInteiros, int linhas, int colunas, String nomeDoArquivo) {
		//Inicia pai
		super();		
		int i,j;

		//Inicializando atributos
		this.nomeDoArquivo = nomeDoArquivo;
		this.linhas = linhas;
		this.colunas = colunas;
		this.matrizDeInteiros = matrizInteiros;
		this.matrizPixels = new Pixel[linhas][colunas]; 

		for ( i = 0; i < this.linhas; i++) {
			for ( j = 0; j < this.colunas; j++) {
				matrizPixels[i][j] = new Pixel(i,j,0,0);
			}	
		}


		matrizBotoes = new JToggleButton[linhas][colunas];

		//Gera painel reflexo da matriz
		for( i=0; i<linhas; i++){
			for( j=0; j<colunas; j++){

				Pixel botaoPixel = new Pixel(i,j,matrizInteiros[i][j],0);				
				//add(botaoPixel);
				matrizPixels[i][j] = botaoPixel;
			}	
		}		

		this.setVisible(true);
	}//end construtor



	public MatrizImagem(int nroLinhas, int nroColunas, String nomeDoArquivo) {
		super();

		this.nomeDoArquivo = nomeDoArquivo;
		this.linhas = nroLinhas;
		this.colunas = nroColunas;

		this.setLayout(new GridLayout(nroLinhas,nroColunas));

		//---Inicializa atributos
		//Inicializa matrizDeInteiros
		this.matrizDeInteiros = new int[nroLinhas][nroColunas];
		for (int i = 0; i < nroLinhas; i++) {
			for (int j = 0; j < nroColunas; j++) {
				this.matrizDeInteiros[i][j]=0;
			}
		}

		//Inicializa matrizDePixels
		this.matrizPixels = new Pixel[nroLinhas][nroColunas];
		for (int i = 0; i < nroLinhas; i++) {
			for (int j = 0; j < nroColunas; j++) {
				this.matrizPixels[i][j] = new Pixel(i,j,0,0);;
			}
		}

		//Gera painel reflexo da matriz
		setLayout(new GridLayout(nroLinhas,nroColunas));
		for(int i=0; i<nroLinhas; i++){
			for(int j=0; j<nroColunas; j++){
				Pixel botaoPixel = new Pixel(i,j,matrizDeInteiros[i][j],0);				
				matrizPixels[i][j] = botaoPixel;
			}	
		}
	}


	//--------------------------------------------------------------------------------------
	//										METODOS
	//--------------------------------------------------------------------------------------
	public float[] funcaoTransformacao(float[] vetorFaixas){
		float[] temp = new float[vetorFaixas.length];

		temp[0] = vetorFaixas[0];
		for (int i = 1; i < vetorFaixas.length; i++) {
			temp[i] = temp[i-1] + vetorFaixas[i];
		}
		return temp;
	}

	public float[] getHistograma(int faixasDeCinza){
		int[] temp = new int[faixasDeCinza];
		float[] histograma = new float[faixasDeCinza];
		int passo, total;


		total = this.getLinhas()*this.getColunas();
		passo = 255/faixasDeCinza;
		//Verificando se é possivel calcular o histograma
		if(this.getLinhas()==0)
			return null;

		for (int i = 0; i < this.getLinhas(); i++) {
			for (int j = 0; j < this.getColunas(); j++) {
				temp[this.matrizDeInteiros[i][j]/passo] += 1;
			}
		}
		for (int i = 0; i < faixasDeCinza; i++) {
			histograma[i] = (float)temp[i]/total;
		}
		return histograma;
	}

	public void paint(Graphics g){

		//TODO : disponibilizar opcao de imprimir imagem original, imagem binarizada, imagem equalizada
		int i,j;
		for( i=0; i<linhas; i++){
			for( j=0; j<colunas; j++){
				g.setColor(new Color(matrizPixels[i][j].getCor(),matrizPixels[i][j].getCor(),matrizPixels[i][j].getCor()));
				g.drawLine(j,i, j,i);
			}
		}
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public void setPixel(int linha, int coluna, int cor, int rotulo) {
		this.matrizPixels[linha][coluna].setCor(cor);
		this.matrizPixels[linha][coluna].setRotulo(rotulo);
	}

	public Pixel[][] getMatrizPixels() {
		return matrizPixels;
	}

	public void setMatrizPixels(Pixel[][] matrizPixels) {
		this.matrizPixels = matrizPixels;
	}

	public void setValorDaMatrizPixels(MatrizImagem imagemNova) {
		
		this.linhas = imagemNova.getLinhas();
		this.colunas = imagemNova.getColunas();

		this.matrizPixels = new Pixel[this.linhas][this.colunas];
		for (int i = 0; i < this.linhas; i++) {
			for (int j = 0; j < this.colunas; j++) {
				this.matrizPixels[i][j] = new Pixel(i,j,imagemNova.getMatrizPixels()[i][j].getCor(),0);
			}
		}
	}	

	public int getLimiar() {
		return limiar;
	}



	public void setLimiar(int limiar) {
		this.limiar = limiar;
	}



	public int[][] getImagemBinarizada() {
		return imagemBinarizada;
	}



	public void setImagemBinarizada(int[][] imagemBinarizada) {
		this.imagemBinarizada = imagemBinarizada;
	}



	public boolean isPlotarImagemBinarizada() {
		return plotarImagemBinarizada;
	}



	public void setPlotarImagemBinarizada(boolean plotarImagemBinarizada) {
		this.plotarImagemBinarizada = plotarImagemBinarizada;
	}



	public String getNomeDoArquivo() {
		return nomeDoArquivo;
	}



	public void setNomeDoArquivo(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}
}
