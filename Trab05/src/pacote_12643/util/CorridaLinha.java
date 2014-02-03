package pacote_12643.util;

public class CorridaLinha
{
	private int linha, colunaInicio, colunaFinal, equivalencia;

	public CorridaLinha(int linha, int posicaoInicio, int posicaoFinal)
	{
		super();
		this.linha = linha;
		this.colunaInicio = posicaoInicio;
		this.colunaFinal = posicaoFinal;
	}

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
