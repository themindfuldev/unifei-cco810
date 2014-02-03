package pacote_12643.visao;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Janela principal do sistema.
 * @author Tiago
 */
@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame
{
	// Componentes
	private JMenuBar menuBar;
	private JMenu mnuArquivo, mnuOperacoes, mnuFiltros, mnuAjuda, mnuExportar, mnuImportar;
	private JMenuItem mniAbrir, mniSair, mniObterConectados,
			mniSobre, mniZoom, mniEqualizacao, mniBinarizacao, mniGerarSal,
			mniGerarPimenta, mniFiltrarMedia, mniFiltrarMediana, 
			mniImportarRLE, mniImportarHuffman, mniExportarRLE, mniExportarHuffman;  		
	private MediatorPrincipal mediator;
	private JDesktopPane desktopPane;

	public JanelaPrincipal()
	{
		// Construtor da superclasse
		super("Trabalho 02 - Editor de Imagens");

		// Inicializacao
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
		mnuFiltros = new JMenu("Filtros");
		mnuAjuda = new JMenu("Ajuda");
		mniAbrir = new JMenuItem("Abrir...");
		mnuImportar = new JMenu("Importar");
		mniImportarRLE = new JMenuItem("Compressão RLE...");
		mniImportarHuffman = new JMenuItem("Compressão Huffman...");
		mnuExportar = new JMenu("Exportar");
		mniExportarRLE = new JMenuItem("Compressão RLE...");
		mniExportarHuffman = new JMenuItem("Compressão Huffman...");
		mniSair = new JMenuItem("Sair");
		mniObterConectados = new JMenuItem("Obter elementos conectados");
		mniZoom = new JMenuItem("Zoom...");
		mniEqualizacao = new JMenuItem("Equalizar...");
		mniBinarizacao = new JMenuItem("Binarizar...");
		mniGerarSal = new JMenuItem("Gerar ruido sal");
		mniGerarPimenta = new JMenuItem("Gerar ruido pimenta");
		mniFiltrarMedia = new JMenuItem("Filtrar por média...");
		mniFiltrarMediana = new JMenuItem("Filtrar por mediana...");
		mniSobre = new JMenuItem("Sobre...");
		desktopPane = new JDesktopPane();

		// Configuracao dos componentes
		mnuArquivo.add(mniAbrir);
		mnuArquivo.addSeparator();
		mnuArquivo.add(mnuImportar);
		mnuArquivo.add(mnuExportar);
		mnuArquivo.addSeparator();
		mnuArquivo.add(mniSair);
		mnuImportar.add(mniImportarRLE);
		mnuImportar.add(mniImportarHuffman);
		mnuExportar.add(mniExportarRLE);
		mnuExportar.add(mniExportarHuffman);
		mnuOperacoes.add(mniObterConectados);
		mnuOperacoes.add(mniZoom);
		mnuOperacoes.add(mniBinarizacao);
		mnuOperacoes.add(mniEqualizacao);
		mnuFiltros.add(mniGerarSal);
		mnuFiltros.add(mniGerarPimenta);
		mnuFiltros.addSeparator();
		mnuFiltros.add(mniFiltrarMedia);
		mnuFiltros.add(mniFiltrarMediana);
		mnuAjuda.add(mniSobre);

		menuBar.add(mnuArquivo);
		menuBar.add(mnuOperacoes);
		menuBar.add(mnuFiltros);
		menuBar.add(mnuAjuda);

		// Configuracao do layout
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		// Adicao dos componentes
		setContentPane(desktopPane);
		setJMenuBar(menuBar);

		// Registro dos eventos
		mediator.registraEventos();

		// Exibicao
		setVisible(true);
	}

	// Métodos
	public JMenuItem getMniAbrir()
	{
		return mniAbrir;
	}

	public JMenuItem getMniSair()
	{
		return mniSair;
	}

	public JMenuItem getMniSobre()
	{
		return mniSobre;
	}

	public JMenuItem getMniObterConectados()
	{
		return mniObterConectados;
	}

	public JDesktopPane getDesktopPane()
	{
		return desktopPane;
	}

	public JMenuItem getMniEscalamento()
	{
		return mniZoom;
	}

	public JMenuItem getMniEqualizacao()
	{
		return mniEqualizacao;
	}

	public JMenuItem getMniBinarizacao()
	{
		return mniBinarizacao;
	}

	public JMenuItem getMniGerarSal()
	{
		return mniGerarSal;
	}

	public JMenuItem getMniGerarPimenta()
	{
		return mniGerarPimenta;
	}

	public JMenuItem getMniFiltrarMedia()
	{
		return mniFiltrarMedia;
	}

	public JMenuItem getMniFiltrarMediana()
	{
		return mniFiltrarMediana;
	}

	public JMenuItem getMniImportarRLE()
	{
		return mniImportarRLE;
	}

	public JMenuItem getMniImportarHuffman()
	{
		return mniImportarHuffman;
	}

	public JMenuItem getMniExportarRLE()
	{
		return mniExportarRLE;
	}

	public JMenuItem getMniExportarHuffman()
	{
		return mniExportarHuffman;
	}
	
}
