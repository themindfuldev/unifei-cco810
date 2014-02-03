import java.util.ArrayList;

public class Corrida {
	private int rotulo;
	private ArrayList<Pixel> listaPixels;
	
	public int getRotulo() {
		return rotulo;
	}
	public void setRotulo(int rotulo) {
		this.rotulo = rotulo;
	}
	
	public Corrida(int rotulo) {		
		this.rotulo = rotulo;
		listaPixels = new ArrayList<Pixel>();
	}
	public Corrida(int rotulo, ArrayList<Pixel> listaPixels) {		
		this.rotulo = rotulo;
		this.listaPixels = listaPixels;
	}
	
	public void adicionaCelula(Pixel celula){
		this.listaPixels.add(celula);		
	}
	
	public int retornaNumeroPixels(){
		int numeroPixels;
		numeroPixels = this.listaPixels.size();
		return numeroPixels;
	}
	
	
}
