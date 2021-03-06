package redes;

import java.util.ArrayList;
import java.util.List;

public class Hamming {
	private String bitTransfer;
	private String bitTransferred;
	private List<Integer> bitsParidade;
	private String paridade;
	
	public Hamming(){
		 this.bitsParidade = new ArrayList<Integer>();
		 this.bitTransfer = "";
		 this.bitTransferred = "";
	}
	
	public String gerarBitTransferred(){
		this.configurarPalavra();
		this.bitTransferred = this.bitTransfer;
		this.gerarBitsParidade(this.bitTransferred);				
		for(int i = 0; i < this.bitTransfer.length(); i++){			
			if(IsBitParidade(i+1)){				
				
				List<Integer> bit = this.calculaBitParidade(i+1, this.bitTransferred);								
				int sum = 0;				
				for(int b : bit){					
					sum += Integer.parseInt(this.bitTransferred.charAt(b-1)+"");					
				}									
				if(this.paridade.equals("par") && sum % 2 == 0){
					this.bitTransferred = this.utilsChange(i, "0", this.bitTransferred);						
				}
				else if(this.paridade.equals("impar") && sum % 2 != 0){
					this.bitTransferred = this.utilsChange(i, "0", this.bitTransferred);					
				}
				else{
					this.bitTransferred = this.utilsChange(i, "1", this.bitTransferred);					
				}
						
			}			
		}
		return this.bitTransferred;
	}
	
	public boolean IsBitParidade(int i){
		if(i >0 && i<=2){
			return true;
		}
		else{
			while(i > 1){				
				if(i%2 == 0){					
					i = i/2;					
				}
				else{
					return false;
				}
			}			
		}	
		return true;
	}
	
	public List<Integer> calculaBitParidade(int bit, String transfer){
		List<Integer> calculateNumbers = new ArrayList<>();				
		for(int i = transfer.length(); i > 0 ; i--){
			int sum = 0;
			if(!IsBitParidade(i)){				
				for(int bitParidade:this.bitsParidade){					
					if(i > bitParidade && sum + bitParidade <= i){						
						sum+=bitParidade;
						if(bitParidade == bit){							
							calculateNumbers.add(i);
						}
					}
				}
			}			
		}				
		
		return calculateNumbers;
	}
	
	public String utilsInsertInto(int position,String insert, String inserted){			
		/*System.out.println(position+1);
		System.out.println("-"+ inserted.substring(0, position) +"-"+"0" + "-"+inserted.substring(position, inserted.length()));*/
		inserted = inserted.substring(0, position) + insert + inserted.substring(position, inserted.length());		
		
		return inserted;
	}
	
	public String utilsChange(int position,String insert, String inserted){
		if(position > 0)
			inserted = inserted.substring(0, position) + insert + inserted.substring(position+1, inserted.length());
		else
			inserted = insert + inserted.substring(position+1, inserted.length());
		return inserted;
	}
	
	public void gerarBitsParidade(String palavra) {		
		for (int i = palavra.length()-1; i >= 0; i--){			
			if(this.IsBitParidade(i+1)){				
				this.bitsParidade.add(i+1);	
			}
		}
	}
	
	public void configurarPalavra() {
		
		for (int i = 0; i < this.bitTransfer.length(); i++){			
			if(this.IsBitParidade(i+1)){
				this.bitTransfer = this.utilsInsertInto(i, "0", this.bitTransfer);					
			}
		}		
	}	
	
	public String chacarErros(){
		int contErros = 0;
		String msgError = "";
		System.out.println(this.bitTransferred);
		for(int i = 0; i < this.bitTransferred.length(); i++){			
			if(IsBitParidade(i+1)){				
				
				List<Integer> bit = this.calculaBitParidade(i+1, this.bitTransferred);								
				int sum = 0;				
				for(int b : bit){					
					sum += Integer.parseInt(this.bitTransferred.charAt(b-1)+"");					
				}	
				System.out.println("BitParidade "+ (i+1) + " - soma = "+sum+" = "+ this.bitTransferred.charAt(i));
				if(this.paridade.equals("par") && sum % 2 == 0 && Integer.parseInt(this.bitTransferred.charAt(i)+"") == 1){
					msgError += "Error bit paridade "+ (i+1);
					contErros++;
				}
				else if(this.paridade.equals("par") && sum % 2 != 0 && Integer.parseInt(this.bitTransferred.charAt(i)+"") == 0){
					msgError += "Error bit paridade "+ (i+1);
					contErros++;
				}
				else if(this.paridade.equals("impar") && sum % 2 != 0 && Integer.parseInt(this.bitTransferred.charAt(i)+"") == 0){
					msgError += "Error bit paridade "+ (i+1);
					contErros++;
				}
				else if(this.paridade.equals("impar") && sum % 2 == 0 && Integer.parseInt(this.bitTransferred.charAt(i)+"") == 1){
					msgError += "Error bit paridade "+ (i+1);
					contErros++;
				}	
			}			
		}
		if(contErros == 0){
			return "Palavra esta correta";
		}
		else{
			return msgError;
		}
	}
	public String getBitTransfer() {
		return bitTransfer;
	}
	public void setBitTransfer(String bitTranfer) {
		this.bitTransfer = bitTranfer;
	}
	public String getBitTransferred() {
		return bitTransferred;
	}
	public void setBitTransferred(String bitTransferred) {
		this.bitTransferred = bitTransferred;
	}
	public List<Integer> getBitsParidade() {
		return bitsParidade;
	}	
	public String getParidade() {
		return paridade;
	}
	public void setParidade(String paridade) {
		this.paridade = paridade;
	}

}
