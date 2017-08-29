package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import redes.Hamming;

public class testes {
	Hamming teste;
	@Test
	public void testWordTransferred() {
		teste = new Hamming();
		
		teste.setBitTransferred("0110011");				
		teste.setParidade("par");
		teste.gerarBitsParidade(teste.getBitTransferred());		
		assertEquals("Palavra esta correta",teste.chacarErros());
	}
	
	@Test
	public void testWordTransferring() {
		teste = new Hamming();
		
		teste.setBitTransfer("10011010");				
		teste.setParidade("par");		
		assertEquals("011100101010",teste.gerarBitTransferred());
	}

}
