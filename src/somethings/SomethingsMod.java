package somethings;

import mindustry.mod.Mod;
import somethings.content.STItems;
import somethings.content.STUnitTypes;
import somethings.content.STBlocks;
import somethings.content.STPlanets;
import somethings.content.STTechTree;

public class SomethingsMod extends Mod {
    @Override
    public void loadContent() {
        STItems.load();
        STUnitTypes.load();
        STBlocks.load();
        STPlanets.load();
        STTechTree.load();
    }
}
