package util.componentes;

import java.awt.Color;

import util.transformacao.Transformacao;

class MediatorImagemBinaria
{
	private boolean[][] matrizImagem;
	private ImagemBinaria imagem;

	public MediatorImagemBinaria(ImagemBinaria imagem, int nl, int nc)
	{
		matrizImagem = new boolean[nl][nc];
		this.imagem = imagem;
	}

	void setPosicao(int posLinha, int posColuna, boolean estado)
	{
		matrizImagem[posLinha][posColuna] = estado;
	}

	boolean getPosicao(int posLinha, int posColuna)
	{
		return matrizImagem[posLinha][posColuna];
	}

	void pintarPosicao(int posLinha, int posColuna, Color cor)
	{
		imagem.getMatrizCelulas()[posLinha][posColuna].pintarCorrida(cor);
	}

	public ImagemBinaria realizarTransformacao(Transformacao transformacao) {
		return transformacao.realizarTransformacao(imagem);
	}

}
