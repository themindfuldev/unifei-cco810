package pacote_12643.util.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import pacote_12643.util.transformacao.TransformacaoStrategy;

/**
 * Abstração de uma imagem genérica.
 * 
 * @author Tiago
 */
@SuppressWarnings("serial")
public abstract class PanelImagem extends JPanel
{
	/**
	 * Matriz de pixels da imagem.
	 */
	private Ponto[][] matrizPontos;
	/**
	 * Numero de linhas.
	 */
	private int nl;
	/**
	 * Numero de colunas.
	 */
	private int nc;
	/**
	 * Factory para criar elementos da imagem.
	 */
	private ImagemFactory factory;
	/**
	 * Tamanho da imagem em bytes.
	 */
	private long tamanho;

	// Construtor
	public PanelImagem(int nl, int nc, ImagemFactory factory, long tamanho)
	{
		super();

		// Inicializacao dos componentes
		matrizPontos = factory.createMatriz(nl, nc);
		this.nl = nl;
		this.nc = nc;
		this.factory = factory;
		this.tamanho = tamanho;

		// Construcao da matriz
		constroiMatriz();

		setPreferredSize(new Dimension(nl, nc));
	}

	// Métodos
	public int getNc()
	{
		return nc;
	}

	public int getNl()
	{
		return nl;
	}

	public Ponto[][] getMatrizPontos()
	{
		return matrizPontos;
	}

	public ImagemFactory getFactory()
	{
		return factory;
	}

	public Ponto getPonto(int i, int j)
	{
		return matrizPontos[i][j];
	}

	public long getTamanho()
	{
		return tamanho;
	}

	public void paint(Graphics desenho)
	{
		// Declaracao de variaveis
		int i, j;

		super.paint(desenho);

		// Construcao
		for (i = 0; i < nl; i++)
			for (j = 0; j < nc; j++)
				matrizPontos[i][j].desenhar(desenho);
	}

	/**
	 * Copia um ponto para outro, mantendo sua variação.
	 * 
	 * @param i
	 * @param j
	 * @param ponto
	 */
	public abstract void copiarPonto(int i, int j, Ponto ponto);

	/**
	 * Popula a matriz com pontos.
	 */
	private void constroiMatriz()
	{
		// Declaracao de variaveis
		int i, j;

		// Construcao
		for (i = 0; i < nl; i++)
			for (j = 0; j < nc; j++)
				matrizPontos[i][j] = factory.createPonto(i, j);
	}

	/**
	 * Pinta uma posição com outra cor.
	 * 
	 * @param posLinha
	 * @param posColuna
	 * @param cor
	 */
	public void pintarPosicao(int posLinha, int posColuna, Color cor)
	{
		matrizPontos[posLinha][posColuna].setCor(cor);
		repaint();
	}

	/**
	 * Realiza uma transformação na imagem.
	 * 
	 * @param transformacao
	 * @return
	 */
	public PanelImagem realizarTransformacao(TransformacaoStrategy transformacao)
	{
		return transformacao.realizarTransformacao(this);
	}

	/**
	 * Copia uma imagem para realizar uma transformação
	 * 
	 * @return
	 */
	public PanelImagem copiarImagem()
	{
		PanelImagem novaImagem = null;

		try
		{
			// Cria uma imagem por programação reflexiva.
			novaImagem = (PanelImagem) this.getClass().getConstructors()[0].newInstance(nl, nc, tamanho);

			// Copia seus pontos de forma genérica.
			for (Ponto[] linhaPontos : matrizPontos)
			{
				for (Ponto ponto : linhaPontos)
				{
					novaImagem.copiarPonto(ponto.getX(), ponto.getY(), ponto);
				}
			}
		} catch (Exception e)
		{
		}

		return novaImagem;
	}

}