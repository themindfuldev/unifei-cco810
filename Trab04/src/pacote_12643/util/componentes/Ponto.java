package pacote_12643.util.componentes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstração do ponto.
 * @author Tiago
 */
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
	/**
	 * Cor do ponto
	 */
	private Color cor;

	// Construtor
	public Ponto(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.cor = Color.WHITE;
	}

	// Métodos
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	
	public void setCor(Color cor)
	{
		this.cor = cor;
	}
	
	public String toString()
	{
		return String.format("(%3d,%3d)", x, y);
	}

	/**
	 * Desenha o ponto na tela
	 * @param desenho
	 */
	public void desenhar(Graphics desenho)
	{
		desenho.setColor(cor);
		desenho.drawLine(x, y, x, y);
	}

}