package visao.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import util.transformacao.Transformacao;
import util.transformacao.TransformacaoRotacao;

@SuppressWarnings("serial")
public class PanelRotacao extends PanelTransformacao
{
	private JLabel lblOrientacao, lblAngulo;
	private JComboBox cmbOrientacao;
	private JTextField txfAngulo;

	public PanelRotacao()
	{
		// Inicializacao
		lblOrientacao = new JLabel("Orientacao: ");
		lblAngulo = new JLabel("Angulos (graus): ");
		cmbOrientacao = new JComboBox(new String[]
		{ "Anti-horario", "Horario" });
		txfAngulo = new JTextField();

		// Configuracao
		lblOrientacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAngulo.setHorizontalAlignment(SwingConstants.RIGHT);

		// Disposicao
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.ipadx = 10;
		c.gridwidth = 1;
		add(lblOrientacao, c);

		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		add(cmbOrientacao, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy = 1;
		c.gridx = 0;
		c.ipadx = 10;
		add(lblAngulo, c);

		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 1;
		c.ipadx = 100;
		add(txfAngulo, c);
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
		double angulo;

		// Obtem os dados digitados
		transformacao = null;
		indiceOrientacao = cmbOrientacao.getSelectedIndex();
		String anguloStr = txfAngulo.getText();

		// Validacao dos dados
		try
		{
			if (anguloStr.equals(""))
			{
				angulo = -1;
				throw new Exception();
			}

			angulo = Double.parseDouble(anguloStr);

			if (indiceOrientacao == 1)
				angulo = 360 - angulo;

			transformacao = new TransformacaoRotacao(angulo);
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,
					"Preencha os campos corretamente!", "Erro!",
					JOptionPane.ERROR_MESSAGE);
			txfAngulo.requestFocus();
		}

		return transformacao;
	}

}
