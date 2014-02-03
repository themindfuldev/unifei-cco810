package pacote_12643.util.componentes.tc;

import pacote_12643.util.Descritor;
import pacote_12643.util.componentes.PanelImagem;
import pacote_12643.util.componentes.Ponto;
import pacote_12643.util.componentes.binaria.PanelImagemBinaria;


@SuppressWarnings("serial")
public class PanelImagemTC extends PanelImagem
{
	public PanelImagemTC(int nl, int nc, long tamanho)
	{
		super(nl, nc, new ImagemTCFactory(), tamanho);
	}

	public void setPosicao(int posLinha, int posColuna, short valor)
	{
		((PontoTC)getMatrizPontos()[posLinha][posColuna]).setValor(valor);
	}

	public short getPosicao(int posLinha, int posColuna)
	{
		return ((PontoTC)getMatrizPontos()[posLinha][posColuna]).getValor();
	}
	
	@Override
	public void copiarPonto(int i, int j, Ponto ponto)
	{
		if (ponto instanceof PontoTC == false) return;
		
		((PontoTC)getMatrizPontos()[i][j]).setValor(((PontoTC)ponto).getValor());
	}

	public PanelImagem binarizarImagem(short limiar) {
		PanelImagemBinaria imagemNova;
		
		imagemNova = new PanelImagemBinaria(getNl(), getNc());
		
		for (PontoTC[] linhaPonto: (PontoTC[][])getMatrizPontos()) {
			for (PontoTC ponto: linhaPonto) {
				imagemNova.setPosicao(ponto.getX(), ponto.getY(), binarizar(ponto.getValor(), limiar));
			}
		}
		
		return imagemNova;
	}
	
	private boolean binarizar(short readShort, short limiar)
	{
		if (readShort < limiar)
			return true;
		return false;
	}
	
	public PanelImagem equalizarImagem(int faixas) {
		PanelImagem imagemNova;
		Descritor descritor;
		
		descritor = new Descritor(this);
		imagemNova = descritor.equalizar(faixas);
		
		return imagemNova;
	}
	
	public short[][] getMatrizValores() {
		short[][] matriz = new short[getNl()][getNc()];
		int i, j;
		
		for (i=0; i<getNl(); i++) {
			for (j=0; j<getNc(); j++) {
				matriz[i][j] = ((PontoTC)getMatrizPontos()[i][j]).getValor();
			}
		}
		
		return matriz;
	}

}
