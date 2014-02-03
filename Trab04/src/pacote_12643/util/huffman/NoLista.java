package pacote_12643.util.huffman;

/**
 * Nó de lista para algoritmo Huffman
 * @author Tiago
 */
public class NoLista implements Comparable<NoLista>
{
	/**
	 * Elemento deste nó.
	 */
	private ElementoHuffman elemento;
	/**
	 * Raiz da arvore Huffman deste no.
	 */
	private NoArvore raiz;
	
	// Construtores
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

	// Metodos
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

	public String toString()
	{
		return elemento.getNivelCinza() + " (" + elemento.getFrequencia() + ")";
	}
	
}
