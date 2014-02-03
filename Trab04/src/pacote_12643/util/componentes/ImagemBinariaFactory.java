package pacote_12643.util.componentes;

/**
 * Factory para imagens binarias.
 * 
 * @author Tiago
 */
public class ImagemBinariaFactory implements ImagemFactory
{
	/* (non-Javadoc)
	 * @see pacote_12643.util.componentes.ImagemFactory#createMatriz(int, int)
	 */
	public Ponto[][] createMatriz(int nl, int nc)
	{
		return new PontoBinario[nl][nc];
	}

	/* (non-Javadoc)
	 * @see pacote_12643.util.componentes.ImagemFactory#createPonto(int, int)
	 */
	public Ponto createPonto(int x, int y)
	{
		return new PontoBinario(x, y);
	}

	/* (non-Javadoc)
	 * @see pacote_12643.util.componentes.ImagemFactory#createPanelImagem(int, int, long)
	 */
	public PanelImagem createPanelImagem(int nl, int nc, long tamanho)
	{
		return new PanelImagemBinaria(nl, nc);
	}

}
