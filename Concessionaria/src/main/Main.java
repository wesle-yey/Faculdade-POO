package main;

import veiculos.*;

public class Main {

	public static void main(String[] args) {
		Carro carro = new Carro();
		Moto moto = new Moto();
		
		carro.descricao("Toyota, ", "Corolla, ", 2020 , ", Preto, ", 4);
		moto.descricao("Honda, ", "CBR500R, ", 2021 , ", Vermelho, ", 500);
	}


}
