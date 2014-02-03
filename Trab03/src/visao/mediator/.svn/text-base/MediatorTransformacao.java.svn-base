package visao.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.transformacao.Transformacao;
import visao.gui.DialogoTransformacao;

/**
 * Mediator para o dialogo de translacao.
 */
public class MediatorTransformacao
{
	// Atributos
	private Transformacao transformacao;
	private DialogoTransformacao dialogo;

	public MediatorTransformacao(DialogoTransformacao dialogo)
	{
		this.dialogo = dialogo;
	}

	// Metodos
	public void registraEventos()
	{
		dialogo.getBtnOK().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				transformacao = dialogo.getPnlTransformacao().getTransformacao();
				dialogo.dispose();
			}
		});
		dialogo.getBtnCancelar().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				dialogo.dispose();
			}
		});
	}

	public Transformacao getTransformacao()
	{
		return transformacao;
	}

}
