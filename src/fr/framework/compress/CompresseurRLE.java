package fr.framework.compress;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation concrète du compresseur utilisant l'algorithme RLE
 * (Run-Length Encoding).
 */
public class CompresseurRLE extends AbstractCompresseur {

    @Override
    protected int[] preparation(int[] data) {
        return data;
    }

    @Override
    protected int[] encodage(int[] data) {
        // Format : [valeur, nb_répétitions, valeur, nb_répétitions, ...]
        List<Integer> encoded = new ArrayList<>();
        int i = 0;
        while (i < data.length) {
            int count = 1;
            while (i + count < data.length && data[i + count] == data[i]) {
                count++;
            }
            encoded.add(data[i]);
            encoded.add(count);
            i += count;
        }
        return encoded.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    protected int[] finalisation(int[] data) {
        System.out.println("[RLE] Compression terminée, taille = " + data.length);
        return data;
    }
}
