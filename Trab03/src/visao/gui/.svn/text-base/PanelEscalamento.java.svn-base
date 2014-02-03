package visao.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import util.transformacao.Transformacao;
import util.transformacao.TransformacaoEscalamento;

@SuppressWarnings("serial")
public class PanelEscalamento extends PanelTransformacao
{
	private JLabel lblTipo, lblFator;
	private JComboBox cmbTipo;
	private JSpinner spnFator;

	public PanelEscalamento()
	{
		// Inicializacao
		lblTipo = new JLabel("Tipo: ");
		lblFator = new JLabel("Fator: ");
		cmbTipo = new JComboBox(new String[]
		{ "Ampliacao", "Reducao" });
		spnFator = new JSpinner(new SpinnerNumberModel(2, 2, null, 1));

		// Configuracao
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFator.setHorizontalAlignment(SwingConstants.RIGHT);

		// Disposicao
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.ipadx = 10;
		c.gridwidth = 1;
		add(lblTipo, c);

		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.ipadx = 25;
		add(cmbTipo, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy = 1;
		c.gridx = 0;
		c.ipadx = 10;
		add(lblFator, c);

		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 1;
		c.ipadx = 80;
		add(spnFator, c);
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
		int indiceTipo, fator;

		// Obtem os dados digitados
		indiceTipo = cmbTipo.getSelectedIndex();
		fator = (Integer) spnFator.getValue();

		transformacao = new TransformacaoEscalamento(indiceTipo, fator);
		return transformacao;
	}

}
