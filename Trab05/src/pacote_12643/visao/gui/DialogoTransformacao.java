package pacote_12643.visao.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pacote_12643.util.transformacao.TransformacaoStrategy;
import pacote_12643.visao.mediator.MediatorTransformacao;


/**
 * @author tiago
 */
@SuppressWarnings("serial")
public class DialogoTransformacao extends JDialog
{
	// Controle
	private MediatorTransformacao mediator;

	// Componentes GUI
	private JButton btnOK;
	private JButton btnCancelar;
	private JPanel pnlBotoes;
	private PanelTransformacao pnlTransformacao;

	public DialogoTransformacao(JFrame janela, TipoTransformacao tipo)
	{
		super(janela, true);

		// setModal(true);
		mediator = new MediatorTransformacao(this);

		// Inicializacao do GUI
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(250, 150);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicializacao dos componentes
		initComponents(tipo);

		// Adicao dos componentes
		GridLayout layout = new GridLayout(1, 2);
		layout.setHgap(10);
		pnlBotoes.setLayout(layout);
		pnlBotoes.add(btnOK);
		pnlBotoes.add(btnCancelar);

		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		add(pnlTransformacao, c);

		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(20, 0, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		c.ipadx = 0;
		c.gridy = 1;
		add(pnlBotoes, c);

		// Exibicao
		mediator.registraEventos();
		setVisible(true);
	}

	// Metodos
	/**
	 * Instanciacao dos componentes GUI.
	 */
	private void initComponents(TipoTransformacao tipo)
	{
		switch (tipo)
		{
		case ESCALAMENTO:
			setTitle("Novo escalamento");
			pnlTransformacao = new PanelEscalamento();
			break;
		}

		// JButton
		btnOK = new JButton("Ok");
		btnCancelar = new JButton("Cancelar");

		// JPanel
		pnlBotoes = new JPanel();
	}

	public TransformacaoStrategy getTransformacao()
	{
		return mediator.getTransformacao();
	}

	public JButton getBtnCancelar()
	{
		return btnCancelar;
	}

	public JButton getBtnOK()
	{
		return btnOK;
	}

	public PanelTransformacao getPnlTransformacao()
	{
		return pnlTransformacao;
	}

}
