package redes;

public class teste {
	
	public static void main(String[] args) {
		Hamming teste = new Hamming();
		
		teste.setBitTransfer("11000100");
		teste.setParidade("par");	
		System.out.println(teste.gerarBitTransferred());
		
	}
}
