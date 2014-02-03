package visao.mediator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import util.CorridaLinha;
import util.componentes.ImagemBinaria;
import util.transformacao.Transformacao;
import visao.gui.DialogoTransformacao;
import visao.gui.JanelaInternaImagem;
import visao.gui.JanelaPrincipal;
import visao.gui.TipoTransformacao;

public class MediatorPrincipal
{
	private JanelaPrincipal janela;
	private int tamanho;

	public MediatorPrincipal(JanelaPrincipal janela)
	{
		this.janela = janela;
		tamanho = 10;
	}

	public void registraEventos()
	{
		janela.getMniSair().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
		janela.getMniNovo().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				menuNovo();
			}
		});
		janela.getMniAbrir().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				menuAbrir();
			}
		});
		janela.getMniSalvar().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				menuSalvar();
			}
		});
		janela.getMniSobre().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane
						.showMessageDialog(
								janela,
								"Trabalho 03 de CCO810\nNome: Tiago Romero Garcia\nMatricula: 12643",
								"Creditos", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		janela.getMniRotular8().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				menuRotular8();
			}
		});
		janela.getMniTranslacao().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				menuTransformacao(TipoTransformacao.TRANSLACAO);
			}
		});
		janela.getMniEscalamento().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				menuTransformacao(TipoTransformacao.ESCALAMENTO);
			}
		});
		janela.getMniRotacao().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				menuTransformacao(TipoTransformacao.ROTACAO);
			}
		});
		janela.getMniEspelhamento().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				menuTransformacao(TipoTransformacao.ESPELHAMENTO);
			}
		});
	}

	private void menuTransformacao(TipoTransformacao tipo)
	{
		// Declaracao de variaveis
		ImagemBinaria imagem, imagemNova;
		Transformacao transformacao;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane()
				.getSelectedFrame()).getImagemBinaria();

		transformacao = new DialogoTransformacao(janela, tipo).getTransformacao();

		if (transformacao == null)
			return;

		imagemNova = imagem.realizarTransformacao(transformacao);
		criarJanelaInternaImagem(imagemNova);
	}

	private void menuRotular8()
	{
		// Declaracao de variaveis
		List<CorridaLinha> listaCorridasReconhecidas;
		ImagemBinaria imagem;
		int nl, nc;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane()
				.getSelectedFrame()).getImagemBinaria();
		nl = imagem.getNl();
		nc = imagem.getNc();

		// Passo 1: obtencao das corridas
		listaCorridasReconhecidas = obterCorridas(imagem, nl, nc);

		// Passo 2: criacao das classes de equivalencia
		reconhecerEquivalencias(nl, listaCorridasReconhecidas);

		// Passo 3: Pintar corridas equivalentes
		pintarCorridas(imagem, listaCorridasReconhecidas);

	}

	private void pintarCorridas(ImagemBinaria imagem,
			List<CorridaLinha> listaCorridasReconhecidas)
	{
		// Declaracao de variaveis
		int i;
		int equivalencia;
		Map<Integer, Color> tabelaCores;
		Color cor;
		tabelaCores = new HashMap<Integer, Color>();

		// Varre as corridas equivalentes e pinta.
		for (CorridaLinha corridaLinha : listaCorridasReconhecidas)
		{
			equivalencia = corridaLinha.getEquivalencia();
			cor = getCor(equivalencia, tabelaCores);

			for (i = corridaLinha.getColunaInicio(); i <= corridaLinha
					.getColunaFinal(); i++)
			{
				imagem.pintarPosicao(corridaLinha.getLinha(), i, cor);
			}
		}
	}

	private Color getCor(int equivalencia, Map<Integer, Color> tabelaCores)
	{
		// Declaracao de variaveis
		Color cor;

		// Obtem cor ou constroi nova cor
		cor = tabelaCores.get(equivalencia);
		if (cor == null)
		{
			cor = new Color((int) (Math.random() * 16777216));
			tabelaCores.put(equivalencia, cor);
		}
		return cor;
	}

	private void reconhecerEquivalencias(int nl,
			List<CorridaLinha> listaCorridasReconhecidas)
	{
		// Declaracao de variaveis
		List<CorridaLinha> listaCorridasVizinhas;
		Queue<CorridaLinha> filaPercurso;
		CorridaLinha corrida;
		int contadorEquivalencia;

		filaPercurso = new LinkedList<CorridaLinha>();
		filaPercurso.addAll(listaCorridasReconhecidas);
		contadorEquivalencia = 1;

		// Percorre fila de corridas reconhecidas
		while (filaPercurso.size() > 0)
		{
			corrida = filaPercurso.poll();

			// Seta equivalencia
			corrida.setEquivalencia(contadorEquivalencia);
			listaCorridasVizinhas = getCorridasVizinhas(listaCorridasReconhecidas,
					corrida);

			// Seta equivalencia aos vizinhos
			for (CorridaLinha corridaVizinha : listaCorridasVizinhas)
			{
				corridaVizinha.setEquivalencia(contadorEquivalencia);
				reconhecerVizinhos(corridaVizinha, listaCorridasReconhecidas,
						filaPercurso, contadorEquivalencia);
				filaPercurso.remove(corridaVizinha);
			}

			contadorEquivalencia++;
		}
	}

	private void reconhecerVizinhos(CorridaLinha corridaLinha,
			List<CorridaLinha> listaCorridasReconhecidas,
			Queue<CorridaLinha> listaPercurso, int equivalencia)
	{
		// Declaracao de variaveis
		List<CorridaLinha> listaCorridasVizinhas;

		// Obtem vizinhos
		listaCorridasVizinhas = getCorridasVizinhas(listaCorridasReconhecidas,
				corridaLinha);

		// Seta equivalencia aos vizinhos
		for (CorridaLinha corridaVizinha : listaCorridasVizinhas)
		{
			if (corridaVizinha.getEquivalencia() == equivalencia)
				continue;

			corridaVizinha.setEquivalencia(equivalencia);
			reconhecerVizinhos(corridaVizinha, listaCorridasReconhecidas,
					listaPercurso, equivalencia);
			listaPercurso.remove(corridaVizinha);
		}
	}

	private List<CorridaLinha> getCorridasVizinhas(
			List<CorridaLinha> listaCorridasReconhecidas, CorridaLinha corridaLinha)
	{
		// Declaracao de variaveis
		List<CorridaLinha> listaCorridas;

		listaCorridas = new ArrayList<CorridaLinha>();

		// Busca vizinhancas
		for (CorridaLinha corridaVizinha : listaCorridasReconhecidas)
		{
			if (corridaVizinha == corridaLinha)
				continue;

			if (corridaVizinha.getLinha() == corridaLinha.getLinha() - 1
					|| corridaVizinha.getLinha() == corridaLinha.getLinha() + 1)
			{
				// Verifica adjacencia-8 aos vizinhos
				if (corridaLinha.getColunaInicio() <= corridaVizinha
						.getColunaFinal() + 1
						&& corridaLinha.getColunaFinal() >= corridaVizinha
								.getColunaInicio() - 1)
				{
					listaCorridas.add(corridaVizinha);
				}
			}
		}

		return listaCorridas;
	}

	private List<CorridaLinha> obterCorridas(ImagemBinaria imagem, int nl, int nc)
	{
		// Declaracao de variaveis
		int i;
		int j;
		List<CorridaLinha> listaCorridasReconhecidas;
		CorridaLinha corridaReconhecida;
		int colunaInicial, colunaFinal;

		listaCorridasReconhecidas = new ArrayList<CorridaLinha>();
		colunaInicial = 0;

		// Varre todas as posicoes
		for (i = 0; i < nl; i++)
		{
			for (j = 0; j < nc; j++)
			{
				// Caso 1: Inicio da corrida
				if (j == 0 || imagem.getPosicao(i, j - 1) == false)
				{
					colunaInicial = j;
					continue;
				}

				// Caso 2: Fim da corrida no meio da linha
				if (imagem.getPosicao(i, j) == false)
				{
					if (j > 0 && imagem.getPosicao(i, j - 1) == true)
					{
						colunaFinal = j - 1;
						corridaReconhecida = new CorridaLinha(i, colunaInicial,
								colunaFinal);
						listaCorridasReconhecidas.add(corridaReconhecida);
					}
				}
			}

			// Caso 3: Fim da corrida no fim da linha
			if (imagem.getPosicao(i, nc - 1) == true)
			{
				colunaFinal = nc - 1;
				corridaReconhecida = new CorridaLinha(i, colunaInicial, colunaFinal);
				listaCorridasReconhecidas.add(corridaReconhecida);
			}

		}
		return listaCorridasReconhecidas;
	}

	private ImagemBinaria realizaLeitura(File arquivo) throws IOException
	{
		// Declaracao de variaveis
		ImagemBinaria imagem;
		DataInputStream dis;
		int nl, nc, i, j;
		boolean posicao;

		// Leitura
		dis = new DataInputStream(new FileInputStream(arquivo));
		nl = dis.readInt();
		nc = dis.readInt();

		imagem = new ImagemBinaria(nl, nc, tamanho);

		for (i = 0; i < nl; i++)
			for (j = 0; j < nc; j++)
			{
				posicao = dis.readBoolean();
				imagem.setPosicao(i, j, posicao);
			}

		dis.close();

		return imagem;
	}

	private void realizaGravacao(ImagemBinaria imagem, File arquivo)
			throws IOException
	{
		// Declaracao de variaveis
		DataOutputStream dos;
		int nl, nc, i, j;

		// Inicializacao
		nl = imagem.getNl();
		nc = imagem.getNc();

		// Gravacao
		dos = new DataOutputStream(new FileOutputStream(arquivo));
		dos.writeInt(nl);
		dos.writeInt(nc);

		for (i = 0; i < nl; i++)
			for (j = 0; j < nc; j++)
				dos.writeBoolean(imagem.getPosicao(i, j));

		dos.close();
	}

	private void exibeErro(String mensagem)
	{
		JOptionPane.showMessageDialog(janela, mensagem, "Erro!",
				JOptionPane.ERROR_MESSAGE);
	}

	private void menuNovo()
	{
		// Declaracao de variaveis
		int nl, nc;
		String nlStr, ncStr;

		// Obtencao
		nlStr = JOptionPane.showInputDialog(null,
				"Entre com o numero de linhas:", "Nova imagem binaria",
				JOptionPane.QUESTION_MESSAGE);
		if (nlStr != null)
			nl = Integer.parseInt(nlStr);
		else
		{
			exibeErro("Valor incorreto");
			return;
		}

		ncStr = JOptionPane.showInputDialog(null,
				"Entre com o numero de colunas:", "Nova imagem binaria",
				JOptionPane.QUESTION_MESSAGE);
		if (ncStr != null)
			nc = Integer.parseInt(ncStr);
		else
		{
			exibeErro("Valor incorreto");
			return;
		}

		criarJanelaInternaImagem(new ImagemBinaria(nl, nc, tamanho));
	}

	private void menuAbrir()
	{
		// Declaracao de variaveis
		File arquivo;
		JFileChooser chooser;
		ImagemBinaria imagem;
		int returnVal;

		// Escolha do arquivo
		chooser = new JFileChooser("Abrir arquivo");
		returnVal = chooser.showOpenDialog(janela);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				arquivo = chooser.getSelectedFile();

				imagem = realizaLeitura(arquivo);

				criarJanelaInternaImagem(imagem);
				janela.getDesktopPane().getSelectedFrame().setTitle(
						"[" + arquivo.getName() + "]");
			} catch (IOException e)
			{
				exibeErro("Erro no arquivo");
			}
		}
	}

	private void menuSalvar()
	{
		// Declaracao de variaveis
		File arquivo;
		JFileChooser chooser;
		JanelaInternaImagem janelaImagem;
		ImagemBinaria imagem;
		int returnVal;

		janelaImagem = (JanelaInternaImagem) janela.getDesktopPane()
				.getSelectedFrame();

		if (janelaImagem == null)
			return;

		// Escolha do arquivo
		chooser = new JFileChooser("Salvar arquivo");
		returnVal = chooser.showSaveDialog(janela);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				arquivo = chooser.getSelectedFile();

				imagem = janelaImagem.getImagemBinaria();
				realizaGravacao(imagem, arquivo);
				janelaImagem.setTitle("[" + arquivo.getName() + "]");
			} catch (IOException e)
			{
				exibeErro("Erro no arquivo");
			}
		}
	}

	private void criarJanelaInternaImagem(ImagemBinaria imagem)
	{
		JanelaInternaImagem janelaInternaImagem;

		janelaInternaImagem = new JanelaInternaImagem(imagem);
		janelaInternaImagem.setVisible(true);

		janela.getDesktopPane().add(janelaInternaImagem);
		try
		{
			janelaInternaImagem.setSelected(true);
		} catch (java.beans.PropertyVetoException e)
		{
		}
	}
}
