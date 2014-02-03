package pacote_12643.visao;

import javax.swing.JInternalFrame;

import pacote_12643.util.componentes.PanelImagem;

/**
 * Janela interna de uma imagem.
 * @author Tiago
 */
@SuppressWarnings("serial")
public class JanelaInternaImagem extends JInternalFrame
{
	// Constantes
	private static int openFrameCount = 0;
	private static final int xOffset = 30, yOffset = 30;
	
	/**
	 * Panel da imagem.
	 */
	private PanelImagem panelImagem;

	// Construtor
	public JanelaInternaImagem(PanelImagem imagem)
	{
		super("[Nova imagem #" + (++openFrameCount) + "]", true, true, true,
				false);

		this.panelImagem = imagem;

		// Configuracao do layout
		getContentPane().add(imagem);

		// Posicionamento
		setResizable(false);
		setMaximizable(false);
		pack();
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
	}

	// Métodos
	public PanelImagem getPanelImagem()
	{
		return panelImagem;
	}

}
