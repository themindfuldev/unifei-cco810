package pacote_12643.util.componentes.tc;

import java.awt.Color;

import pacote_12643.util.componentes.Ponto;


public class PontoTC extends Ponto 
{
	short valor;
	
	// Construtores
	public PontoTC(int x, int y)
	{
		super(x, y);
	}
	
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
