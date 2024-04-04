package veiculos;

public class Carro {
	public String marca;
	public String modelo;
	public int ano;
	public String cor;
	public int numero_portas;

	public void descricao(String marca, String modelo, int ano, String cor, int numero_portas) {
		System.out.println(marca + modelo + ano + cor + " Portas: " +numero_portas);
	}
}
