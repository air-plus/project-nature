package somethings;

import mindustry.mod.Mod;
import somethings.content.STHItems;
import somethings.content.STHUnitTypes;
import somethings.content.STHBlocks;
import somethings.content.STHPlanets;
import somethings.content.STHTechTree;

public class SomethingsMod extends Mod {
    @Override
    public void loadContent() {
        STHItems.load();
        STHUnitTypes.load();
        STHBlocks.load();
        STHPlanets.load();
        STHTechTree.load();
    }
}
