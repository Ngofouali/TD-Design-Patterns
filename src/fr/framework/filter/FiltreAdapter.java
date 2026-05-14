package fr.framework.filter;

import fr.framework.legacy.ImplNonStandard;

/**
 * Adapter : rend l'ancienne classe ImplNonStandard utilisable
 * comme une stratégie IFilter du Framework.
 */
public class FiltreAdapter implements IFilter {

    private final ImplNonStandard impl;
    private final String filterName;

    public FiltreAdapter(ImplNonStandard impl, String filterName) {
        this.impl = impl;
        this.filterName = filterName;
    }

    @Override
    public int[] filter(int[] data) {
        return impl.appliquerFiltre(filterName, data);
    }
}
