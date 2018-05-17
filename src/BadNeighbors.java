import java.time.Duration;
import java.time.Instant;

public class BadNeighbors {
	private int max = 0; 
	
	public int maxDonations(int[] donations) {
		int[] mark = new int[donations.length];
		
		avaliar(mark, donations, 0);
		
		return max;
	}
	
	private void avaliar(int[] marks, int[] values, int position) {
		
		if (position >= marks.length) {
			
			if (marks[0] == 1 && marks[marks.length-1] == 1) {
				return;
			}
			
			int resultado = 0;
			
			for (int i = 0; i < marks.length; i++) {
				if( marks[i] == 1) {
					resultado += values[i];
				}
			}
			
			if (resultado > max) {
				max = resultado;
			}
				
			return;
		}
		
		avaliar(marks, values, position + 1);
		
		marks[position] = 1;
		
		avaliar(marks, values, position + 2);
				
		marks[position] = 0;
		
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
