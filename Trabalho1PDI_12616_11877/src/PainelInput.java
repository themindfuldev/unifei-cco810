import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class PainelInput extends JPanel{

	//--------------------------------------------------------------------------------------
	//									ATRIBUTOS
	//--------------------------------------------------------------------------------------

	private JTextField txtLimiar;
	private JSlider slider;

	//--------------------------------------------------------------------------------------
	//									CONSTRUTOR
	//--------------------------------------------------------------------------------------
	public PainelInput() {
		super();
		this.slider = new JSlider(JSlider.HORIZONTAL,0,255,127);
		this.slider.setBackground(new Color(20,180,180));
		this.setLayout(new FlowLayout());
		this.setBackground(new Color(20,180,180));
		
		this.txtLimiar = new JTextField();
		this.txtLimiar.setColumns(10);

		this.add(new JLabel("Limiar:"));
		this.add(slider);
		JLabel instrucao = new JLabel("Utilize o menu 'Arquivo' para operar a imagem.");
		instrucao.setForeground(Color.white);
		this.add(instrucao);

	}

	public JTextField getTxtLimiar() {
		return txtLimiar;
	}

	public void setTxtLimiar(JTextField txtLimiar) {
		this.txtLimiar = txtLimiar;
	}

	public int getValorDeLimiar() {
		return Integer.parseInt(this.txtLimiar.getText());
	}

	public JSlider getSlider() {
		return slider;
	}
	
	
	//--------------------------------------------------------------------------------------
	//									METODOS
	//--------------------------------------------------------------------------------------
}
