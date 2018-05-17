import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class BadNeighbors {
	
	public int maxDonations(int[] donations) {
		int[] semOPrimeiro = Arrays.copyOfRange(donations, 1, donations.length);
		int opt1 = avaliar(semOPrimeiro, semOPrimeiro.length - 1);
		int opt2 = avaliar(donations, donations.length - 2);
		
		return Math.max(opt1, opt2);
	}
	
	private int avaliar(int[] values, int position) {
		
		if(position < 0) {
			return 0;
		}
		
		return Math.max(avaliar(values, position - 1), 
				avaliar(values, position - 2) + values[position]);
	}
	
	
	public static void main(String[] args) {
		BadNeighbors badNeighbors = new BadNeighbors();

		Instant now = Instant.now();
		
		int resultado = badNeighbors.maxDonations(new int[] {	94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  												6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  												52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72});

		System.out.println("resultado " + resultado);

		Duration time = Duration.between(now, Instant.now());
		
		System.out.println(time);
		
	}

}
