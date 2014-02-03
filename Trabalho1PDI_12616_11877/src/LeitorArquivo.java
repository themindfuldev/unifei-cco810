/*

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LeitorDeArquivo 
{	

	private String arquivo;

	public LeitorDeArquivo(String arquivo)
	{
		this.arquivo = arquivo;
	}


	public FiguraFechada getFigura1()
	{
		int cn1x = 0; 
		int cn1y = 0;
		int cn1r = 0;

		int cs1x = 0; 
		int cs1y = 0; 
		int cs1r = 0; 

		int pcx = 0; 
		int pcy = 0; 

		int largura = 0;
		int altura = 0;

		try
		{
			FileReader reader = new FileReader(arquivo);
			BufferedReader leitor = new BufferedReader(reader);

			String linha = null;

			while((linha = leitor.readLine()) != null) {
				String[] result = linha.split("\\s");				

				cn1x = Integer.parseInt(result[1]);
				cn1y = Integer.parseInt(result[2]);
				cn1r = Integer.parseInt(result[3]);

				cs1x = Integer.parseInt(result[5]);
				cs1y = Integer.parseInt(result[6]);
				cs1r = Integer.parseInt(result[7]);

				pcx =  Integer.parseInt(result[8]);
				pcy =  Integer.parseInt(result[9]);

				largura = Integer.parseInt(result[10]);
				altura =  Integer.parseInt(result[11]);
			}			

			leitor.close();
			reader.close();


		}
		catch (FileNotFoundException FNFe) {
			System.out.println("Erro ao abrir o arquivo");			
		}
		catch (IOException IOe) {
			System.out.println(IOe.getMessage());
		}

		return new FiguraFechada(
				new Circulo(new Ponto(cn1x,cn1y), cn1r ), 
				new Circulo(new Ponto(0,0), 0 ),
				new Circulo(new Ponto(cs1x,cs1y), cs1r ),
				new Circulo(new Ponto(0,0), 0 ),
				new Ponto(pcx,pcy),
				largura, altura) ;
	}


	public FiguraFechada getFigura2()
	{
		int cn1x = 0; 
		int cn1y = 0;
		int cn1r = 0;

		int cs1x = 0; 
		int cs1y = 0; 
		int cs1r = 0; 

		int pcx = 0; 
		int pcy = 0; 

		int largura = 0;
		int altura = 0;

		try
		{
			FileReader reader = new FileReader(arquivo);
			BufferedReader leitor = new BufferedReader(reader);

			String linha = null;

			while((linha = leitor.readLine()) != null) {
				String[] result = linha.split("\\s");				

				cn1x = Integer.parseInt(result[1]);
				cn1y = Integer.parseInt(result[2]);
				cn1r = Integer.parseInt(result[3]);

				cs1x = Integer.parseInt(result[5]);
				cs1y = Integer.parseInt(result[6]);
				cs1r = Integer.parseInt(result[7]);

				pcx =  Integer.parseInt(result[8]);
				pcy =  Integer.parseInt(result[9]);

				largura = Integer.parseInt(result[10]);
				altura =  Integer.parseInt(result[11]);
			}			

			leitor.close();
			reader.close();


		}
		catch (FileNotFoundException FNFe) {
			System.out.println("Erro ao abrir o arquivo");			
		}
		catch (IOException IOe) {
			System.out.println(IOe.getMessage());
		}

		return new FiguraFechada(
				new Circulo(new Ponto(cn1x,cn1y), cn1r ), 
				new Circulo(new Ponto(0,0), 0 ),
				new Circulo(new Ponto(cs1x,cs1y), cs1r ),
				new Circulo(new Ponto(0,0), 0 ),
				new Ponto(pcx,pcy),
				largura, altura) ;
	}
	
	public FiguraFechada getFigura3()
	{
		int cn1x = 0, cn2x = 0; 
		int cn1y = 0, cn2y = 0;
		int cn1r = 0, cn2r = 0;

		int cs1x = 0, cs2x = 0; 
		int cs1y = 0, cs2y = 0; 
		int cs1r = 0, cs2r = 0; 

		int pcx = 0; 
		int pcy = 0; 

		int largura = 0;
		int altura = 0;
		
		try
		{
			FileReader reader = new FileReader(arquivo);
			BufferedReader leitor = new BufferedReader(reader);

			String linha = null;

			while((linha = leitor.readLine()) != null) {
				String[] result = linha.split("\\s");				

				cn1x = Integer.parseInt(result[1]);
				cn1y = Integer.parseInt(result[2]);
				cn1r = Integer.parseInt(result[3]);
				
				cn2x = Integer.parseInt(result[4]);
				cn2y = Integer.parseInt(result[5]);
				cn2r = Integer.parseInt(result[6]);

				cs1x = Integer.parseInt(result[8]);
				cs1y = Integer.parseInt(result[9]);
				cs1r = Integer.parseInt(result[10]);
				
				cs2x = Integer.parseInt(result[11]);
				cs2y = Integer.parseInt(result[12]);
				cs2r = Integer.parseInt(result[13]);

				pcx =  Integer.parseInt(result[14]);
				pcy =  Integer.parseInt(result[15]);

				largura = Integer.parseInt(result[16]);
				altura =  Integer.parseInt(result[17]);
			}			

			leitor.close();
			reader.close();


		}
		catch (FileNotFoundException FNFe) {
			System.out.println("Erro ao abrir o arquivo");			
		}
		catch (IOException IOe) {
			System.out.println(IOe.getMessage());
		}

		return new FiguraFechada(
				new Circulo(new Ponto(cn1x,cn1y), cn1r ), 
				new Circulo(new Ponto(cn2x,cn2y), cn2r ),
				new Circulo(new Ponto(cs1x,cs1y), cs1r ),
				new Circulo(new Ponto(cs2x,cs2y), cs2r ),
				new Ponto(pcx,pcy),
				largura, altura) ;
	}

}
*/

