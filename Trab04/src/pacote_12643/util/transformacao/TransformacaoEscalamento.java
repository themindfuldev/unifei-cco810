package pacote_12643.util.transformacao;

import pacote_12643.util.componentes.PanelImagem;

/**
 * Realiza uma transformação escalamento.
 * @author Tiago
 */
public class TransformacaoEscalamento implements TransformacaoStrategy
{
	// Constantes
	private static final int TIPO_AMPLIACAO = 0;
	private static final int TIPO_REDUCAO = 1;

	/**
	 * Tipo da transformação.
	 */
	private int tipo;
	/**
	 * Fator de escalamento.
	 */
	private int fator;

	// Construtor
	public TransformacaoEscalamento(int tipo, int fator)
	{
		this.tipo = tipo;
		this.fator = fator;
	}

	/* (non-Javadoc)
	 * @see pacote_12643.util.transformacao.TransformacaoStrategy#realizarTransformacao(pacote_12643.util.componentes.PanelImagem)
	 */
	public PanelImagem realizarTransformacao(PanelImagem imagem)
	{
		// Declaracao de variaveis
		PanelImagem imagemNova;
		int nl, nc, i, j, escalaI, escalaJ, novoI, novoJ, novoNl, novoNc;
		float fatorCalculo;

		nl = imagem.getNl();
		nc = imagem.getNc();

		if (tipo == TIPO_AMPLIACAO)
			fatorCalculo = fator;
		else if (tipo == TIPO_REDUCAO)
			fatorCalculo = (float) 1.0 / fator;
		else
			fatorCalculo = 1;
		
		novoNl = (int) Math.round(nl * fatorCalculo);
		novoNc = (int) Math.round(nc * fatorCalculo);
		imagemNova = imagem.getFactory().createPanelImagem(novoNl, novoNc, imagem.getTamanho()*fator);

		// Iteração para transformação
		for (i = 0; i < nl; i++)
		{
			for (j = 0; j < nc; j++)
			{
				escalaI = (int) (i * fatorCalculo);
				escalaJ = (int) (j * fatorCalculo);

				for (novoI = escalaI; novoI < (i + 1) * fatorCalculo; novoI++)
				{
					for (novoJ = escalaJ; novoJ < (j + 1) * fatorCalculo; novoJ++)
						if (novoI >= 0 && novoI < novoNl && novoJ >= 0 && novoJ < novoNc)
							imagemNova.copiarPonto(novoI, novoJ, imagem.getPonto(i, j));
				}
			}
		}
			
		return imagemNova;
	}
}
