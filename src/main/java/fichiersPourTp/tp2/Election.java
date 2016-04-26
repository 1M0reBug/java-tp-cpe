package fichiersPourTp.tp2;
import com.jordan_francois.scrutin.*;
import fichiersPourTp.tp1.*;

/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction � la POO (en Java)"
 * by Jamila Sam, Jean-C�dric Chappelier - EPFL 
 */


import javax.swing.text.StringContent;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.ListView;
import java.util.*;


/**
 * Classe pour tester la simulation
 */

public class Election {

	public static void main(String args[]) throws CloneNotSupportedException {

		Scrutin scrutin;
		int dateSrutin;	
		int population;
		int votants;
		int dateBulletin;
		List< HommePolitique> hommePolitiques;
		
		hommePolitiques = new ArrayList< HommePolitique>();
		hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Tarek", "Oxlama", "parti1"));
		hommePolitiques.add(new HommePolitique(Civilite.HOMME,"Nicolai", "Tarcozi", "parti2"));
		hommePolitiques.add(new HommePolitique(Civilite.HOMME,"Vlad", "Imirboutine", "parti3"));
		hommePolitiques.add(new HommePolitique(Civilite.FEMME,"Angel", "Anerckjl", "parti4"));
		
		scrutin = null;
		dateSrutin = 15;		
		population = 30;
		votants = 20;

		/**
		 * simulation de votes 
		 * - tous sont envoy�s � la m�me date 
		 * - Tous passent le check de date
		 * - 1 bulletins papier sur 2 passe check signature
		 */				
		System.out.println("\n\t1�re simulation \n" );
		dateBulletin = 13;	
		// simulation votes
		scrutin = simulerVotes(hommePolitiques, votants, dateSrutin, dateBulletin, population);
		// Traitement apr�s vote
		scrutin.countTheVotes();
		// Affichage r�sultat brut du scrutin
		System.out.println(scrutin);


		/**
		 * simulation de votes 
		 * - tous sont envoy�s � la m�me date invalide
		 * - Seuls les bulletins papier passent le check
		 * - 1 bulletins papier sur 2 passe check signature
		 */		
		System.out.println("\n\t2�me simulation \n" );
		dateBulletin = 16;		
		// simulation votes
		scrutin = simulerVotes(hommePolitiques, votants, dateSrutin, dateBulletin, population);	
		// Traitement apr�s vote
		scrutin.countTheVotes();
		// Affichage r�sultat brut du scrutin
		System.out.println(scrutin);

        System.out.println(scrutin.tauxParticipation());

		// 1.0
		List<Candidat> result = scrutin.getResult();

		// 1.1
		System.out.println(result);

		// 1.2
		Collections.sort(result);

		// 1.3
		Collections.sort(result, new CandidatPercentageComparator().reversed());
		System.out.println(result);

		// 1.4.1
		Collections.sort(result, new CandidatPercentageComparator());
		System.out.println(result);

		// 1.4.2
		result.sort(new CandidatPercentageComparator());
		System.out.println(result);

		// 1.5.1
		Candidat max = result.stream().max(new CandidatPercentageComparator()).get();

		// 1.5.2
		result.sort(new CandidatPercentageComparator().reversed());
		System.out.println(result.get(0));

		// -----------------------------

		// 2.0
		result = scrutin.getResult();

		// 2.1
		System.out.println(result.get(1));

		// 2.2
		System.out.println(
				result.indexOf( Collections.max(result, new CandidatPercentageComparator()) )
		);

		// 2.3
		List<Candidat> clone = new ArrayList<Candidat>(result);

		// 2.4.1
		for(Candidat c : result) {
			if(c.getPourcentage() < 0.2) {
				clone.remove(c);
			}
		}

		System.out.println(clone);

		// 2.4.1
		clone = new ArrayList<Candidat>(result);
		Iterator<Candidat> iterator = clone.iterator();
		while(iterator.hasNext()) {
			Candidat courant = iterator.next();
			if(courant.getPourcentage() < 0.2) {
				clone.remove(iterator);
			}
		}

		System.out.println(clone);

		// 2.5
		Iterator<Candidat> iterator1 = result.iterator();
		while(iterator1.hasNext()) {
			Candidat courant = iterator1.next();
			if(clone.indexOf(courant) < 0) {
				result.remove(courant);
			}
		}

		// 2.6.1
		if(result.equals(clone)) {
			System.out.println("Les deux listes contiennent les mêmes éléments");
		}

		// 2.6.2
		if(result.containsAll(clone) && clone.containsAll(result)) {
			System.out.println("Les deux listes contiennent les mêmes éléments");
		}

		// 2.7
		clone.clear();

		// 2.8.1
		if(clone.isEmpty()) {
			System.out.println("La liste clone est vide");
		}

		// 2.8.2
		if(clone.equals(new ArrayList<>())) {
			System.out.println("La liste clone est vide");
		}

		// -------------------------------------------

		// 3.0
		result = scrutin.getResult();

		// 3.1
		Map<Civilite, List<String>> map = createMap(result);

		// 3.2
		Set<Map.Entry<Civilite, List<String>>> set = map.entrySet();

		// 3.3
		System.out.println(set);

		// 3.4
		System.out.println(displayMap(map));

		// 3.5
		System.out.println("Nombre d'hommes : " + map.get(Civilite.HOMME).size());

		// 3.6
		Set<Civilite> civilites = map.keySet();
		System.out.println(civilites);

		// 3.7
		map.remove(Civilite.FEMME);
		System.out.println(map);

		// 3.8
		System.out.println(civilites);

		// 3.10
		TreeSet<Civilite> civSet = new TreeSet<>();
		civSet.add(Civilite.FEMME);
		civSet.add(Civilite.HOMME);

		// 3.11
		SortedSet<Civilite> sortedSet = civSet.descendingSet();
		System.out.println(sortedSet);

		// 3.12
		civSet.remove(Civilite.FEMME);

		System.out.println(sortedSet);
		System.out.println(civSet);



    }

