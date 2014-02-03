package visao.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import visao.mediator.MediatorPrincipal;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame
{
	private JMenuBar menuBar;
	private JMenu mnuArquivo, mnuOperacoes, mnuAjuda;
	private JMenuItem mniNovo, mniAbrir, mniSalvar, mniSair, mniRotular8,
			mniSobre;
	private MediatorPrincipal mediator;
	private JDesktopPane desktopPane;

	public JanelaPrincipal()
	{
		// Construtor da superclasse
		super("Trabalho 01 - Editor de Imagens Binarias Sinteticas");

		// Inicializacao
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicializacao dos componentes
		mediator = new MediatorPrincipal(this);
		menuBar = new JMenuBar();
		mnuArquivo = new JMenu("Arquivo");
		mnuOperacoes = new JMenu("Operacoes");
		mnuAjuda = new JMenu("Ajuda");
		mniNovo = new JMenuItem("Novo...");
		mniAbrir = new JMenuItem("Abrir...");
		mniSalvar = new JMenuItem("Salvar...");
		mniSair = new JMenuItem("Sair");
		mniRotular8 = new JMenuItem("Rotular por conexao-8");
		mniSobre = new JMenuItem("Sobre...");
		desktopPane = new JDesktopPane();

		// Configuracao dos componentes
		mnuArquivo.add(mniNovo);
		mnuArquivo.add(mniAbrir);
		mnuArquivo.add(mniSalvar);
		mnuArquivo.addSeparator();
		mnuArquivo.add(mniSair);
		mnuOperacoes.add(mniRotular8);
		mnuAjuda.add(mniSobre);

		menuBar.add(mnuArquivo);
		menuBar.add(mnuOperacoes);
		menuBar.add(mnuAjuda);

		// Configuracao do layout
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		// Adicao dos componentes
		setJMenuBar(menuBar);
		setContentPane(desktopPane);

		// Registro dos eventos
		mediator.registraEventos();

		// Exibicao
		setVisible(true);
	}

	public JMenuItem getMniAbrir()
	{
		return mniAbrir;
	}

	public JMenuItem getMniNovo()
	{
		return mniNovo;
	}

	public JMenuItem getMniSair()
	{
		return mniSair;
	}

	public JMenuItem getMniSalvar()
	{
		return mniSalvar;
	}

	public JMenuItem getMniSobre()
	{
		return mniSobre;
	}

	public JMenuItem getMniRotular8()
	{
		return mniRotular8;
	}

	public JDesktopPane getDesktopPane()
	{
		return desktopPane;
	}

}
