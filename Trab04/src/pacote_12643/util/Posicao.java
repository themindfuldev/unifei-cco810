package pacote_12643.util;

/**
 * Posi��o de um pixel.
 * 
 * @author Tiago
 */
public class Posicao
{
	/**
	 * Linha e coluna. 
	 */
	private int posLinha, posColuna;

	// Construtor
	public Posicao(int posLinha, int posColuna)
	{
		this.posLinha = posLinha;
		this.posColuna = posColuna;
	}

	// M�todos
	public int getPosColuna()
	{
		return posColuna;
	}

	public int getPosLinha()
	{
		return posLinha;
	}

}
