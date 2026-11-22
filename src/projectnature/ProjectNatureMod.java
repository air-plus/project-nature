package projectnature;

import mindustry.mod.Mod;
import projectnature.content.PNItems;
import projectnature.content.PNTeam;
import projectnature.content.PNUnitTypes;
import projectnature.content.PNBlocks;
import projectnature.content.PNPlanets;
import projectnature.content.PNTechTree;

/**
 * Mod main class.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class ProjectNatureMod extends Mod {
    /** Load all packages. */
    @Override
    public void loadContent() {
        PNItems.load();
        PNTeam.load();
        PNUnitTypes.load();
        PNBlocks.load();
        PNPlanets.load();
        PNTechTree.load();
    }
}
