package pacote_12643.util.componentes;

/**
 * Factory para a criação de imagens.
 * 
 * @author Tiago
 */
public interface ImagemFactory
{
	/**
	 * Cria um ponto.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Ponto createPonto(int x, int y);

	/**
	 * Cria uma matriz de pontos.
	 * 
	 * @param nl
	 * @param nc
	 * @return
	 */
	public Ponto[][] createMatriz(int nl, int nc);

	/**
	 * Cria uma imagem.
	 * 
	 * @param nl
	 * @param nc
	 * @param tamanho
	 * @return
	 */
	public PanelImagem createPanelImagem(int nl, int nc, long tamanho);
}
