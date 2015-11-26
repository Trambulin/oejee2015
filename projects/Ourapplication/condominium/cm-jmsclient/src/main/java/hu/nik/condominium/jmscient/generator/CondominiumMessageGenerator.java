package hu.nik.condominium.jmscient.generator;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CondominiumMessageGenerator {

	private static final int NUMBER_OF_NUMBERS = 5;
	private static final int MAXIMUM_VALUE = 90;

	private final Random random;

	public CondominiumMessageGenerator(Random random) {
		this.random = random;
	}
	private static List<String> messages= Arrays.asList(
			"cs�t�r�s ",
			"nincs v�z ",
			"nincs g�z ",
			"nincs �ram ",
			"kapucseng� elromlott ",
			"a l�pcs�h�zban nem vil�g�t a l�mpa "
	);
	private static List<String> prio= Arrays.asList(
			", nagyon fontos ",
			", azonnali jav�t�st k�rek ",
			", halaszthatatlan",
			", k�rem jav�ts�k meg a h�ten ",
			", k�rem h�vjanak fel"
	);

	public String generate() {
		int min=0;
		int max1=5;
		int max2=4;
		int messageNum=min + (int)(Math.random()*max1);
		int prioNum=min + (int)(Math.random()*max2);

		int condominiumOwnerId=1 + (int)(Math.random()*3);
		return condominiumOwnerId+"|"+messages.get(messageNum)+prio.get(prioNum)+"|"+new Date().getTime();
	}

}
