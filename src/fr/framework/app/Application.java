package fr.framework.app;

import fr.framework.Framework;
import fr.framework.compress.AbstractCompresseur;
import fr.framework.filter.FiltreAdapter;
import fr.framework.filter.IFilter;
import fr.framework.legacy.ImplNonStandard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Application cliente du Framework.
 * L'utilisateur saisit dynamiquement le nom complet des classes
 * d'implémentation à utiliser. Le Framework les instancie via la
 * réflexion Java.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Framework framework = new Framework();

        System.out.print("Nom complet de la classe IFilter à utiliser : ");
        String filterClass = sc.nextLine().trim();
        // Exemples :
        //   fr.framework.filter.FiltreMoyenne
        //   fr.framework.filter.FiltreMedian

        System.out.print("Nom complet de la classe AbstractCompresseur à utiliser : ");
        String compClass = sc.nextLine().trim();
        // Exemple : fr.framework.compress.CompresseurRLE

        // Instanciation dynamique via réflexion
        IFilter filter = (IFilter) Class.forName(filterClass)
                                        .getDeclaredConstructor()
                                        .newInstance();
        AbstractCompresseur compresseur = (AbstractCompresseur) Class.forName(compClass)
                                        .getDeclaredConstructor()
                                        .newInstance();

        framework.setFilterStrategy(filter);
        framework.setCompresseur(compresseur);

        int[] image = { 10, 10, 10, 20, 20, 30, 30, 30, 30, 40 };

        System.out.println("Image originale  : " + Arrays.toString(image));

        int[] filtree = framework.filter(image);
        System.out.println("Image filtrée    : " + Arrays.toString(filtree));

        int[] compressee = framework.compresser(filtree);
        System.out.println("Image compressée : " + Arrays.toString(compressee));

        // Changement dynamique de stratégie via Adapter
        framework.setFilterStrategy(
                new FiltreAdapter(new ImplNonStandard(), "assombrir")
        );
        System.out.println("Via Adapter      : " + Arrays.toString(framework.filter(image)));

        sc.close();
    }
}
