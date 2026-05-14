package fr.framework.compress;

/**
 * Pattern Template Method.
 * La méthode compresser() définit le squelette de l'algorithme.
 * Les trois étapes sont déléguées aux sous-classes concrètes.
 */
public abstract class AbstractCompresseur {

    /** Méthode template : ordonne les étapes de la compression. */
    public final int[] compresser(int[] data) {
        int[] prep = preparation(data);
        int[] encode = encodage(prep);
        return finalisation(encode);
    }

    protected abstract int[] preparation(int[] data);
    protected abstract int[] encodage(int[] data);
    protected abstract int[] finalisation(int[] data);
}
