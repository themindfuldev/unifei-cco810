package pacote_12643.util;

/**
 * Representa uma corrida de uma linha.
 * @author Tiago
 */
public class CorridaLinha
{
	/**
	 * Numero da linha da corrida.
	 */
	private int linha;
	/**
	 * Coluna inicial da corrida.
	 */
	private int colunaInicio;
	/**
	 * Coluna final da corrida.
	 */
	private int colunaFinal;
	/**
	 * Classe de equivalencia.
	 */
	private int equivalencia;

	// Construtor
	public CorridaLinha(int linha, int posicaoInicio, int posicaoFinal)
	{
		super();
		this.linha = linha;
		this.colunaInicio = posicaoInicio;
		this.colunaFinal = posicaoFinal;
	}

	// Métodos
	public int getLinha()
	{
		return linha;
	}

	public int getColunaInicio()
	{
		return colunaInicio;
	}

	public int getColunaFinal()
	{
		return colunaFinal;
	}

	public int getEquivalencia()
	{
		return equivalencia;
	}

	public void setEquivalencia(int equivalencia)
	{
		this.equivalencia = equivalencia;
	}

}
