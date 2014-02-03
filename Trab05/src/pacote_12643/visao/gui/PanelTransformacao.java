package pacote_12643.visao.gui;

import javax.swing.JPanel;

import pacote_12643.util.transformacao.TransformacaoStrategy;


public abstract class PanelTransformacao extends JPanel
{
	public abstract TransformacaoStrategy getTransformacao();
}