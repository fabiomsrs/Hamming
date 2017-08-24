package redes;

public class teste {
	
	public static void main(String[] args) {
		Hamming teste = new Hamming();
		
		teste.setBitTransfer("1011");				
		teste.setParidade("par");				
		System.out.println(teste.gerarBitTransferred());
		
	}
}
