import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Histograma extends JPanel{

	//--------------------------------------------------------------------------------------
	//									ATRIBUTOS
	//--------------------------------------------------------------------------------------
	private int nroDeFaixas;
	private Float[] faixa;
	private boolean plotarGraficoDoHistograma = false;


	//--------------------------------------------------------------------------------------
	//									CONSTRUTOR
	//--------------------------------------------------------------------------------------
	public Histograma(int nroDeFaixas, Float[] faixa) {
		this.nroDeFaixas = nroDeFaixas;
		this.faixa = faixa;
		this.plotarGraficoDoHistograma = true;

		this.setLayout(new GridLayout(3,1));
		this.setBackground(new Color(20,180,180));

		this.add(new JLabel(""));
		this.add(new JLabel(""));
		this.add(new JLabel("                         0----------------------------------255"));
	}

	//--------------------------------------------------------------------------------------
	//									METODOS
	//--------------------------------------------------------------------------------------

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if(plotarGraficoDoHistograma){
			for(int i=0; i<this.nroDeFaixas;i++){
				g.drawRect(110+(i*10), 90-Math.round(80*this.faixa[i]), 5, Math.round(80*this.faixa[i]));
			}
		}
	}

	public int getNroDeFaixas() {
		return nroDeFaixas;
	}

	public void setNroDeFaixas(int nroDeFaixas) {
		this.nroDeFaixas = nroDeFaixas;
	}

	public Float[] getFaixa() {
		return faixa;
	}

	public void setFaixa(Float[] faixa) {
		this.faixa = faixa;
	}
}
