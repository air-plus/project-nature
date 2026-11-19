package somethings.content;

import mindustry.content.Items;
import mindustry.type.ItemStack;

import static mindustry.content.TechTree.nodeRoot;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeProduce;

public class STechTree {
    public static void load() {
        SPlanets.terra.techTree = nodeRoot("terra", SBlocks.coreArmored, () -> {
            node(SBlocks.zAlloyMixer, ItemStack.with(
                Items.silicon, 1000,
                Items.surgeAlloy, 500
            ), () -> {});

            nodeProduce(SItems.zAlloy, () -> {});
        });

        SPlanets.luna.techTree = SPlanets.terra.techTree;
    }
}
