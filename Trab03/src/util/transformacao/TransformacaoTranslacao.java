package util.transformacao;

import util.componentes.ImagemBinaria;

public class TransformacaoTranslacao implements Transformacao
{
	private int dx, dy;

	public TransformacaoTranslacao(int dx, int dy)
	{
		this.dx = dx;
		this.dy = dy;
	}

	public ImagemBinaria realizarTransformacao(ImagemBinaria imagem)
	{
		// Declaracao de variaveis
		ImagemBinaria imagemNova;
		int nl, nc, tamanho, i, j, deslocI, deslocJ;

		nl = imagem.getNl();
		nc = imagem.getNc();
		tamanho = imagem.getTamanho();
		imagemNova = new ImagemBinaria(nl, nc, tamanho);

		for (i = 0; i < nl; i++)
		{
			for (j = 0; j < nc; j++)
			{
				deslocI = i + dy;
				deslocJ = j + dx;

				if (deslocI >= 0 && deslocI < nl && deslocJ >= 0 && deslocJ < nc)
					imagemNova.setPosicao(deslocI, deslocJ, imagem.getPosicao(i, j));
			}
		}

		return imagemNova;
	}

}
