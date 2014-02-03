package pacote_12643.visao.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import pacote_12643.util.Descritor;
import pacote_12643.util.Histograma;


@SuppressWarnings("serial")
public class PanelHistograma extends JPanel
{
	public int[] colunas;
	public short marcador;
	
	public PanelHistograma(Descritor descritor)
	{
		colunas = new int[255];
		marcador = 127;
		
		Histograma histograma = descritor.controiHistograma(255);
		double colunasDouble[] = histograma.getPorcentagens();
		double colunaMax = 0;
		int tamanhoColuna;
		
		for (int i=0; i<255; i++)
			if (colunasDouble[i] > colunaMax) colunaMax = colunasDouble[i];
		
		tamanhoColuna = (int) Math.round(200/colunaMax);
		
		for (int i=0; i<255; i++)
			colunas[i] = (int) Math.round(colunasDouble[i]*tamanhoColuna);
		
		setBackground(Color.WHITE);
		setSize(255, 270);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		
		// Marcador
		g.setColor(Color.RED);
		g.drawLine(20+marcador, 30, 20+marcador, 230);
			
		// Histograma
		g.setColor(Color.BLACK);			
		g.drawLine(20, 230, 275, 230);
		for (int i=0; i<255; i++) {
			g.drawLine(20+i, 230-colunas[i], 20+i, 230);
		}
		
		// Marcadores
		g.drawString("0", 20, 245);
		g.drawString("51", 68, 245);
		g.drawString("102", 117, 245);
		g.drawString("153", 168, 245);
		g.drawString("204", 219, 245);
		g.drawString("255", 270, 245);
	}

	public void setMarcador(short marcador)
	{
		this.marcador = marcador;
	}
	
}
