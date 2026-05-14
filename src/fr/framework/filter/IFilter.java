package fr.framework.filter;

/**
 * Interface du pattern Strategy.
 * Toute implémentation de filtre doit respecter ce contrat.
 */
public interface IFilter {
    int[] filter(int[] data);
}
