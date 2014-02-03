package pacote_12643.util.componentes;

import java.awt.Color;

/**
 * Ponto em tom de cinza
 * 
 * @author Tiago
 */
public class PontoTC extends Ponto
{
	/**
	 * Valor tom de cinza.
	 */
	short valor;

	// Construtores
	public PontoTC(int x, int y)
	{
		super(x, y);
	}

	// Métodos
	public short getValor()
	{
		return valor;
	}

	public void setValor(short valor)
	{
		this.valor = valor;
		setCor(new Color(valor, valor, valor));
	}

}
