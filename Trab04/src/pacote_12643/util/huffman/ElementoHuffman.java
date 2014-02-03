package pacote_12643.util.huffman;

/**
 * Elemento de calculo de frequencia do algoritmo Huffman.
 * 
 * @author Tiago
 */
public class ElementoHuffman
{
	/**
	 * Nivel de cinza
	 */
	private short nivelCinza;
	/**
	 * Frequencia
	 */
	private int frequencia;
	
	// Construtores
	public ElementoHuffman(short nivelCinza, int frequencia)
	{
		this.nivelCinza = nivelCinza;
		this.frequencia = frequencia;
	}
	public ElementoHuffman(NoLista noLista1, NoLista noLista2)
	{
		this.nivelCinza = -1;
		this.frequencia = noLista1.getElemento().frequencia + noLista2.getElemento().frequencia;
	}
	
	// Metodos
	public short getNivelCinza()
	{
		return nivelCinza;
	}
	
	public void setNivelCinza(short nivelCinza)
	{
		this.nivelCinza = nivelCinza;
	}
	
	public int getFrequencia()
	{
		return frequencia;
	}
	
	public void setFrequencia(int frequencia)
	{
		this.frequencia = frequencia;
	}
	
	/**
	 * Incrementa a frequencia. 
	 */
	public void incrementarFrequencia()
	{
		this.frequencia++;
	}
	
}
