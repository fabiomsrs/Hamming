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
		this.gerarBitsParidade();
		this.bitTransferred = this.bitTransfer;	
		for(int i = 0; i < this.bitTransfer.length(); i++){				
			if(IsBitParidade(i+1)){				
				List<Integer> bit = this.calculaBitParidade(i+1, this.bitTransfer);
				System.out.println(bit);
				int sum = 0;				
				for(int b : bit){
					System.out.println("somando: " + b);
					sum += Integer.parseInt(this.bitTransfer.charAt(b-1)+"");					
				}					
				System.out.println(sum);
				if(this.paridade.equals("par") && sum % 2 == 0){
					this.bitTransferred = this.utilsChange(i, "0", this.bitTransferred);
					System.out.println("apos: "+ this.bitTransferred);					
				}
				else if(this.paridade.equals("impar") && sum % 2 != 0){
					this.bitTransferred = this.utilsChange(i, "0", this.bitTransferred);
					System.out.println("apos: "+ this.bitTransferred);
				}
				else{
					this.bitTransferred = this.utilsChange(i, "1", this.bitTransferred);
					System.out.println("apos: "+ this.bitTransferred);
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
		for(int i = transfer.length() - 1; i > 0 ; i--){
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
		inserted = inserted.substring(0, position) + insert + inserted.substring(position, inserted.length());
		return inserted;
	}
	
	public String utilsChange(int position,String insert, String inserted){
		if(position > 0)
			inserted = inserted.substring(0, position-1) + insert + inserted.substring(position, inserted.length());
		else
			inserted = insert + inserted.substring(position+1, inserted.length());
		return inserted;
	}
	
	public void gerarBitsParidade() {
		this.configurarPalavra();
		for (int i = this.bitTransfer.length() - 1; i >= 0; i--){			
			if(this.IsBitParidade(i+1)){				
				this.bitsParidade.add(i+1);	
			}
		}		
	}
	
	public void configurarPalavra() {
		
		for (int i = this.bitTransfer.length() - 1; i >= 0; i--){			
			if(this.IsBitParidade(i+1)){
				this.bitTransfer = this.utilsInsertInto(i, "0", this.bitTransfer);					
			}
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
