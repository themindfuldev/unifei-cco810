package pacote_12643.util.componentes.binaria;

import java.util.HashSet;
import java.util.Set;

import pacote_12643.util.componentes.PanelImagem;
import pacote_12643.util.componentes.Ponto;


@SuppressWarnings("serial")
public class PanelImagemBinaria extends PanelImagem
{
	public PanelImagemBinaria(int nl, int nc)
	{
		super(nl, nc, new ImagemBinariaFactory(), 0);
	}

	public void setPosicao(int posLinha, int posColuna, boolean estado)
	{
		((PontoBinario)getMatrizPontos()[posLinha][posColuna]).setEstado(estado);
	}

	public boolean getPosicao(int posLinha, int posColuna)
	{
		return ((PontoBinario)getMatrizPontos()[posLinha][posColuna]).getEstado();
	}

	@Override
	public void copiarPonto(int i, int j, Ponto ponto)
	{
		if (ponto instanceof PontoBinario == false) return;
		
		((PontoBinario)getMatrizPontos()[i][j]).setEstado(((PontoBinario)ponto).getEstado());
	}
	
	public Set<PontoBinario> obterConjuntoPreenchidos() {
		Set<PontoBinario> conjunto = new HashSet<PontoBinario>();
		int i, j;
		PontoBinario p;
		
		for (i = 0; i < getNl(); i++) {
			for (j = 0; j < getNc(); j++) {
				p = (PontoBinario) getMatrizPontos()[i][j];
				if (p.getEstado() == true)
					conjunto.add(p);
			}
		}
		
		return conjunto;
	}

}
