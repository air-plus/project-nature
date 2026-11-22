package somethings.content;

import static mindustry.content.TechTree.nodeRoot;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeProduce;

/**
 * Tech tree.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class STHTechTree {
    /** Load all tech tree. */
    public static void load() {
        // TODO: Add tech tree.
        STHPlanets.terra.techTree = nodeRoot("terra", STHBlocks.coreArmored, () -> {});

        STHPlanets.luna.techTree = STHPlanets.terra.techTree;
    }
}
