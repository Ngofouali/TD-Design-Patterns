package fr.framework.filter;

import java.util.Arrays;

/**
 * Filtre médian sur une fenêtre de taille 3.
 * Implémentation standard du pattern Strategy.
 */
public class FiltreMedian implements IFilter {

    @Override
    public int[] filter(int[] data) {
        int[] result = new int[data.length];
        for (int i = 1; i < data.length - 1; i++) {
            int[] window = { data[i - 1], data[i], data[i + 1] };
            Arrays.sort(window);
            result[i] = window[1];
        }
        result[0] = data[0];
        result[data.length - 1] = data[data.length - 1];
        return result;
    }
}
