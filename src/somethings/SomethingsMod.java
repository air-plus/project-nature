package somethings;

import mindustry.mod.Mod;
import somethings.content.STHItems;
import somethings.content.STHUnitTypes;
import somethings.content.STHBlocks;
import somethings.content.STHPlanets;
import somethings.content.STHTechTree;

/**
 * Mod main class.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class SomethingsMod extends Mod {
    /** Load all packages. */
    @Override
    public void loadContent() {
        STHItems.load();
        STHUnitTypes.load();
        STHBlocks.load();
        STHPlanets.load();
        STHTechTree.load();
    }
}
