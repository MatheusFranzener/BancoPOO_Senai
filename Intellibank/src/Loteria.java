import java.util.ArrayList;
import java.util.Random;

public class Loteria {

	Random random = new Random();
	
	public ArrayList<Integer> numerosS = new ArrayList<Integer>();
	public ArrayList<Integer> numerosP = new ArrayList<Integer>();
	
	public int numAcertos = 0;
	public double premio = 10000;

	public void sortearNumeros() {
		for (int i = 0; i < 6; i++) {
			numerosS.add(random.nextInt(60));
		}
	}

	public void compararNumeros() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (numerosP.get(i) == numerosS.get(j)) {
					numAcertos++;
				}
			}
		}

		if (numAcertos == 3) {
			premio *= 0.25;
		} else if (numAcertos == 4) {
			premio *= 0.50;
		} else if (numAcertos == 5) {
			premio *= 0.75;
		} else if (numAcertos == 6) {
			premio *= 1;
		} else {
			premio = 0;
		}
	}

}
