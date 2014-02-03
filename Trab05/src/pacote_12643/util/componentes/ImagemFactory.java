package pacote_12643.util.componentes;

public interface ImagemFactory
{
	public Ponto createPonto(int x, int y);
	public Ponto[][] createMatriz(int nl, int nc);
	public PanelImagem createPanelImagem(int nl, int nc, long tamanho);
}
