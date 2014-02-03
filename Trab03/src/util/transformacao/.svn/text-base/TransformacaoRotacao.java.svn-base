package util.transformacao;

import util.componentes.ImagemBinaria;

public class TransformacaoRotacao implements Transformacao
{
	private double angulo;

	public TransformacaoRotacao(double angulo)
	{
		this.angulo = Math.toRadians(angulo);
	}

	public ImagemBinaria realizarTransformacao(ImagemBinaria imagem)
	{
		// Declaracao de variaveis
		ImagemBinaria imagemNova;
		int nl, nc, nl2, nc2, tamanho, i, j, x1, y1, x2, y2, xCentro, yCentro;
		double seno, cosseno;

		nl = imagem.getNl();
		nc = imagem.getNc();
		tamanho = imagem.getTamanho();
		nl2 = nl;
		nc2 = nc;

		if (nl % 2 == 0)
			nl2++;
		if (nc % 2 == 0)
			nc2++;

		imagemNova = new ImagemBinaria(nl2, nc2, tamanho);

		seno = Math.sin(angulo);
		cosseno = Math.cos(angulo);

		xCentro = (int) (nc / 2);
		yCentro = (int) (nl / 2);

		for (i = 0; i < nl; i++)
		{
			for (j = 0; j < nc; j++)
			{
				x1 = j - xCentro;
				y1 = i - yCentro;

				y2 = (int) Math.round(y1 * cosseno - x1 * seno) + yCentro;
				x2 = (int) Math.round(x1 * cosseno + y1 * seno) + xCentro;

				if (x2 >= 0 && x2 < nc2 && y2 >= 0 && y2 < nl2)
					imagemNova.setPosicao(y2, x2, imagem.getPosicao(i, j));
			}
		}

		return imagemNova;
	}

}
