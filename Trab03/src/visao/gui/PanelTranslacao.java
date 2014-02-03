package visao.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import util.transformacao.Transformacao;
import util.transformacao.TransformacaoTranslacao;

@SuppressWarnings("serial")
public class PanelTranslacao extends PanelTransformacao
{
	private JLabel lblX, lblY;
	private JTextField txfX, txfY;

	public PanelTranslacao()
	{
		// Inicializacao
		lblX = new JLabel("Deslocamento X: ");
		lblY = new JLabel("Deslocamento Y: ");
		txfX = new JTextField(3);
		txfY = new JTextField(3);

		// Configuracao
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblY.setHorizontalAlignment(SwingConstants.RIGHT);

		// Disposicao
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.ipadx = 10;
		c.gridwidth = 1;
		add(lblX, c);

		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.ipadx = 80;
		add(txfX, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy = 1;
		c.gridx = 0;
		c.ipadx = 10;
		add(lblY, c);

		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.ipadx = 80;
		add(txfY, c);
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
		int x, y;

		transformacao = null;
		x = -1;

		// Obtem os dados digitados
		String xStr = txfX.getText();
		String yStr = txfY.getText();

		// Validacao dos dados
		try
		{
			if (xStr.equals(""))
			{
				x = -1;
				throw new Exception();
			}
			if (yStr.equals(""))
			{
				y = -1;
				throw new Exception();
			}

			x = Integer.parseInt(xStr);
			y = Integer.parseInt(yStr);

			transformacao = new TransformacaoTranslacao(x, y);
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,
					"Preencha os campos corretamente!", "Erro!",
					JOptionPane.ERROR_MESSAGE);
			if (x == -1)
				txfX.requestFocus();
			else
				txfY.requestFocus();
		}

		return transformacao;
	}

}
