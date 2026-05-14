package fr.framework.filter;

/**
 * Filtre de lissage par moyenne sur une fenêtre de taille 3.
 * Implémentation standard du pattern Strategy.
 */
public class FiltreMoyenne implements IFilter {

    @Override
    public int[] filter(int[] data) {
        int[] result = new int[data.length];
        for (int i = 1; i < data.length - 1; i++) {
            result[i] = (data[i - 1] + data[i] + data[i + 1]) / 3;
        }
        result[0] = data[0];
        result[data.length - 1] = data[data.length - 1];
        return result;
    }
}
