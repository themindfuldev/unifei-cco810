package visao.gui;

import javax.swing.JInternalFrame;

import util.componentes.ImagemBinaria;

@SuppressWarnings("serial")
public class JanelaInternaImagem extends JInternalFrame
{
	private ImagemBinaria imagemBinaria;
	private static int openFrameCount = 0;
	private static final int xOffset = 30, yOffset = 30;

	public JanelaInternaImagem(ImagemBinaria imagemBinaria)
	{
		super("[Nova imagem #" + (++openFrameCount) + "]", true, true, true,
				false);

		this.imagemBinaria = imagemBinaria;

		// Configuracao do layout
		setContentPane(imagemBinaria);

		// Posicionamento
		pack();
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
	}

	public ImagemBinaria getImagemBinaria()
	{
		return imagemBinaria;
	}

}
