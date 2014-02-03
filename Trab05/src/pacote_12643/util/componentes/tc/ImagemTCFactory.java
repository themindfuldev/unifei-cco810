package pacote_12643.util.componentes.tc;

import pacote_12643.util.componentes.ImagemFactory;
import pacote_12643.util.componentes.PanelImagem;
import pacote_12643.util.componentes.Ponto;

public class ImagemTCFactory implements ImagemFactory
{
	public Ponto[][] createMatriz(int nl, int nc)
	{
		return new PontoTC[nl][nc];
	}

	public Ponto createPonto(int x, int y)
	{
		return new PontoTC(x, y);
	}

	public PanelImagem createPanelImagem(int nl, int nc, long tamanho)
	{
		return new PanelImagemTC(nl, nc, tamanho);
	}

}
