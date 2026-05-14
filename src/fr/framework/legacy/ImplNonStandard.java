package fr.framework.legacy;

/**
 * Ancienne implémentation héritée, dont la signature est incompatible
 * avec l'interface IFilter du Framework.
 * On ne peut pas modifier son code source : c'est précisément le cas
 * d'usage du pattern Adapter.
 */
public class ImplNonStandard {

    public int[] appliquerFiltre(String filterName, int[] data) {
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] / 2; // exemple : assombrissement
        }
        System.out.println("[Legacy] Filtre '" + filterName + "' appliqué.");
        return result;
    }
}
