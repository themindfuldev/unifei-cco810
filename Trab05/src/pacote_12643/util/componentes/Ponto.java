package pacote_12643.util.componentes;

import java.awt.Color;
import java.awt.Graphics;

public class Ponto
{

	/**
	 * Coordenada x do ponto.
	 */
	private int x;
	/**
	 * Coordenada y do ponto.
	 */
	private int y;
	private Color cor;

	public Ponto(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.cor = Color.WHITE;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public void desenhar(Graphics desenho)
	{
		desenho.setColor(cor);
		desenho.drawLine(x, y, x, y);
	}

	public void setCor(Color cor)
	{
		this.cor = cor;
	}

	@Override
	public String toString()
	{
		return String.format("(%3d,%3d)", x, y);
	}

}