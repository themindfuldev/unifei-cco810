package pacote_12643.visao.gui;

import javax.swing.JInternalFrame;

import pacote_12643.util.componentes.PanelImagem;


@SuppressWarnings("serial")
public class JanelaInternaImagem extends JInternalFrame
{
	private PanelImagem panelImagem;
	private static int openFrameCount = 0;
	private static final int xOffset = 30, yOffset = 30;

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

	public PanelImagem getPanelImagem()
	{
		return panelImagem;
	}

}
