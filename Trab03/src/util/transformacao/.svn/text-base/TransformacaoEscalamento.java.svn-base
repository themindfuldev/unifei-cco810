package util.transformacao;

import util.componentes.ImagemBinaria;

public class TransformacaoEscalamento implements Transformacao
{
	private static final int TIPO_AMPLIACAO = 0;
	private static final int TIPO_REDUCAO = 1;

	private int tipo, fator;

	public TransformacaoEscalamento(int tipo, int fator)
	{
		this.tipo = tipo;
		this.fator = fator;
	}

	public ImagemBinaria realizarTransformacao(ImagemBinaria imagem)
	{
		// Declaracao de variaveis
		ImagemBinaria imagemNova;
		int nl, nc, tamanho, i, j, escalaI, escalaJ, novoI, novoJ;
		float fatorCalculo;

		nl = imagem.getNl();
		nc = imagem.getNc();
		tamanho = imagem.getTamanho();
		imagemNova = new ImagemBinaria(nl, nc, tamanho);

		if (tipo == TIPO_AMPLIACAO)
			fatorCalculo = fator;
		else if (tipo == TIPO_REDUCAO)
			fatorCalculo = (float) 1.0 / fator;
		else
			fatorCalculo = 1;

		for (i = 0; i < nl; i++)
		{
			for (j = 0; j < nc; j++)
			{
				escalaI = (int) (i * fatorCalculo);
				escalaJ = (int) (j * fatorCalculo);

				for (novoI = escalaI; novoI < (i + 1) * fatorCalculo; novoI++)
				{
					for (novoJ = escalaJ; novoJ < (j + 1) * fatorCalculo; novoJ++)
						if (novoI >= 0 && novoI < nl && novoJ >= 0 && novoJ < nc)
							imagemNova.setPosicao(novoI, novoJ, imagem
									.getPosicao(i, j));
				}
			}
		}

		return imagemNova;
	}
}
