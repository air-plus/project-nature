package somethings.content;

import mindustry.content.Items;
import mindustry.type.ItemStack;

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
        STHPlanets.terra.techTree = nodeRoot("terra", STHBlocks.coreArmored, () -> {
            node(STHBlocks.zAlloyMixer, ItemStack.with(
                Items.silicon, 1000,
                Items.surgeAlloy, 500
            ), () -> {});

            nodeProduce(STHItems.zAlloy, () -> {});
        });

        STHPlanets.luna.techTree = STHPlanets.terra.techTree;
    }
}
