import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class BadNeighbors {
	private int cache[] = new int[40];
	
	public int maxDonations(int[] donations) {
		int[] semOPrimeiro = Arrays.copyOfRange(donations, 1, donations.length);
		
		createCacheFrom(semOPrimeiro);
		
		int opt1 = cache[semOPrimeiro.length-1];

		createCacheFrom(donations);
		
		int opt2 = cache[donations.length - 2];
		
		return Math.max(opt1, opt2);
	}
	
	private void createCacheFrom(int[] values) {
		
		for (int i = 0; i < values.length; i++) {
			
			
			if (i == 0) {
				cache[i] = values[i];
				continue;
			}
			
			if (i == 1) {
				cache[i] = Math.max(cache[i-1], values[i]);
				continue;
			}
			
			cache[i] = Math.max(cache[i-1], cache[i-2] + values[i]);
		}
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
