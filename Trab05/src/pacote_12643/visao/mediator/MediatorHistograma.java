package pacote_12643.visao.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import pacote_12643.visao.gui.DialogoHistograma;


public class MediatorHistograma
{
	private DialogoHistograma dialogo;
	private Short limiar;
	
	public MediatorHistograma(DialogoHistograma dialogoHistograma)
	{
		this.dialogo = dialogoHistograma;
		
		dialogo.getBtnOk().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				limiar = new Short((short)dialogo.getSliderLimiar().getValue());
				dialogo.dispose();
			}
		});
		dialogo.getBtnCancelar().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				limiar = null;
				dialogo.dispose();
			}
		});
		dialogo.getSliderLimiar().addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e)
			{
				dialogo.getPanelHistograma().setMarcador((short)dialogo.getSliderLimiar().getValue());
				dialogo.getPanelHistograma().repaint();
			}
		});
	}

	public Short getLimiar()
	{
		return limiar;
	}

}
