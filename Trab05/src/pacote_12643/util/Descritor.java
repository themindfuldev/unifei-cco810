package pacote_12643.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pacote_12643.util.componentes.PanelImagem;
import pacote_12643.util.componentes.tc.PanelImagemTC;
import pacote_12643.util.componentes.tc.PontoTC;


public class Descritor
{
	private Map<Short, List<PontoTC>> tabelaPontos;
	private int nl, nc;

	public Descritor(PanelImagem panelImagem)
	{
		this.nl = panelImagem.getNl();
		this.nc = panelImagem.getNc();
		tabelaPontos = new HashMap<Short, List<PontoTC>>();
		
		popularDescritor(panelImagem);
	}

	private void popularDescritor(PanelImagem panelImagem)
	{
	   // Declaração
		List<PontoTC> lista;
		short nivelCinza;
		
		// Povoa o descritor a partir da matriz de pontos
		for (PontoTC[] linhaPontos: (PontoTC[][])panelImagem.getMatrizPontos()) {
			for (PontoTC ponto: linhaPontos) {
				nivelCinza = ponto.getValor();
				
				if (tabelaPontos.containsKey(nivelCinza) == false) {
					tabelaPontos.put(nivelCinza, new ArrayList<PontoTC>());
				}
				
				lista = tabelaPontos.get(nivelCinza);
				lista.add(ponto);
			}
		}
	}

	public Map<Short, List<PontoTC>> getTabelaPontos()
	{
		return tabelaPontos;
	}

	public int getNl()
	{
		return nl;
	}

	public int getNc()
	{
		return nc;
	}

	public Histograma controiHistograma(int faixas)
	{
		// Declaração
		Histograma histograma;
		int nivelCinza, i;
		
		histograma = new Histograma(faixas);
		
		// Varre tabela de pontos para criar histograma
		for (Map.Entry<Short, List<PontoTC>> entrada: tabelaPontos.entrySet()) {
			nivelCinza = entrada.getKey();
			for (i=0; i<entrada.getValue().size(); i++)
				histograma.acrescentar(nivelCinza);
		}
		
		return histograma;
	}
	
	public PanelImagemTC equalizar(int faixas)
	{
    	// Declaração
		Histograma histograma;
		PanelImagemTC novaImagem;
		short nivelCinza, faixa;
		double[] porcentagensAcumuladas;
		double amplitude;
		
		// Constrói histograma
		histograma = controiHistograma(faixas);
		novaImagem = new PanelImagemTC(nl, nc, 0);
		
		amplitude = 255.0/faixas;
		porcentagensAcumuladas = histograma.getPorcentagensAcumuladas();
		
		// Varre tabela de TC
		for (Map.Entry<Short, List<PontoTC>> entrada: tabelaPontos.entrySet()) {
			faixa = (short)(entrada.getKey()/amplitude);
			if (faixa >= faixas) faixa = (short) (faixas-1);
			nivelCinza = (short) Math.round(faixaProxima(porcentagensAcumuladas[faixa], faixas)*amplitude);
			
			for (PontoTC ponto: entrada.getValue()) {
				novaImagem.setPosicao(ponto.getX(), ponto.getY(), mapearTC(nivelCinza, amplitude, ponto));
			}
		}
		
		return novaImagem;
	}

	private short mapearTC(short nivelCinza, double amplitude, PontoTC ponto)
	{
		// Mapeia de uma faixa a outra
		short resultado = (short) (nivelCinza+ponto.getValor()%amplitude);
		if (resultado >= 255) resultado = 255;
		return resultado;
	}
	
	private short faixaProxima(double porcentagem, int faixas) {
		return (short) Math.round(porcentagem*faixas);
	}

}
