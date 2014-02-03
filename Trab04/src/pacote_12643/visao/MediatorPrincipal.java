package pacote_12643.visao;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.JOptionPane;

import pacote_12643.util.CorridaLinha;
import pacote_12643.util.Descritor;
import pacote_12643.util.Histograma;
import pacote_12643.util.Posicao;
import pacote_12643.util.bio.BitInputStream;
import pacote_12643.util.bio.BitOutputStream;
import pacote_12643.util.componentes.PanelImagem;
import pacote_12643.util.componentes.PanelImagemBinaria;
import pacote_12643.util.componentes.PanelImagemTC;
import pacote_12643.util.huffman.ElementoHuffman;
import pacote_12643.util.huffman.NoArvore;
import pacote_12643.util.huffman.NoLista;
import pacote_12643.util.transformacao.TransformacaoStrategy;

/**
 * Mediator da Janela Principal
 * 
 * @author Tiago
 */
public class MediatorPrincipal
{
	/**
	 * Janela Principal
	 */
	private JanelaPrincipal janela;

	// Construtor
	public MediatorPrincipal(JanelaPrincipal janela)
	{
		this.janela = janela;
	}

	// Métodos
	/**
	 * Registra eventos de interface.
	 */
	public void registraEventos()
	{
		janela.getMniSair().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
		janela.getMniAbrir().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuAbrir();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniSobre().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(janela, "Trabalho 02 de CCO810\nNome: Tiago Romero Garcia\nMatricula: 12643", "Creditos", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		janela.getMniObterConectados().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuObterConectados();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniEscalamento().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuTransformacao(TipoTransformacao.ESCALAMENTO);
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniEqualizacao().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuEqualizacao();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniBinarizacao().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuBinarizacao();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniGerarPimenta().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuGerarPimenta();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniGerarSal().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuGerarSal();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniFiltrarMediana().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuFiltrarMediana();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniFiltrarMedia().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuFiltrarMedia();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniImportarRLE().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuImportarRLE();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniImportarHuffman().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuImportarHuffman();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniExportarRLE().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuExportarRLE();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
		janela.getMniExportarHuffman().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					menuExportarHuffman();
				} catch (RuntimeException e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				} catch (Error e)
				{
					exibeErro("Não foi possível realizar esta operação.");
				}
				System.gc();
			}
		});
	}

	/**
	 * Ação de exportar imagem codificada em Huffman.
	 */
	@SuppressWarnings("deprecation")
	private void menuExportarHuffman()
	{
		// Declaracao de variaveis
		int i, j, k, cont;
		long tam1, tam2;
		PanelImagem imagem;
		File arquivoImagem, arquivoTabela, arquivoCabecalho;
		String nomeTabela, nomeImagem, nomeCabecalho, bits;
		FileDialog chooserTabela, chooserImagem, chooserCabecalho;
		BitOutputStream bio;
		DataOutputStream dos;
		BufferedWriter bw;
		ArrayList<NoLista> listaFrequencias = new ArrayList<NoLista>();
		NoLista noLista, noLista1, noLista2;
		NoArvore noArvore;
		ElementoHuffman elemento;
		short tom;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane().getSelectedFrame()).getPanelImagem();

		if (imagem instanceof PanelImagemTC == false)
		{
			exibeErro("Não é permitido exportar esta imagem.");
			return;
		}

		// Selecionar arquivos
		chooserCabecalho = new FileDialog(janela, "Abrir arquivo", FileDialog.LOAD);
		chooserCabecalho.setFile("*.cab");
		chooserCabecalho.show();
		nomeCabecalho = chooserCabecalho.getFile();
		if (nomeCabecalho == null)
			return;

		chooserTabela = new FileDialog(janela, "Salvar arquivo da tabela Huffman", FileDialog.SAVE);
		chooserTabela.setFile("*.tbh");
		chooserTabela.show();
		nomeTabela = chooserTabela.getFile();
		if (nomeTabela == null)
			return;

		chooserImagem = new FileDialog(janela, "Salvar arquivo da imagem Huffman", FileDialog.SAVE);
		chooserImagem.setFile("*.imh");
		chooserImagem.show();
		nomeImagem = chooserImagem.getFile();

		if (nomeImagem == null)
			return;

		// Obter frequências
		short[][] matrizValores = ((PanelImagemTC) imagem).getMatrizValores();
		Histograma histograma = new Histograma(255);

		for (i = 0; i < matrizValores.length; i++)
		{
			for (j = 0; j < matrizValores[i].length; j++)
			{
				histograma.acrescentar(matrizValores[i][j]);
			}
		}

		// Criar lista de frequências
		for (i = 0; i < histograma.getHistograma().length; i++)
		{
			if (histograma.getHistograma()[i] > 0)
			{
				elemento = new ElementoHuffman((short) i, histograma.getHistograma()[i]);
				noLista = new NoLista(elemento);
				listaFrequencias.add(noLista);
			}
		}

		// Criar árvore de Huffman
		Collections.sort(listaFrequencias);
		while (listaFrequencias.size() > 1)
		{
			noLista1 = listaFrequencias.remove(0);
			noLista2 = listaFrequencias.remove(0);

			noArvore = new NoArvore(new ElementoHuffman(noLista1, noLista2));
			noArvore.setFilhoEsquerdo(noLista1.getRaiz());
			noArvore.setFilhoDireito(noLista2.getRaiz());

			noLista = new NoLista(noArvore);

			cont = Collections.binarySearch(listaFrequencias, noLista);
			if (cont < 0)
				listaFrequencias.add(-cont - 1, noLista);
			else
				listaFrequencias.add(cont, noLista);
		}

		// Codificar cada tom de cinza
		Map<Short, String> tabelaCodificacao = listaFrequencias.get(0).getRaiz().obterCodificacoes();

		try
		{
			arquivoCabecalho = new File(chooserCabecalho.getDirectory(), nomeCabecalho);
			arquivoTabela = new File(chooserTabela.getDirectory(), nomeTabela);
			arquivoImagem = new File(chooserImagem.getDirectory(), nomeImagem);

			// Salvar cabecalho
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivoCabecalho)));
			bw.write(String.format("%d %d", imagem.getNc(), imagem.getNl()));
			bw.close();

			// Salvar tabela
			dos = new DataOutputStream(new FileOutputStream(arquivoTabela));
			dos.writeInt(tabelaCodificacao.size());

			for (Map.Entry<Short, String> entrada : tabelaCodificacao.entrySet())
			{
				dos.writeShort(entrada.getKey());
				dos.writeUTF(entrada.getValue());
			}

			dos.close();

			// Salvar imagem codificada
			bio = new BitOutputStream(new FileOutputStream(arquivoImagem));

			for (i = 0; i < matrizValores.length; i++)
			{
				for (j = 0; j < matrizValores[i].length; j++)
				{
					tom = matrizValores[i][j];
					bits = tabelaCodificacao.get(tom);
					for (k = 0; k < bits.length(); k++)
					{
						cont = Integer.parseInt(bits.substring(k, k + 1));
						bio.writeBit(cont);
					}
				}
			}

			bio.close();

			// Relatório de compressão
			tam1 = imagem.getTamanho();
			tam2 = arquivoImagem.length() + arquivoTabela.length();
			float compressão = (1 - (float) tam2 / tam1) * 100;

			JOptionPane.showMessageDialog(janela, String.format("Exportação finalizada.\nRedução de: %.3f%%", compressão), "Exportar imagem", JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e)
		{
			exibeErro("Erro no arquivo.");
			return;
		}
	}

	/**
	 * Ação de importar imagem codificada em Huffman.
	 */
	@SuppressWarnings("deprecation")
	private void menuImportarHuffman()
	{
		// Declaracao de variaveis
		File arquivoCabecalho, arquivoImagem, arquivoTabela;
		String nomeCabecalho, nomeImagem, nomeTabela;
		FileDialog chooserCabecalho, chooserImagem, chooserTabela;
		PanelImagem imagem;

		// Arquivo Cabeçalho
		chooserCabecalho = new FileDialog(janela, "Abrir arquivo", FileDialog.LOAD);
		chooserCabecalho.setFile("*.cab");
		chooserCabecalho.show();
		nomeCabecalho = chooserCabecalho.getFile();

		if (nomeCabecalho != null)
		{
			// Abre arquivo
			arquivoCabecalho = new File(chooserCabecalho.getDirectory(), nomeCabecalho);

			chooserTabela = new FileDialog(janela, "Abrir arquivo da tabela Huffman", FileDialog.LOAD);
			chooserTabela.setFile("*.tbh");
			chooserTabela.show();
			nomeTabela = chooserTabela.getFile();

			if (nomeTabela == null)
				return;

			// Arquivo Imagem
			chooserImagem = new FileDialog(janela, "Abrir arquivo da imagem Huffman", FileDialog.LOAD);
			chooserImagem.setFile("*.imh");
			chooserImagem.show();
			nomeImagem = chooserImagem.getFile();

			if (nomeImagem != null)
			{
				// Abre arquivo
				arquivoImagem = new File(chooserImagem.getDirectory(), nomeImagem);
				arquivoTabela = new File(chooserTabela.getDirectory(), nomeTabela);

				try
				{
					// Le arquivo
					imagem = obterImagemHuffman(arquivoCabecalho, arquivoImagem, arquivoTabela);

					// Exibe imagem
					criarJanelaInternaImagem(imagem);
					janela.getDesktopPane().getSelectedFrame().setTitle("[" + arquivoCabecalho.getName() + "]");
				} catch (IllegalArgumentException e)
				{
					exibeErro(e.getMessage());
				} catch (Exception e)
				{
					exibeErro("Erro no arquivo");
				}
			}
		}
	}

	/**
	 * Obtem uma imagem codificada em Huffman a partir de seus arquivos.
	 * 
	 * @param arquivoCabecalho
	 * @param arquivoImagem
	 * @param arquivoTabela
	 * @return
	 * @throws IOException
	 */
	private PanelImagem obterImagemHuffman(File arquivoCabecalho, File arquivoImagem, File arquivoTabela) throws IOException
	{
		// Declaração de variáveis
		BufferedReader br;
		int nl, nc, i, j, tam;
		String linha;
		StringBuilder sb;
		String[] linhaRepartida;
		short nivelCinza;
		PanelImagemTC panelImagem;
		DataInputStream dis;
		Map<String, Short> tabelaCodificacao;
		BitInputStream bio;

		// Leitura do arquivo Cabeçalho
		br = new BufferedReader(new FileReader(arquivoCabecalho));
		linhaRepartida = br.readLine().split(" ");

		nl = Integer.parseInt(linhaRepartida[1]);
		nc = Integer.parseInt(linhaRepartida[0]);
		br.close();

		panelImagem = new PanelImagemTC(nl, nc, arquivoImagem.length() + arquivoTabela.length());
		tabelaCodificacao = new HashMap<String, Short>();

		// Leitura da tabela
		dis = new DataInputStream(new FileInputStream(arquivoTabela));
		tam = dis.readInt();

		for (i = 0; i < tam; i++)
		{
			nivelCinza = dis.readShort();
			linha = dis.readUTF();

			tabelaCodificacao.put(linha, nivelCinza);
		}

		dis.close();

		// Leitura da imagem
		bio = new BitInputStream(new FileInputStream(arquivoImagem));

		for (i = 0; i < nl; i++)
		{
			for (j = 0; j < nc; j++)
			{
				sb = new StringBuilder();
				nivelCinza = 0;

				do
				{
					sb.append(bio.readBit());
					linha = sb.toString();
				} while (tabelaCodificacao.containsKey(linha) == false);

				nivelCinza = tabelaCodificacao.get(linha);

				panelImagem.setPosicao(i, j, nivelCinza);
			}
		}

		bio.close();

		return panelImagem;
	}

	/**
	 * Importa uma imagem codificada em RLE.
	 */
	@SuppressWarnings("deprecation")
	private void menuImportarRLE()
	{
		// Declaracao de variaveis
		File arquivoCabecalho, arquivoImagem;
		String nomeCabecalho, nomeImagem;
		FileDialog chooserCabecalho, chooserImagem;
		PanelImagem imagem;

		// Arquivo Cabeçalho
		chooserCabecalho = new FileDialog(janela, "Abrir arquivo", FileDialog.LOAD);
		chooserCabecalho.setFile("*.cab");
		chooserCabecalho.show();
		nomeCabecalho = chooserCabecalho.getFile();

		if (nomeCabecalho != null)
		{
			// Abre arquivo
			arquivoCabecalho = new File(chooserCabecalho.getDirectory(), nomeCabecalho);

			// Arquivo Imagem
			chooserImagem = new FileDialog(janela, "Abrir arquivo", FileDialog.LOAD);
			chooserImagem.setFile("*.imr");
			chooserImagem.show();
			nomeImagem = chooserImagem.getFile();

			if (nomeImagem != null)
			{
				// Abre arquivo
				arquivoImagem = new File(chooserImagem.getDirectory(), nomeImagem);

				try
				{
					// Le arquivo
					imagem = obterImagemRLE(arquivoCabecalho, arquivoImagem);

					// Exibe imagem
					criarJanelaInternaImagem(imagem);
					janela.getDesktopPane().getSelectedFrame().setTitle("[" + arquivoCabecalho.getName() + "]");
				} catch (IllegalArgumentException e)
				{
					exibeErro(e.getMessage());
				} catch (Exception e)
				{
					exibeErro("Erro no arquivo");
				}
			}
		}
	}

	/**
	 * Obtem uma imagem codificada em RLE a partir de arquivos.
	 * 
	 * @param arquivoCabecalho
	 * @param arquivoImagem
	 * @return
	 * @throws IOException
	 */
	private PanelImagem obterImagemRLE(File arquivoCabecalho, File arquivoImagem) throws IOException
	{
		// Declaração de variáveis
		BufferedReader br;
		int nl, nc, i, j, j2, k, tam;
		char digito;
		String linha;
		StringBuilder sb;
		String[] linhaRepartida, cod, rles;
		short nivelCinza;
		PanelImagemTC panelImagem;

		// Leitura do arquivo Cabeçalho
		br = new BufferedReader(new FileReader(arquivoCabecalho));
		linhaRepartida = br.readLine().split(" ");

		nl = Integer.parseInt(linhaRepartida[1]);
		nc = Integer.parseInt(linhaRepartida[0]);
		br.close();

		panelImagem = new PanelImagemTC(nl, nc, arquivoImagem.length());

		cod = new String[nl];

		// Leitura do arquivo Imagem
		br = new BufferedReader(new FileReader(arquivoImagem));

		for (i = 0; ((linha = br.readLine()) != null) && (i < nl); i++)
			cod[i] = linha;

		br.close();

		// Decodificar
		rles = new String[nl];
		for (i = 0; i < nl; i++)
		{
			sb = new StringBuilder();

			digito = cod[i].charAt(0);

			for (j = 1; j < cod[i].length(); j++)
			{
				if (cod[i].charAt(j) == '(')
				{
					j2 = j;
					while (cod[i].charAt(j) != ')')
						j++;
					tam = Integer.parseInt(cod[i].substring(j2 + 1, j));
				} else
					tam = Integer.parseInt(cod[i].substring(j, j + 1));

				for (k = 0; k < tam; k++)
					sb.append(digito);
				if (digito == '1')
					digito = '0';
				else if (digito == '0')
					digito = '1';
			}

			rles[i] = sb.toString();
		}

		// Transformar em imagem
		for (i = 0; i < nl; i++)
		{
			for (j = 0, k = 0; j < rles[i].length(); j += 8, k++)
			{
				nivelCinza = Short.parseShort(rles[i].substring(j, j + 8), 2);
				panelImagem.setPosicao(i, k, nivelCinza);
			}
		}

		return panelImagem;
	}

	/**
	 * Ação de exportar imagem codificada em RLE.
	 */
	@SuppressWarnings("deprecation")
	private void menuExportarRLE()
	{
		// Declaracao de variaveis
		int i, j, cont;
		long tam1, tam2;
		char digito;
		PanelImagem imagem;
		String[] rles, cod;
		StringBuilder sb;
		File arquivoImagem, arquivoCabecalho;
		String nomeImagem, nomeCabecalho;
		FileDialog chooserImagem, chooserCabecalho;
		BufferedWriter bw;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane().getSelectedFrame()).getPanelImagem();

		if (imagem instanceof PanelImagemTC == false)
		{
			exibeErro("Não é permitido exportar esta imagem.");
			return;
		}

		// Selecionar arquivo
		chooserCabecalho = new FileDialog(janela, "Abrir arquivo", FileDialog.LOAD);
		chooserCabecalho.setFile("*.cab");
		chooserCabecalho.show();
		nomeCabecalho = chooserCabecalho.getFile();
		if (nomeCabecalho == null)
			return;

		chooserImagem = new FileDialog(janela, "Salvar arquivo", FileDialog.SAVE);
		chooserImagem.setFile("*.imr");
		chooserImagem.show();
		nomeImagem = chooserImagem.getFile();
		if (nomeImagem == null)
			return;

		// Transformar em RLE
		short[][] matrizValores = ((PanelImagemTC) imagem).getMatrizValores();
		rles = new String[matrizValores.length];

		for (i = 0; i < matrizValores.length; i++)
		{
			sb = new StringBuilder();
			for (j = 0; j < matrizValores[i].length; j++)
			{
				sb.append(converterBinario(matrizValores[i][j]));
			}
			rles[i] = sb.toString();
		}

		// Codificar
		cod = new String[matrizValores.length];
		for (i = 0; i < rles.length; i++)
		{
			sb = new StringBuilder();

			digito = rles[i].charAt(0);
			sb.append(digito);

			for (j = 0; j < rles[i].length();)
			{
				for (cont = 0; j < rles[i].length() && rles[i].charAt(j) == digito; cont++, j++);
				if (cont < 10)
					sb.append(cont);
				else
					sb.append(String.format("(%d)", cont));

				if (j < rles[i].length())
					digito = rles[i].charAt(j);
			}

			cod[i] = sb.toString();
		}

		// Salvar
		try
		{
			arquivoCabecalho = new File(chooserCabecalho.getDirectory(), nomeCabecalho);
			arquivoImagem = new File(chooserImagem.getDirectory(), nomeImagem);

			// Salvar cabecalho
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivoCabecalho)));
			bw.write(String.format("%d %d", imagem.getNc(), imagem.getNl()));
			bw.close();

			// Salvar imagem
			bw = new BufferedWriter(new FileWriter(arquivoImagem));

			for (i = 0; i < cod.length; i++)
			{
				bw.write(cod[i]);
				bw.newLine();
			}

			bw.close();

			// Relatório de compressão
			tam1 = imagem.getTamanho();
			tam2 = arquivoImagem.length();
			float compressão = (1 - (float) tam2 / tam1) * 100;

			JOptionPane.showMessageDialog(janela, String.format("Exportação finalizada.\nRedução de: %.3f%%", compressão), "Exportar imagem", JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e)
		{
			exibeErro("Erro no arquivo.");
			return;
		}
	}

	/**
	 * Converte um short em binário.
	 * 
	 * @param s
	 * @return
	 */
	private String converterBinario(short s)
	{
		int k;
		short base, decimal;
		StringBuilder sb = new StringBuilder();

		decimal = s;
		for (k = 0; k < 8; k++)
		{
			base = (short) (decimal & 0x80);
			if (base == 0x80)
				sb.append("1");
			else
				sb.append("0");
			decimal = (short) (decimal << 1);
		}

		return sb.toString();
	}

	/**
	 * Ação de filtrar uma imagem por filtro da média.
	 */
	private void menuFiltrarMedia()
	{
		// Declaracao de variaveis
		int i, j;
		PanelImagem imagem, imagemNova = null;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane().getSelectedFrame()).getPanelImagem();

		if (imagem instanceof PanelImagemTC == false)
		{
			exibeErro("Não é permitido filtrar esta imagem.");
			return;
		}

		// Obter matriz filtro
		String[] filtros = new String[]
		{ "3x3", "5x5", "7x7" };
		String filtro = (String) JOptionPane.showInputDialog(janela, "Entre com o tamanho do filtro", "Filtro da Média", JOptionPane.INFORMATION_MESSAGE, null, filtros, filtros[0]);
		int tam;

		if (filtro == null)
			return;
		if (filtro == filtros[0])
			tam = 3;
		else if (filtro == filtros[1])
			tam = 5;
		else
			tam = 7;

		short[][] matrizFiltro = new short[tam][tam];
		for (i = 0; i < tam; i++)
		{
			for (j = 0; j < tam; j++)
			{
				matrizFiltro[i][j] = 1;
			}
		}

		short[][] matrizValores = ((PanelImagemTC) imagem).getMatrizValores();
		imagemNova = imagem.copiarImagem();

		// Aplicação do filtro
		for (i = 0; i < matrizValores.length; i++)
		{
			for (j = 0; j < matrizValores[i].length; j++)
			{
				((PanelImagemTC) imagemNova).setPosicao(i, j, convolucionar(matrizValores, matrizFiltro, new Posicao(i, j)));
			}
		}

		criarJanelaInternaImagem(imagemNova);
	}

	/**
	 * Ação de filtrar uma imagem por filtro da mediana.
	 */
	private void menuFiltrarMediana()
	{
		// Declaracao de variaveis
		PanelImagem imagem, imagemNova = null;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane().getSelectedFrame()).getPanelImagem();

		if (imagem instanceof PanelImagemTC == false)
		{
			exibeErro("Não é permitido filtrar esta imagem.");
			return;
		}

		// Obter matriz filtro
		String[] filtros = new String[]
		{ "3x3", "5x5", "7x7" };
		String filtro = (String) JOptionPane.showInputDialog(janela, "Entre com o tamanho do filtro", "Filtro da Mediana", JOptionPane.INFORMATION_MESSAGE, null, filtros, filtros[0]);
		int i, j, tam;

		if (filtro == null)
			return;
		if (filtro == filtros[0])
			tam = 3;
		else if (filtro == filtros[1])
			tam = 5;
		else
			tam = 7;

		short[][] matrizValores = ((PanelImagemTC) imagem).getMatrizValores();
		imagemNova = imagem.copiarImagem();

		// Aplicação do filtro
		for (i = 0; i < matrizValores.length; i++)
		{
			for (j = 0; j < matrizValores[i].length; j++)
			{
				((PanelImagemTC) imagemNova).setPosicao(i, j, obterMediana(matrizValores, tam, new Posicao(i, j)));
			}
		}
		criarJanelaInternaImagem(imagemNova);
	}

	/**
	 * Ação de gerar ruido sal.
	 */
	private void menuGerarSal()
	{
		// Declaracao de variaveis
		PanelImagem imagem, imagemNova = null;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane().getSelectedFrame()).getPanelImagem();

		if (imagem instanceof PanelImagemTC == false)
		{
			exibeErro("Não é permitido gerar ruído para esta imagem.");
			return;
		}

		imagemNova = imagem.copiarImagem();
		gerarSal(imagemNova);
		criarJanelaInternaImagem(imagemNova);
	}

	/**
	 * Gera o ruido sal para uma imagem
	 * 
	 * @param imagemNova
	 */
	private void gerarSal(PanelImagem imagemNova)
	{
		// Declaracao de variaveis
		int i, j, k, total;

		total = (int) Math.round(imagemNova.getNl() * imagemNova.getNc() * 0.02);

		// Geracao aleatoria
		for (k = 0; k < total; k++)
		{
			i = (int) Math.round(Math.random() * (imagemNova.getNl() - 1));
			j = (int) Math.round(Math.random() * (imagemNova.getNc() - 1));

			((PanelImagemTC) imagemNova).setPosicao(i, j, (short) 255);
		}
	}

	/**
	 * Ação de gerar ruido pimenta.
	 */
	private void menuGerarPimenta()
	{
		// Declaracao de variaveis
		PanelImagem imagem, imagemNova = null;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane().getSelectedFrame()).getPanelImagem();

		if (imagem instanceof PanelImagemTC == false)
		{
			exibeErro("Não é permitido gerar ruído para esta imagem.");
			return;
		}

		imagemNova = imagem.copiarImagem();
		gerarPimenta(imagemNova);
		criarJanelaInternaImagem(imagemNova);
	}

	/**
	 * Ação de gerar ruido pimenta.
	 */
	private void gerarPimenta(PanelImagem imagemNova)
	{
		// Declaracao de variaveis
		int i, j, k, total;

		total = (int) Math.round(imagemNova.getNl() * imagemNova.getNc() * 0.02);

		// Geracao aleatoria
		for (k = 0; k < total; k++)
		{
			i = (int) Math.round(Math.random() * (imagemNova.getNl() - 1));
			j = (int) Math.round(Math.random() * (imagemNova.getNc() - 1));

			((PanelImagemTC) imagemNova).setPosicao(i, j, (short) 0);
		}
	}

	/**
	 * Ação de binarizar uma imagem tons de cinza.
	 */
	private void menuBinarizacao()
	{
		// Declaracao de variaveis
		PanelImagem imagem, imagemNova = null;
		DialogoHistograma dialogoHistograma;
		Short limiar;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane().getSelectedFrame()).getPanelImagem();

		if (imagem instanceof PanelImagemTC == false)
		{
			exibeErro("Não é permitido binarizar esta imagem.");
			return;
		}

		// Criacao do descritor
		dialogoHistograma = new DialogoHistograma(janela, new Descritor(imagem));
		limiar = dialogoHistograma.getLimiar();

		// Binarizacao
		if (limiar != null)
		{
			imagemNova = ((PanelImagemTC) imagem).binarizarImagem(limiar);
			criarJanelaInternaImagem(imagemNova);
		}
	}

	/**
	 * Acao de equalizar uma imagem tons de cinza.
	 */
	private void menuEqualizacao()
	{
		// Declaracao de variaveis
		PanelImagem imagem, imagemNova;
		String faixasStr;
		int faixas;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane().getSelectedFrame()).getPanelImagem();

		if (imagem instanceof PanelImagemTC == false)
		{
			exibeErro("Não é permitido equalizar esta imagem.");
			return;
		}

		try
		{
			do
			{
				faixasStr = JOptionPane.showInputDialog(janela, "Entre com o número de faixas do histograma", "Equalizar imagem", JOptionPane.INFORMATION_MESSAGE);
				faixas = Integer.parseInt(faixasStr);
			} while (faixas < 1 || faixas > 255);
			imagemNova = ((PanelImagemTC) imagem).equalizarImagem(faixas);
			criarJanelaInternaImagem(imagemNova);

		} catch (NumberFormatException e)
		{
			exibeErro("Entrada incorreta!");
		} catch (NullPointerException e)
		{
		}
	}

	/**
	 * Ação de realizar uma transformação.
	 * 
	 * @param tipo
	 */
	private void menuTransformacao(TipoTransformacao tipo)
	{
		// Declaracao de variaveis
		PanelImagem imagem, imagemNova;
		TransformacaoStrategy transformacao;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane().getSelectedFrame()).getPanelImagem();

		transformacao = new DialogoTransformacao(janela, tipo).getTransformacao();

		if (transformacao == null)
			return;

		imagemNova = imagem.realizarTransformacao(transformacao);
		criarJanelaInternaImagem(imagemNova);
	}

	/**
	 * Ação de obter os elementos conectados de uma imagem.
	 */
	private void menuObterConectados()
	{
		// Declaracao de variaveis
		List<CorridaLinha> listaCorridasReconhecidas;
		PanelImagem imagem;
		PanelImagemBinaria imagemBinaria;
		int nl, nc;

		if (janela.getDesktopPane().getSelectedFrame() == null)
			return;

		imagem = ((JanelaInternaImagem) janela.getDesktopPane().getSelectedFrame()).getPanelImagem();

		if (imagem instanceof PanelImagemBinaria == false)
		{
			exibeErro("Não é permitido obter os elementos conectados desta imagem.");
			return;
		}

		imagemBinaria = (PanelImagemBinaria) imagem;
		nl = imagem.getNl();
		nc = imagem.getNc();

		// Passo 1: obtencao das corridas
		listaCorridasReconhecidas = obterCorridas(imagemBinaria, nl, nc);

		// Passo 2: criacao das classes de equivalencia
		reconhecerEquivalencias(nl, listaCorridasReconhecidas);

		// Passo 3: Pintar corridas equivalentes
		pintarCorridas(imagemBinaria, listaCorridasReconhecidas);
	}

	/**
	 * Ação de pintar as corridas detectadas.
	 * 
	 * @param imagem
	 * @param listaCorridasReconhecidas
	 */
	private void pintarCorridas(PanelImagem imagem, List<CorridaLinha> listaCorridasReconhecidas)
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

			for (i = corridaLinha.getColunaInicio(); i <= corridaLinha.getColunaFinal(); i++)
			{
				imagem.pintarPosicao(corridaLinha.getLinha(), i, cor);
			}
		}
	}

	/**
	 * Obtem uma cor da tabela de cores
	 * 
	 * @param equivalencia
	 * @param tabelaCores
	 * @return
	 */
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

	/**
	 * Reconhece as equivalencias de uma lista de corridas.
	 * 
	 * @param nl
	 * @param listaCorridasReconhecidas
	 */
	private void reconhecerEquivalencias(int nl, List<CorridaLinha> listaCorridasReconhecidas)
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
			listaCorridasVizinhas = getCorridasVizinhas(listaCorridasReconhecidas, corrida);

			// Seta equivalencia aos vizinhos
			for (CorridaLinha corridaVizinha : listaCorridasVizinhas)
			{
				corridaVizinha.setEquivalencia(contadorEquivalencia);
				reconhecerVizinhos(corridaVizinha, listaCorridasReconhecidas, filaPercurso, contadorEquivalencia);
				filaPercurso.remove(corridaVizinha);
			}

			contadorEquivalencia++;
		}
	}

	/**
	 * Reconhece os vizinhos, obtendo as corridas conectadas
	 * 
	 * @param corridaLinha
	 * @param listaCorridasReconhecidas
	 * @param listaPercurso
	 * @param equivalencia
	 */
	private void reconhecerVizinhos(CorridaLinha corridaLinha, List<CorridaLinha> listaCorridasReconhecidas, Queue<CorridaLinha> listaPercurso, int equivalencia)
	{
		// Declaracao de variaveis
		List<CorridaLinha> listaCorridasVizinhas;

		// Obtem vizinhos
		listaCorridasVizinhas = getCorridasVizinhas(listaCorridasReconhecidas, corridaLinha);

		// Seta equivalencia aos vizinhos
		for (CorridaLinha corridaVizinha : listaCorridasVizinhas)
		{
			if (corridaVizinha.getEquivalencia() == equivalencia)
				continue;

			corridaVizinha.setEquivalencia(equivalencia);
			reconhecerVizinhos(corridaVizinha, listaCorridasReconhecidas, listaPercurso, equivalencia);
			listaPercurso.remove(corridaVizinha);
		}
	}

	/**
	 * Procedimento recursivo para a conexão das corridas.
	 * 
	 * @param listaCorridasReconhecidas
	 * @param corridaLinha
	 * @return
	 */
	private List<CorridaLinha> getCorridasVizinhas(List<CorridaLinha> listaCorridasReconhecidas, CorridaLinha corridaLinha)
	{
		// Declaracao de variaveis
		List<CorridaLinha> listaCorridas;

		listaCorridas = new ArrayList<CorridaLinha>();

		// Busca vizinhancas
		for (CorridaLinha corridaVizinha : listaCorridasReconhecidas)
		{
			if (corridaVizinha == corridaLinha)
				continue;

			if (corridaVizinha.getLinha() == corridaLinha.getLinha() - 1 || corridaVizinha.getLinha() == corridaLinha.getLinha() + 1)
			{
				// Verifica adjacencia-8 aos vizinhos
				if (corridaLinha.getColunaInicio() <= corridaVizinha.getColunaFinal() + 1 && corridaLinha.getColunaFinal() >= corridaVizinha.getColunaInicio() - 1)
				{
					listaCorridas.add(corridaVizinha);
				}
			}
		}

		return listaCorridas;
	}

	/**
	 * Obtém as corridas de uma imagem.
	 * 
	 * @param imagem
	 * @param nl
	 * @param nc
	 * @return
	 */
	private List<CorridaLinha> obterCorridas(PanelImagemBinaria imagem, int nl, int nc)
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
						corridaReconhecida = new CorridaLinha(i, colunaInicial, colunaFinal);
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

	/**
	 * Exibe uma mensagem de erro.
	 * 
	 * @param mensagem
	 */
	private void exibeErro(String mensagem)
	{
		JOptionPane.showMessageDialog(janela, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Ação de abrir uma imagem.
	 */
	@SuppressWarnings("deprecation")
	private void menuAbrir()
	{
		// Declaracao de variaveis
		File arquivoCabecalho, arquivoImagem;
		String nomeCabecalho, nomeImagem;
		FileDialog chooserCabecalho, chooserImagem;
		PanelImagem imagem;

		// Arquivo Cabeçalho
		chooserCabecalho = new FileDialog(janela, "Abrir arquivo", FileDialog.LOAD);
		chooserCabecalho.setFile("*.cab");
		chooserCabecalho.show();
		nomeCabecalho = chooserCabecalho.getFile();

		if (nomeCabecalho != null)
		{
			// Abre arquivo
			arquivoCabecalho = new File(chooserCabecalho.getDirectory(), nomeCabecalho);

			// Arquivo Imagem
			chooserImagem = new FileDialog(janela, "Abrir arquivo", FileDialog.LOAD);
			chooserImagem.setFile("*.img");
			chooserImagem.show();
			nomeImagem = chooserImagem.getFile();

			if (nomeImagem != null)
			{
				// Abre arquivo
				arquivoImagem = new File(chooserImagem.getDirectory(), nomeImagem);

				try
				{
					// Le arquivo
					imagem = obterImagem(arquivoCabecalho, arquivoImagem);

					// Exibe imagem
					criarJanelaInternaImagem(imagem);
					janela.getDesktopPane().getSelectedFrame().setTitle("[" + arquivoCabecalho.getName() + "]");
				} catch (IllegalArgumentException e)
				{
					exibeErro(e.getMessage());
				} catch (Exception e)
				{
					exibeErro("Erro no arquivo");
				}
			}
		}
	}

	/**
	 * Obtém uma imagem a partir de arquivos.
	 * 
	 * @param arquivoCabecalho
	 * @param arquivoImagem
	 * @return
	 * @throws IOException
	 */
	private PanelImagem obterImagem(File arquivoCabecalho, File arquivoImagem) throws IOException
	{
		// Declaracao de variaveis
		BufferedReader br;
		int nl, nc, i, j;
		String linha;
		String[] linhaRepartida;
		short nivelCinza;
		PanelImagemTC panelImagem;

		// Leitura do arquivo Cabeçalho
		br = new BufferedReader(new FileReader(arquivoCabecalho));
		linhaRepartida = br.readLine().split(" ");

		nl = Integer.parseInt(linhaRepartida[0]);
		nc = Integer.parseInt(linhaRepartida[1]);
		br.close();

		panelImagem = new PanelImagemTC(nc, nl, arquivoImagem.length());

		// Leitura do arquivo Imagem
		br = new BufferedReader(new FileReader(arquivoImagem));

		for (i = 0; ((linha = br.readLine()) != null) && (i < nl); i++)
		{
			linhaRepartida = linha.split(" ");
			for (j = 0; j < (linhaRepartida.length) && (j < nc); j++)
			{
				nivelCinza = Short.parseShort(linhaRepartida[j]);
				panelImagem.setPosicao(j, i, nivelCinza);
			}
		}
		br.close();

		return panelImagem;
	}

	/**
	 * Cria uma JInternalFrame.
	 * 
	 * @param imagem
	 */
	private void criarJanelaInternaImagem(PanelImagem imagem)
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

	/**
	 * Realiza convolução entre matrizes
	 * 
	 * @param matrizA
	 * @param matrizB
	 * @param posicaoCentral
	 * @return
	 */
	private short convolucionar(short[][] matrizA, short[][] matrizB, Posicao posicaoCentral)
	{
		int iA, iB, jA, jB, z, w, dimensaoMetade;

		w = 0;
		z = 0;
		dimensaoMetade = matrizB.length / 2;

		// Executa a convolução
		for (iA = posicaoCentral.getPosLinha() - dimensaoMetade, iB = 0; iB < matrizB.length; iA++, iB++)
		{
			for (jA = posicaoCentral.getPosColuna() - dimensaoMetade, jB = 0; jB < matrizB[iB].length; jA++, jB++)
			{

				if (iA < 0 || iA >= matrizA.length || jA < 0 || jA >= matrizA[iA].length)
					continue;

				w = multiplicarBitWise(matrizA[iA][jA], matrizB[iB][jB]);
				z += w;
			}
		}

		w = somaBitWise(w, z);

		z /= matrizB.length * matrizB.length;

		// Truncamento
		if (z > 255)
			z = 255;

		return (short) z;
	}

	/**
	 * Realiza multiplicação por bit-wise.
	 * 
	 * @param termo1
	 * @param termo2
	 * @return
	 */
	private int multiplicarBitWise(int termo1, int termo2)
	{
		int i, resultado;

		// Multiplica bit-wise
		resultado = 0;
		for (i = 0; i < 32; i++)
		{
			if (termo2 % 2 == 1)
			{
				resultado += termo1;
			}
			termo2 = termo2 >> 1;
			termo1 = termo1 << 1;
		}

		return resultado;
	}

	/**
	 * Realiza soma por bit-wise.
	 * 
	 * @param parcela1
	 * @param parcela2
	 * @return
	 */
	private int somaBitWise(int parcela1, int parcela2)
	{
		int soma;

		// Soma bit-wise
		soma = parcela1;
		while (parcela2 > 0)
		{
			soma = soma ^ parcela2;
			parcela2 = (parcela2 & soma) << 1;
		}

		return soma;
	}

	/**
	 * Obtém a mediana de uma coleção de valores.
	 * 
	 * @param matrizValores
	 * @param tam
	 * @param posicao
	 * @return
	 */
	private short obterMediana(short[][] matrizValores, int tam, Posicao posicao)
	{
		List<Short> listaValores;
		int i, j, dimensaoMetade;
		short mediana;

		dimensaoMetade = tam / 2;
		listaValores = new ArrayList<Short>();

		// Obtém mediana
		for (i = posicao.getPosLinha() - dimensaoMetade; i <= posicao.getPosLinha() + dimensaoMetade; i++)
		{
			if (i < 0 || i >= matrizValores.length)
				continue;
			for (j = posicao.getPosColuna() - dimensaoMetade; j <= posicao.getPosColuna() + dimensaoMetade; j++)
			{
				if (j < 0 || j >= matrizValores[i].length)
					continue;

				listaValores.add(matrizValores[i][j]);
			}
		}

		Collections.sort(listaValores);

		// Calcula
		if (listaValores.size() % 2 == 1)
			mediana = (short) (listaValores.get(listaValores.size() / 2 - 1));
		else
			mediana = (short) ((listaValores.get(listaValores.size() / 2 - 1) + listaValores.get(listaValores.size() / 2 - 1)) / 2);

		return mediana;
	}
}
