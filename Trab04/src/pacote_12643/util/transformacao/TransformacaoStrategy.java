package pacote_12643.util.transformacao;

import pacote_12643.util.componentes.PanelImagem;

/**
 * Estratégia para generalizar as transformações.
 * @author Tiago
 */
public interface TransformacaoStrategy
{
	public abstract PanelImagem realizarTransformacao(PanelImagem imagem);
}
