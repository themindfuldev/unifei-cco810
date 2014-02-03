package pacote_12643.util.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import pacote_12643.util.transformacao.TransformacaoStrategy;


@SuppressWarnings("serial")
public abstract class PanelImagem extends JPanel
{
	private Ponto[][] matrizPontos;
	private int nl;
	private int nc;
	private ImagemFactory factory;
	private long tamanho;

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

	private void constroiMatriz()
	{
		// Declaracao de variaveis
		int i, j;
	
		// Construcao
		for (i = 0; i < nl; i++)
			for (j = 0; j < nc; j++)
				matrizPontos[i][j] = factory.createPonto(i, j);
	}

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
	
	public void pintarPosicao(int posLinha, int posColuna, Color cor)
	{
		matrizPontos[posLinha][posColuna].setCor(cor);
		repaint();
	}
	
	public PanelImagem realizarTransformacao(TransformacaoStrategy transformacao)
	{
		return transformacao.realizarTransformacao(this);
	}

	public ImagemFactory getFactory()
	{
		return factory;
	}
	
	public Ponto getPonto(int i, int j)
	{
		return matrizPontos[i][j];
	}
	
	public abstract void copiarPonto(int i, int j, Ponto ponto);
	
	public PanelImagem copiarImagem() {
		PanelImagem novaImagem = null;
		
		try
		{
			novaImagem = (PanelImagem) this.getClass().getConstructors()[0].newInstance(nl, nc, tamanho);
			
			for (Ponto[] linhaPontos: matrizPontos) {
				for (Ponto ponto: linhaPontos) {
					novaImagem.copiarPonto(ponto.getX(), ponto.getY(), ponto);
				}
			}
		} catch (Exception e)
		{
		}
		
		return novaImagem;
	}

	public long getTamanho()
	{
		return tamanho;
	}
	
}