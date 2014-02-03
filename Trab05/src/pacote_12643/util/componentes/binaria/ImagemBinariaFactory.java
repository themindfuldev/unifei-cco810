package pacote_12643.util.componentes.binaria;

import pacote_12643.util.componentes.ImagemFactory;
import pacote_12643.util.componentes.PanelImagem;
import pacote_12643.util.componentes.Ponto;

public class ImagemBinariaFactory implements ImagemFactory
{
	public Ponto[][] createMatriz(int nl, int nc)
	{
		return new PontoBinario[nl][nc];
	}

	public Ponto createPonto(int x, int y)
	{
		return new PontoBinario(x, y);
	}

	public PanelImagem createPanelImagem(int nl, int nc, long tamanho)
	{
		return new PanelImagemBinaria(nl, nc);
	}

}
