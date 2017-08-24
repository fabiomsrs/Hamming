package redes;

public class teste {
	
	public static void main(String[] args) {
		Hamming teste = new Hamming();
		
		teste.setBitTransferred("0010011");				
		teste.setParidade("par");
		teste.gerarBitsParidade(teste.getBitTransferred());
		teste.chacarErros();
		
	}
}
