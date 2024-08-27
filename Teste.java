package futsim;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Campeonato camp = new Campeonato();
		
		System.out.println("Digite a quantidade de clubes na competição: ");
		int n = scan.nextInt();
		camp.setNumClubes(n);
		
		for(int i = 1; i <= n; i++) {
			Clube c = new Clube();
			c.setNome("Clube "+i);
			camp.addClubes(c);
		}
		camp.jogarCampeonato();
		camp.getClassificacao();
		System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n"
				+ "Campeão: "+camp.getCampeao().getNome()+
				"\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
		scan.close();
		
	}
}
