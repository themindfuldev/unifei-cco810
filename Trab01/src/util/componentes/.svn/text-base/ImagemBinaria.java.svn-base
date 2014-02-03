package util.componentes;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagemBinaria extends JPanel
{
	private MediatorImagemBinaria mediator;
	private CelulaBinaria[][] matrizCelulas;
	private int nl, nc, tamanho;

	public ImagemBinaria(int nl, int nc, int tamanho)
	{
		super();

		// Inicializacao dos componentes
		mediator = new MediatorImagemBinaria(this, nl, nc);
		matrizCelulas = new CelulaBinaria[nl][nc];
		this.nl = nl;
		this.nc = nc;
		this.tamanho = tamanho;

		// Construcao da matriz
		constroiMatriz();

		// Configuracao do layout
		setLayout(new GridLayout(nl, nc));

		// Adicao dos componentes
		adicionaMatriz();
	}

	private void adicionaMatriz()
	{
		// Declaracao de variaveis
		int i, j;

		// Adicao
		for (i = 0; i < nl; i++)
			for (j = 0; j < nc; j++)
				add(matrizCelulas[i][j]);
	}

	private void constroiMatriz()
	{
		// Declaracao de variaveis
		int i, j;

		// Construcao
		for (i = 0; i < nl; i++)
			for (j = 0; j < nc; j++)
				matrizCelulas[i][j] = new CelulaBinaria(i, j, tamanho, mediator);
	}

	public void setPosicao(int posLinha, int posColuna, boolean estado)
	{
		mediator.setPosicao(posLinha, posColuna, estado);
		matrizCelulas[posLinha][posColuna].setEstado(estado);
	}

	public void pintarPosicao(int posLinha, int posColuna, Color cor)
	{
		mediator.pintarPosicao(posLinha, posColuna, cor);
	}

	public boolean getPosicao(int posLinha, int posColuna)
	{
		return mediator.getPosicao(posLinha, posColuna);
	}

	public int getNc()
	{
		return nc;
	}

	public int getNl()
	{
		return nl;
	}

	public int getTamanho()
	{
		return tamanho;
	}

	CelulaBinaria[][] getMatrizCelulas()
	{
		return matrizCelulas;
	}

}
