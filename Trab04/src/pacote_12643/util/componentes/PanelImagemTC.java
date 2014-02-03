package pacote_12643.util.componentes;

import pacote_12643.util.Descritor;

/**
 * Imagem em tons de cinza.
 * 
 * @author Tiago
 */
@SuppressWarnings("serial")
public class PanelImagemTC extends PanelImagem
{
	// Construtor
	public PanelImagemTC(int nl, int nc, long tamanho)
	{
		super(nl, nc, new ImagemTCFactory(), tamanho);
	}

	/**
	 * Define uma posicao.
	 * 
	 * @param posLinha
	 * @param posColuna
	 * @param valor
	 */
	public void setPosicao(int posLinha, int posColuna, short valor)
	{
		((PontoTC) getMatrizPontos()[posLinha][posColuna]).setValor(valor);
	}

	/**
	 * Obtém uma poscao.
	 * 
	 * @param posLinha
	 * @param posColuna
	 * @return
	 */
	public short getPosicao(int posLinha, int posColuna)
	{
		return ((PontoTC) getMatrizPontos()[posLinha][posColuna]).getValor();
	}

	/* (non-Javadoc)
	 * @see pacote_12643.util.componentes.PanelImagem#copiarPonto(int, int, pacote_12643.util.componentes.Ponto)
	 */
	public void copiarPonto(int i, int j, Ponto ponto)
	{
		if (ponto instanceof PontoTC == false)
			return;

		((PontoTC) getMatrizPontos()[i][j]).setValor(((PontoTC) ponto).getValor());
	}

	/**
	 * Binariza uma imagem tons de cinza, utilizando histograma.
	 * @param limiar
	 * @return
	 */
	public PanelImagem binarizarImagem(short limiar)
	{
		// Variáveis
		PanelImagemBinaria imagemNova;

		// Cria imagem binaria.
		imagemNova = new PanelImagemBinaria(getNl(), getNc());

		// Para cada ponto, seta sua posicao binarizada. 
		for (PontoTC[] linhaPonto : (PontoTC[][]) getMatrizPontos())
		{
			for (PontoTC ponto : linhaPonto)
			{
				imagemNova.setPosicao(ponto.getX(), ponto.getY(), binarizar(ponto.getValor(), limiar));
			}
		}

		return imagemNova;
	}

	/**
	 * Obtém o valor binário segundo o limiar.
	 * @param readShort
	 * @param limiar
	 * @return
	 */
	private boolean binarizar(short readShort, short limiar)
	{
		if (readShort < limiar)
			return true;
		return false;
	}

	/**
	 * Equaliza uma imagem tons de cinza, por histograma
	 * @param faixas
	 * @return
	 */
	public PanelImagem equalizarImagem(int faixas)
	{
		// Variáveis
		PanelImagem imagemNova;
		Descritor descritor;

		// Cria descrição e obtém equalização
		descritor = new Descritor(this);
		imagemNova = descritor.equalizar(faixas);

		return imagemNova;
	}

	/**
	 * Transforma a matriz de pontos em matriz de valores.
	 * @return
	 */
	public short[][] getMatrizValores()
	{
		short[][] matriz = new short[getNl()][getNc()];
		int i, j;

		for (i = 0; i < getNl(); i++)
		{
			for (j = 0; j < getNc(); j++)
			{
				matriz[i][j] = ((PontoTC) getMatrizPontos()[i][j]).getValor();
			}
		}

		return matriz;
	}

}
