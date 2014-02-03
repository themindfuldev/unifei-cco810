package util.transformacao;

import util.componentes.ImagemBinaria;

public interface Transformacao
{
	public abstract ImagemBinaria realizarTransformacao(ImagemBinaria imagem);
}
