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
			"csõtörés ",
			"nincs víz ",
			"nincs gáz ",
			"nincs áram ",
			"kapucsengõ elromlott ",
			"a lépcsõházban nem világít a lámpa "
	);
	private static List<String> prio= Arrays.asList(
			", nagyon fontos ",
			", azonnali javítást kérek ",
			", halaszthatatlan",
			", kérem javítsák meg a héten ",
			", kérem hívjanak fel"
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
