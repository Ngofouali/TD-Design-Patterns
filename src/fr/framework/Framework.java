package fr.framework;

import fr.framework.compress.AbstractCompresseur;
import fr.framework.filter.IFilter;

/**
 * Façade du Framework.
 * Délègue le filtrage à une Strategy (IFilter) et la compression
 * à une classe abstraite (Template Method).
 */
public class Framework {

    private IFilter filtreStrategy;
    private AbstractCompresseur compresseur;

    public void setFilterStrategy(IFilter filtreStrategy) {
        this.filtreStrategy = filtreStrategy;
    }

    public void setCompresseur(AbstractCompresseur compresseur) {
        this.compresseur = compresseur;
    }

    public int[] filter(int[] data) {
        if (filtreStrategy == null) {
            throw new IllegalStateException("Aucune stratégie de filtre définie.");
        }
        return filtreStrategy.filter(data);
    }

    public int[] compresser(int[] data) {
        if (compresseur == null) {
            throw new IllegalStateException("Aucun compresseur défini.");
        }
        return compresseur.compresser(data);
    }
}
