package pacote_12643.util.componentes;

/**
 * Imagem binaria.
 * @author Tiago
 */
@SuppressWarnings("serial")
public class PanelImagemBinaria extends PanelImagem
{
	// Construtor
	public PanelImagemBinaria(int nl, int nc)
	{
		super(nl, nc, new ImagemBinariaFactory(), 0);
	}

	/**
	 * Define uma posicao.
	 * 
	 * @param posLinha
	 * @param posColuna
	 * @param estado
	 */
	public void setPosicao(int posLinha, int posColuna, boolean estado)
	{
		((PontoBinario) getMatrizPontos()[posLinha][posColuna]).setEstado(estado);
	}

	/**
	 * Obtem uma posicao.
	 * 
	 * @param posLinha
	 * @param posColuna
	 * @return
	 */
	public boolean getPosicao(int posLinha, int posColuna)
	{
		return ((PontoBinario) getMatrizPontos()[posLinha][posColuna]).getEstado();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pacote_12643.util.componentes.PanelImagem#copiarPonto(int, int,
	 *      pacote_12643.util.componentes.Ponto)
	 */
	public void copiarPonto(int i, int j, Ponto ponto)
	{
		if (ponto instanceof PontoBinario == false)
			return;

		((PontoBinario) getMatrizPontos()[i][j]).setEstado(((PontoBinario) ponto).getEstado());
	}

}
