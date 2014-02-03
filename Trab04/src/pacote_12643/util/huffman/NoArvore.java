package pacote_12643.util.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 * No de Arvore Heap para o algoritmo Huffman
 * 
 * @author Tiago
 */
public class NoArvore
{
	/**
	 * Elemento relacionado.
	 */
	private ElementoHuffman elemento;
	/**
	 * Nos filhos.
	 */
	private NoArvore filhoEsquerdo, filhoDireito;

	// Construtor
	public NoArvore(ElementoHuffman elemento)
	{
		this.elemento = elemento;
	}

	// Metodos
	public NoArvore getFilhoEsquerdo()
	{
		return filhoEsquerdo;
	}

	public void setFilhoEsquerdo(NoArvore filhoEsquerdo)
	{
		this.filhoEsquerdo = filhoEsquerdo;
	}

	public NoArvore getFilhoDireito()
	{
		return filhoDireito;
	}

	public void setFilhoDireito(NoArvore filhoDireito)
	{
		this.filhoDireito = filhoDireito;
	}

	public ElementoHuffman getElemento()
	{
		return elemento;
	}

	/**
	 * Obtem as codificacoes huffman do algoritmo.
	 * 
	 * @return
	 */
	public Map<Short, String> obterCodificacoes()
	{
		Map<Short, String> tabelaCodificacoes = new HashMap<Short, String>();

		percorrerArvore(this, "", tabelaCodificacoes);

		return tabelaCodificacoes;
	}

	/**
	 * Procedimento recursivo para o percurso in-ordem da arvore.
	 * 
	 * @param raiz
	 * @param string
	 * @param tabelaCodificacoes
	 */
	private void percorrerArvore(NoArvore raiz, String string, Map<Short, String> tabelaCodificacoes)
	{
		if (raiz.filhoEsquerdo != null)
			percorrerArvore(raiz.filhoEsquerdo, string + "0", tabelaCodificacoes);

		if (raiz.elemento.getNivelCinza() >= 0)
			tabelaCodificacoes.put(raiz.elemento.getNivelCinza(), string);

		if (raiz.filhoDireito != null)
			percorrerArvore(raiz.filhoDireito, string + "1", tabelaCodificacoes);
	}
}
