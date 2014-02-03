package pacote_12643.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pacote_12643.util.transformacao.TransformacaoStrategy;

/**
 * Mediator para o dialogo de translacao.
 * @author Tiago
 */
public class MediatorTransformacao
{
	// Atributos
	private TransformacaoStrategy transformacao;
	private DialogoTransformacao dialogo;

	public MediatorTransformacao(DialogoTransformacao dialogo)
	{
		this.dialogo = dialogo;
	}

	// Metodos
	public TransformacaoStrategy getTransformacao()
	{
		return transformacao;
	}
	
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

}
