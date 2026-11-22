package projectnature.content;

import static mindustry.content.TechTree.nodeRoot;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeProduce;

/**
 * Tech tree.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class PNTechTree {
    /** Load all tech tree. */
    public static void load() {
        PNPlanets.terra.techTree = nodeRoot("terra", PNBlocks.coreArmored, () -> {
            nodeProduce(PNItems.iron, () -> {});
        });

        PNPlanets.luna.techTree = PNPlanets.terra.techTree;
    }
}
