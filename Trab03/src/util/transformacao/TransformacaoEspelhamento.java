package util.transformacao;

import util.componentes.ImagemBinaria;

public class TransformacaoEspelhamento implements Transformacao
{
	private boolean horizontal;

	public TransformacaoEspelhamento(boolean horizontal)
	{
		this.horizontal = horizontal;
	}

	public ImagemBinaria realizarTransformacao(ImagemBinaria imagem)
	{
		// Declaracao de variaveis
		ImagemBinaria imagemNova;
		int nl, nc, tamanho, i, j;

		nl = imagem.getNl();
		nc = imagem.getNc();
		tamanho = imagem.getTamanho();
		imagemNova = new ImagemBinaria(nl, nc, tamanho);

		for (i = 0; i < nl; i++)
		{
			for (j = 0; j < nc; j++)
			{
				if (horizontal)
					imagemNova.setPosicao(i, nc - j - 1, imagem.getPosicao(i, j));
				else
					imagemNova.setPosicao(nl - i - 1, j, imagem.getPosicao(i, j));
			}
		}

		return imagemNova;
	}

}
