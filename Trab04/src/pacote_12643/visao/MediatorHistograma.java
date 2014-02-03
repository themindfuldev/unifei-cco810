package pacote_12643.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Mediator para o Di�logo do Histograma.
 * @author Tiago
 */
public class MediatorHistograma
{
	/**
	 * Di�logo do Histograma.
	 */
	private DialogoHistograma dialogo;
	/**
	 * Limiar obtido.
	 */
	private Short limiar;
	
	// Construtor
	public MediatorHistograma(DialogoHistograma dialogoHistograma)
	{
		this.dialogo = dialogoHistograma;
		
		// Eventos
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

	// M�todo
	public Short getLimiar()
	{
		return limiar;
	}

}
