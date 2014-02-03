package pacote_12643.util.huffman;

public class NoLista implements Comparable<NoLista>
{
	private ElementoHuffman elemento;
	private NoArvore raiz;
	
	public NoLista(ElementoHuffman elemento)
	{
		this.elemento = elemento;
		this.raiz = new NoArvore(elemento);
	}

	public NoLista(NoArvore noArvore)
	{
		this.elemento = noArvore.getElemento();
		this.raiz = noArvore;
	}

	public NoArvore getRaiz()
	{
		return raiz;
	}

	public void setRaiz(NoArvore raiz)
	{
		this.raiz = raiz;
	}

	public ElementoHuffman getElemento()
	{
		return elemento;
	}

	public int compareTo(NoLista no)
	{
		return elemento.getFrequencia()-no.getElemento().getFrequencia();
	}

	@Override
	public String toString()
	{
		return elemento.getNivelCinza() + " (" + elemento.getFrequencia() + ")";
	}
	
}
