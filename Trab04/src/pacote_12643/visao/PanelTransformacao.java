package pacote_12643.visao;

import javax.swing.JPanel;

import pacote_12643.util.transformacao.TransformacaoStrategy;

/**
 * Panel com uma transforma��o realizada
 * 
 * @author Tiago
 */
public abstract class PanelTransformacao extends JPanel
{
	/**
	 * Obt�m a estrat�gia de transforma��o.
	 * 
	 * @return
	 */
	public abstract TransformacaoStrategy getTransformacao();
}