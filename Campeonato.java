package futsim;

import java.util.Random;

public class Campeonato {
	private Clube[] clubes;
	private int i = 0;
	private int j = 0;
	private int n = 0;
	
	
	public void setNumClubes(int n) {
		clubes = new Clube[n];
		this.n = n;
	}
	
	public void addClubes(Clube c) {
		clubes[i] = c;
		i++;
	}
	
	public void jogarPartida(Clube m, Clube n) {
		Random rand = new Random();
		int gm = rand.nextInt(6);
		int gn = rand.nextInt(6);
		int saldo = gm-gn;
		
		if(saldo > 0) {
			m.ganhar(saldo);
			n.perder(saldo);
		}else if (saldo == 0) {
			m.empatar();
			n.empatar();
		}else {
			m.perder(-saldo);
			n.ganhar(-saldo);
		}
		System.out.println(m.getNome()+" vs "+n.getNome()+"\n      "+gm+" x "+gn+"\n");
	}
	
	public void jogarCampeonato() {
		for(i = 0; i < this.n - 1; i++) {
			for(j = i+1; j < this.n; j++) {
				System.out.println("-------------------------");
				this.jogarPartida(clubes[i], clubes[j]);
				this.jogarPartida(clubes[j], clubes[i]);
			}
		}
	}
	
	public void getClassificacao() {
		boolean troca = true;
		for(i = 0; i<this.n ;i++) {
			troca = false;
			for(j = 0;j<this.n-i-1; j++) {
				if(clubes[j].getPontos() < clubes[j+1].getPontos()
						||(clubes[j].getPontos() == clubes[j+1].getPontos() 
							&& clubes[j].getSaldoGol()<clubes[j+1].getSaldoGol())) {
					Clube temp = clubes[j];
					clubes[j] = clubes[j+1];
					clubes[j+1] = temp;
					troca = true;
				}
			}
			if(!troca)
				break;
		}
		for(i=0;i<this.n;i++) {
			System.out.println("--------------------------\n"+
					(i+1)+"º posição: "+clubes[i].getNome()+
					"\nPontos: "+clubes[i].getPontos()+
					"\nSaldo: "+clubes[i].getSaldoGol());
		}
		System.out.println("--------------------------\n\n");
	}
	
	public Clube getCampeao() {
		return clubes[0];
	}
}
