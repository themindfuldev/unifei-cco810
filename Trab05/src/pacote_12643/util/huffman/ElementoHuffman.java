package pacote_12643.util.huffman;

public class ElementoHuffman
{
	private short nivelCinza;
	private int frequencia;
	
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
	public void incrementarFrequencia()
	{
		this.frequencia++;
	}
	
}
