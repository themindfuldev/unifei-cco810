package pacote_12643.util.transformacao;

import pacote_12643.util.componentes.PanelImagem;

/**
 * Estrat�gia para generalizar as transforma��es.
 * @author Tiago
 */
public interface TransformacaoStrategy
{
	public abstract PanelImagem realizarTransformacao(PanelImagem imagem);
}
