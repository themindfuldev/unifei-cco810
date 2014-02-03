package pacote_12643.util.componentes.binaria;

import java.awt.Color;

import pacote_12643.util.componentes.Ponto;


public class PontoBinario extends Ponto 
{
	boolean estado;
	// Construtores
	public PontoBinario(int x, int y)
	{
		super(x, y);
	}

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
