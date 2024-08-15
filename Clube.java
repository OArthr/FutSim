package futsim;

public class Clube {
	private String nome;
	private int pontos = 0;
	private int saldoGol = 0;
	
	public void ganhar(int saldoGol) {
		pontos += 3;
		this.saldoGol += saldoGol;
	}
	
	public void empatar() {
		pontos += 1;
	}
	
	public void perder(int saldoGol) {
		this.saldoGol -= saldoGol;		
	}
	
	//get e set
	public String getNome() {
		return nome;
	}
	public int getPontos() {
		return pontos;
	}
	public int getSaldoGol() {
		return saldoGol;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