	private static Map<Civilite, List<String>> createMap(List<Candidat> candidats) {
		Map<Civilite, List<String>> map = new TreeMap<>();

		map.put(Civilite.FEMME, new LinkedList<String>());
		map.put(Civilite.HOMME, new LinkedList<String>());

		candidats.stream().forEach(e -> {
			map.get(e.getCandidatScrutin().getCiviliteCandidat()).add(e.getCandidatScrutin().getNomCandidat());
		});

		return map;
	}

	private static String displayMap(Map<Civilite, List<String>> map) {
		StringBuffer ret = new StringBuffer("");
		Set<Civilite> keys = map.keySet();
		for(Civilite key : keys) {
			ret.append(key + " :\n");
			for(String nom : map.get(key)) {
				ret.append("    " + nom + "\n");
			}
		}

		return ret.toString();
	}


	private static Scrutin simulerVotes(List< HommePolitique> hommePolitiques, int votants,
			int dateSrutin, int dateBulletin, int population) throws CloneNotSupportedException {

		Scrutin scrutin = new Scrutin(hommePolitiques, population, dateSrutin);

		// ou bien
		//		scrutin = new Scrutin(population, dateSrutin);
		//		for (HommePolitique hommePolitique : hommePolitiques )
		//			scrutin.addCandidat(hommePolitique);

		//System.out.println(scrutin);

		if (hommePolitiques!=null){
			for (int i = 0; i < votants; ++i) {

				int candNum = Utils.randomInt(hommePolitiques.size());
				Vote vote = null;

				// bulletins papiers impairs sont sign�s, pairs sont non sign�s
				boolean signature = true;
				if ((i % 2) == 0) {
					signature = false;
				}

				// simulation cr�ation bulletins de vote
				switch (i % 3) {
				case 0:{
					vote = new BulletinElectronique(hommePolitiques.get(candNum), dateBulletin, dateSrutin);			
					break;
				}			
				case 1:{
					vote = new BulletinPapier(hommePolitiques.get(candNum), dateBulletin, dateSrutin, signature);
					break;
				}
				case 2:{
					vote = new BulletinCourrier(hommePolitiques.get(candNum), dateBulletin, dateSrutin, signature);
				}
				default: // nothing			
				}
			//	System.out.println(vote);		// pour v�rif ToString() des classes qui impl�mentent Vote
				scrutin.addBulletin(vote);				
			}
		}
		return scrutin;
	}
}


/**
 * Classe utilitaire
 *
 */
class Utils {

	private static final Random RANDOM = new Random();

	// initialise le g�n�rateur de nombres al�atoires
	public static void setSeed(long seed) {
		RANDOM.setSeed(seed);
	}

	// g�n�re un entier entre 0 et max (max non compris)
	public static int randomInt(int max) {
		return RANDOM.nextInt(max);
	}
}