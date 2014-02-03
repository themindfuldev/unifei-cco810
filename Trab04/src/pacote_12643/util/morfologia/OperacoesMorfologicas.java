package pacote_12643.util.morfologia;

import java.util.HashSet;
import java.util.Set;

import pacote_12643.util.componentes.Ponto;
import pacote_12643.util.componentes.PontoBinario;

public class OperacoesMorfologicas {
	
	public static Set<PontoBinario> translacao(Set<PontoBinario> conjuntoEntrada, PontoBinario translado) {
		Set<PontoBinario> conjuntoSaida = new HashSet<PontoBinario>();
		
		for (PontoBinario pontoEntrada: conjuntoEntrada) {
			conjuntoSaida.add(soma(pontoEntrada, translado));
		}
		
		return conjuntoSaida;
	}
	
	public static Set<PontoBinario> reflexao(Set<PontoBinario> conjuntoEntrada, Ponto origem) {
		Set<PontoBinario> conjuntoSaida = new HashSet<PontoBinario>();
		PontoBinario pontoSaida;
		int x, y;
		
		for (PontoBinario pontoEntrada: conjuntoEntrada) {
			x = origem.getX()*2-pontoEntrada.getX();
			y = origem.getY()*2-pontoEntrada.getY();
			
			pontoSaida = new PontoBinario(x, y);
			pontoSaida.setEstado(pontoEntrada.getEstado());
			
			conjuntoSaida.add(pontoSaida);
		}
		
		return conjuntoSaida;
	}
	
	public static Set<PontoBinario> uniao(Set<PontoBinario> conjunto1, Set<PontoBinario> conjunto2) {
		Set<PontoBinario> conjuntoSaida = new HashSet<PontoBinario>();
		
		conjuntoSaida.addAll(conjunto1);
		conjuntoSaida.addAll(conjunto2);
		
		return conjuntoSaida;
	}
	
	public static Set<PontoBinario> intersecao(Set<PontoBinario> conjunto1, Set<PontoBinario> conjunto2) {
		Set<PontoBinario> conjuntoSaida = new HashSet<PontoBinario>();
		
		conjuntoSaida.addAll(conjunto1);
		conjuntoSaida.retainAll(conjunto2);
		
		return conjuntoSaida;
	}
	
	public static Set<PontoBinario> dilatacao(Set<PontoBinario> conjunto1, Set<PontoBinario> conjunto2) {
		Set<PontoBinario> conjuntoSaida = new HashSet<PontoBinario>();
		
		for (PontoBinario pontoEntrada1: conjunto1) {
			for (PontoBinario pontoEntrada2: conjunto2) {
				conjuntoSaida.add(soma(pontoEntrada1, pontoEntrada2));
			}
		}
		
		return conjuntoSaida;
	}

	private static PontoBinario soma(PontoBinario pontoEntrada1, PontoBinario pontoEntrada2) {
		PontoBinario p = new PontoBinario(pontoEntrada1.getX()+pontoEntrada2.getX(), pontoEntrada1.getY()+pontoEntrada2.getY());
		p.setEstado(pontoEntrada1.getEstado() && pontoEntrada2.getEstado());
		return p;
	}
	
	public static Set<PontoBinario> erosao(Set<PontoBinario> conjunto1, Set<PontoBinario> conjunto2) {
		Set<PontoBinario> conjuntoTranslacao;
		Set<PontoBinario> conjuntoSaida = new HashSet<PontoBinario>();
		
		for (PontoBinario pontoEntrada1: conjunto1) {
			conjuntoTranslacao = translacao(conjunto2, pontoEntrada1);
			if (conjunto1.containsAll(conjuntoTranslacao))
				conjuntoSaida.add(pontoEntrada1);
		}
		
		return conjuntoSaida;
	}
	
	public static Set<PontoBinario> abertura(Set<PontoBinario> conjunto1, Set<PontoBinario> conjunto2) {
		return dilatacao(erosao(conjunto1, conjunto2), conjunto2);
	}
	
	public static Set<PontoBinario> fechamento(Set<PontoBinario> conjunto1, Set<PontoBinario> conjunto2) {
		return erosao(dilatacao(conjunto1, conjunto2), conjunto2);
	}
	
	public static Set<PontoBinario> filtroMorfologico(Set<PontoBinario> conjunto1, Set<PontoBinario> conjunto2) {
		return fechamento(abertura(conjunto1, conjunto2), conjunto2);
	}

}