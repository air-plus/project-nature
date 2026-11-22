package projectnature.content;

import mindustry.content.Items;
import mindustry.content.Blocks;
import mindustry.content.Liquids;

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
            node(PNBlocks.iterativeMechanicalDrill, () -> {});

            node(PNBlocks.bacterium, () -> {});

            node(PNBlocks.copperDuct, () -> {
                node(PNBlocks.copperDuctRouter, () -> {
                    node(PNBlocks.copperOverflowDuct, () -> {});
                    node(PNBlocks.copperUnderflowDuct, () -> {});
                });

                node(PNBlocks.copperDuctBridge, () -> {});
            });

            node(PNBlocks.iterativeCombustionGenerator, () -> {
                node(PNBlocks.iterativeSolarPanel, () -> {
                    node(PNBlocks.largeIterativeSolarPanel, () -> {});
                });

                node(PNBlocks.iterativePowerNode, () -> {
                    node(PNBlocks.iterativePowerNodeLarge, () -> {});
                });
            });

            node(Blocks.copperWall, () -> {
                node(PNBlocks.ironWall, () -> {
                    node(PNBlocks.ironWallLarge, () -> {});
                });

                node(Blocks.copperWallLarge);
            });

            nodeProduce(Items.copper, () -> {
                nodeProduce(PNItems.iron, () -> {
                    nodeProduce(Items.coal, () -> {});
                    nodeProduce(Items.sand, () -> {});
                    nodeProduce(Liquids.water, () -> {});
                });
            });
        });

        PNPlanets.luna.techTree = PNPlanets.terra.techTree;
    }
}
