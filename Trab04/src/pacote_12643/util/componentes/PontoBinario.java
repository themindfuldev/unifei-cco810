package pacote_12643.util.componentes;

import java.awt.Color;

/**
 * Ponto binario.
 * @author Tiago
 */
public class PontoBinario extends Ponto 
{
	/**
	 * Estado binario
	 */
	boolean estado;
	
	// Construtores
	public PontoBinario(int x, int y)
	{
		super(x, y);
	}

	// Métodos
	public boolean getEstado()
	{
		return estado;
	}
	
	public void setEstado(boolean estado)
	{
		this.estado = estado;

		if (estado == true)
			setCor(Color.BLACK);
		else
			setCor(Color.WHITE);
	}

}
