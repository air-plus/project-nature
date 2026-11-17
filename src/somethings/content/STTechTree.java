package somethings.content;

import mindustry.content.Items;
import mindustry.type.ItemStack;

import static mindustry.content.TechTree.nodeRoot;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeProduce;

public class STTechTree {
    public static void load() {
        STPlanets.terra.techTree = nodeRoot("terra", STBlocks.coreArmored, () -> {
            node(STBlocks.zAlloyMixer, ItemStack.with(
                Items.silicon, 1000,
                Items.surgeAlloy, 500
            ), () -> {});

            nodeProduce(STItems.zAlloy, () -> {});
        });

        STPlanets.luna.techTree = STPlanets.terra.techTree;
    }
}
