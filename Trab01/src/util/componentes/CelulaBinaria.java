package util.componentes;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CelulaBinaria extends JPanel
{
	private MediatorCelulaBinaria mediator;

	public CelulaBinaria(int posLinha, int posColuna, int tamanho,
			MediatorImagemBinaria mediatorImagem)
	{
		setSize(tamanho, tamanho);
		setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.GRAY));

		mediator = new MediatorCelulaBinaria(posLinha, posColuna, this,
				mediatorImagem);
		mediator.setEstado(false);
	}

	public void setEstado(boolean estado)
	{
		mediator.setEstado(estado);
	}

	public void setCor(Color cor)
	{
		setBackground(cor);
	}

	public void pintarCorrida(Color cor)
	{
		mediator.pintarCorrida(cor);
	}
}
