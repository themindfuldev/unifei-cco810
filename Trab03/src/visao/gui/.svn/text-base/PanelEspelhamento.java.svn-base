package visao.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import util.transformacao.Transformacao;
import util.transformacao.TransformacaoEspelhamento;

@SuppressWarnings("serial")
public class PanelEspelhamento extends PanelTransformacao
{
	private JLabel lblSentido;
	private JComboBox cmbSentido;

	public PanelEspelhamento()
	{
		// Inicializacao
		lblSentido = new JLabel("Sentido: ");
		cmbSentido = new JComboBox(new String[]
		{ "Horizontal", "Vertical" });

		// Configuracao
		lblSentido.setHorizontalAlignment(SwingConstants.RIGHT);

		// Disposicao
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.ipadx = 10;
		c.gridwidth = 1;
		add(lblSentido, c);

		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		add(cmbSentido, c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see visao.gui.PanelTransformacao#getTransformacao()
	 */
	public Transformacao getTransformacao()
	{
		// Declaracao de variaveis
		Transformacao transformacao;
		int indiceOrientacao;

		// Obtem os dados digitados
		indiceOrientacao = cmbSentido.getSelectedIndex();

		transformacao = new TransformacaoEspelhamento(indiceOrientacao == 0);

		return transformacao;
	}

}
