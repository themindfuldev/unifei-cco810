package pacote_12643.visao;

import javax.swing.JPanel;

import pacote_12643.util.transformacao.TransformacaoStrategy;

/**
 * Panel com uma transformação realizada
 * 
 * @author Tiago
 */
public abstract class PanelTransformacao extends JPanel
{
	/**
	 * Obtém a estratégia de transformação.
	 * 
	 * @return
	 */
	public abstract TransformacaoStrategy getTransformacao();
}