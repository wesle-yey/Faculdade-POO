package veiculos;

public class Moto {
	String marca;
	String modelo;
	int ano;
	String cor;
	int cilindradas;
	
	public void descricao(String marca, String modelo, int ano, String cor, int cilindradas) {
		System.out.println(marca + modelo + ano + cor + "Cilindradas: " +cilindradas);
	}
}
