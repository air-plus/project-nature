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
        // TODO: Add tech tree.
        PNPlanets.terra.techTree = nodeRoot("terra", PNBlocks.coreArmored, () -> {});

        PNPlanets.luna.techTree = PNPlanets.terra.techTree;
    }
}
