import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class JanelaDesktop extends JFrame implements ActionListener{

  //--------------------------------------------------------------------------------------
  //								ATRIBUTOS
  //--------------------------------------------------------------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnlDesenho;
	JPanel pnlControle;
	Arquivo arquivoDeImagem;
	int[][] matrizImagem;
	MatrizImagem matrizGrafica;
	JMenu mnuArquivo;
	JMenuItem mniNovo, mniAbrirImagem1, mniAbrirImagem2, mniSalvar, mniSair,mniConvoluir;
	JMenuBar mnbBarra;
	JLabel lblOrdemDaMatriz;
	JLabel lblNumeroDeCelulas;	
	JLabel lblNumeroDeCorridas;
	JLabel lblNumeroDeElementos;
	JMenu mnuOperacoes;
	JDesktopPane desktop;
	private FrameInternoImagem iframeImagem1;
	private FrameInternoImagem iframeImagem2;
	
	
	  //--------------------------------------------------------------------------------------
	  //								CONSTRUTOR
	  //--------------------------------------------------------------------------------------	
	
	public JanelaDesktop(){
		super("Convolução");
		  
		//Cria menu
		montaBarraMenu();
		
		//Insere desktop no frame
		desktop = new JDesktopPane();
		this.getContentPane().add(desktop, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	  //--------------------------------------------------------------------------------------
	  //								METODOS
	  //--------------------------------------------------------------------------------------
	public void montaBarraMenu(){
		//---Prepara componentes da barra de menu
		mnbBarra = new JMenuBar();
		mnuArquivo = new JMenu("Arquivo");
		
		mniNovo = new JMenuItem("Novo");
		mniNovo.setEnabled(false);
		mniAbrirImagem1 = new JMenuItem("Abrir imagem1");
		mniAbrirImagem2 = new JMenuItem("Abrir imagem2");
		mniSalvar = new JMenuItem("Salvar");
		mniSair = new JMenuItem("Sair");
		
		mniNovo.addActionListener(this);
		mniAbrirImagem1.addActionListener(this);
		mniAbrirImagem2.addActionListener(this);
		mniSair.addActionListener(this);		
		
		
		//mnuArquivo.add(mniNovo);
		mnuArquivo.add(mniAbrirImagem1);
		mnuArquivo.add(mniAbrirImagem2);
		mnuArquivo.addSeparator();
		mnuArquivo.add(mniSair);
		
		mnbBarra.add(mnuArquivo);	
		this.setJMenuBar(mnbBarra);
		this.setDefaultCloseOperation(1);
	}

	public void actionPerformed(ActionEvent e) {
		int linhas, colunas;		
		
		//--------------------------- menu Novo ---------------------------------
		if(e.getSource()==mniNovo){
			
			//this.iframeImagem1.pack();
			//this.iframeImagem2.pack();
			
/*
			linhas = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero de linhas:"));
			colunas = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero de colunas:"));
			
			FrameInternoImagem iframe = new FrameInternoImagem(linhas,colunas);
			
			// Add internal frame to desktop
		    this.desktop.add(iframe);
		    try {
				iframe.setMaximum(true);
				iframe.setSelected(true);
			} catch (Exception e2) {
				 e2.printStackTrace();
			} 
*/
		}
		
		//--------------------------- menu Abrir Imagem1 ---------------------------------
		else if(e.getSource()==mniAbrirImagem1){
			//Seta arquivo
			arquivoDeImagem = new Arquivo("imagem1.cab");
			
			//Seta Frame Interno
			this.iframeImagem1 = new FrameInternoImagem(arquivoDeImagem.getNomeDoArquivo(),arquivoDeImagem.leImagem("imagem1.cab","imagem1.img"));
						
			this.desktop.add(this.iframeImagem1);	
			try {
				this.iframeImagem1.setMaximum(true);
				this.iframeImagem1.setSelected(true);
			} catch (Exception e2) {
				 e2.printStackTrace();
			} 
		}
		
		//--------------------------- menu Abrir Imagem2 ---------------------------------
		else if(e.getSource()==mniAbrirImagem2){
			//Seta arquivo
			arquivoDeImagem = new Arquivo("imagem2.cab");
			
			//Seta Frame Interno
			this.iframeImagem2 = new FrameInternoImagem(arquivoDeImagem.getNomeDoArquivo(),arquivoDeImagem.leImagem("imagem2.cab","imagem2.img"));
						
			this.desktop.add(this.iframeImagem2);	
			try {
				this.iframeImagem2.setMaximum(true);
				this.iframeImagem2.setSelected(true);
			} catch (Exception e2) {
				 e2.printStackTrace();
			} 
		}
		
		//--------------------------- menu Sair ---------------------------------
		else if(e.getSource()==mniSair){
			System.exit(0);
		}

		
	}
}
