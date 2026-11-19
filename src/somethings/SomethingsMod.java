package somethings;

import mindustry.mod.Mod;
import somethings.content.SItems;
import somethings.content.SUnitTypes;
import somethings.content.SBlocks;
import somethings.content.SPlanets;
import somethings.content.STechTree;

public class SomethingsMod extends Mod {
    @Override
    public void loadContent() {
        SItems.load();
        SUnitTypes.load();
        SBlocks.load();
        SPlanets.load();
        STechTree.load();
    }
}
