package pacote_12643.util;


public class Histograma
{
	private int[] histograma;
	private int faixas;

	public Histograma(int faixas)
	{
		this.faixas = faixas;
		this.histograma = new int[256];
	}

	public int getFaixas()
	{
		return faixas;
	}

	public void setFaixas(int faixas)
	{
		this.faixas = faixas;
	}

	public void acrescentar(int linha) {
		histograma[linha]++;
	}
	
	public double[] getPorcentagens() {
		// Declaração	
		int i;
		double[] porcentagens;
		double amplitude;
		int total;
		
		porcentagens = new double[faixas];
		amplitude = 255.0/faixas;
		total = 0;
		
		// Calcula as probabilidades
		for (i=0; i<255; i++) {
			porcentagens[(int)(i/amplitude)] += histograma[i];
			total += histograma[i];
		}
		
		for (i=0; i<faixas; i++) {
			porcentagens[i] /= total;
		}
		
		return porcentagens;		
	}

	public double[] getPorcentagensAcumuladas()
	{
		double[] porcentagensAcumuladas = new double[faixas];
		double amplitude, max;
		int i, faixa;
		
		amplitude = 255.0/faixas;
		
		for (faixa=0, i=0; i<255; i++) {
			if ((int) (i/amplitude) > faixa) {
				porcentagensAcumuladas[faixa+1] = porcentagensAcumuladas[faixa]; 
				faixa++;
			}
			porcentagensAcumuladas[faixa] += histograma[i];
		}
		max = porcentagensAcumuladas[faixa];
		
		for (i=0; i<faixas; i++) {
			porcentagensAcumuladas[i] /= max;
		}
		
		return porcentagensAcumuladas;
	}

	public int[] getHistograma()
	{
		return histograma;
	}
	
}
