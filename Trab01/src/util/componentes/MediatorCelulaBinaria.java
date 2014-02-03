package util.componentes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MediatorCelulaBinaria
{
	private MediatorImagemBinaria mediatorImagem;
	private CelulaBinaria celulaBinaria;
	private boolean estado;
	private int posLinha, posColuna;

	public MediatorCelulaBinaria(int posLinha, int posColuna,
			CelulaBinaria celulaBinaria, MediatorImagemBinaria mediatorImagem)
	{
		this.celulaBinaria = celulaBinaria;
		this.posLinha = posLinha;
		this.posColuna = posColuna;
		this.mediatorImagem = mediatorImagem;

		// Registro de eventos
		celulaBinaria.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent arg0)
			{
				trocaEstado();
			}
		});
	}

	void setEstado(boolean estado)
	{
		this.estado = estado;
		if (estado)
			celulaBinaria.setBackground(Color.BLACK);
		else
			celulaBinaria.setBackground(Color.WHITE);
	}

	public boolean isEstado()
	{
		return estado;
	}

	private void trocaEstado()
	{
		setEstado(!estado);
		mediatorImagem.setPosicao(posLinha, posColuna, estado);
	}

	public int getPosColuna()
	{
		return posColuna;
	}

	public int getPosLinha()
	{
		return posLinha;
	}

	public void pintarCorrida(Color cor)
	{
		celulaBinaria.setBackground(cor);
	}

}
