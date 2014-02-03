package pacote_12643.util.huffman;

import java.util.HashMap;
import java.util.Map;

public class NoArvore
{
	private ElementoHuffman elemento;
	private NoArvore filhoEsquerdo, filhoDireito;
	
	public NoArvore(ElementoHuffman elemento)
	{
		this.elemento = elemento;
	}
	
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
	
	public Map<Short, String> obterCodificacoes()
	{
		Map<Short, String> tabelaCodificacoes = new HashMap<Short, String>(); 
		
		percorrerArvore(this, "", tabelaCodificacoes);
		
		return tabelaCodificacoes;
	}

	private void percorrerArvore(NoArvore raiz, String string,
			Map<Short, String> tabelaCodificacoes)
	{
		if (raiz.filhoEsquerdo != null)
			percorrerArvore(raiz.filhoEsquerdo, string+"0", tabelaCodificacoes);
		
		if (raiz.elemento.getNivelCinza() >= 0) 
			tabelaCodificacoes.put(raiz.elemento.getNivelCinza(), string);
		
		if (raiz.filhoDireito != null)
			percorrerArvore(raiz.filhoDireito, string+"1", tabelaCodificacoes);
	}
}
