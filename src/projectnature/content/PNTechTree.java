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
            node(PNBlocks.enhanceMechanicalDrill, () -> {});

            node(PNBlocks.bacterium, () -> {});

            node(PNBlocks.logisticsDuct, () -> {
                node(PNBlocks.logisticsDuctRouter, () -> {
                    node(PNBlocks.logisticsOverflowDuct, () -> {});
                    node(PNBlocks.logisticsUnderflowDuct, () -> {});
                });

                node(PNBlocks.logisticsDuctBridge, () -> {});
            });

            node(PNBlocks.enhanceCombustionGenerator, () -> {
                node(PNBlocks.enhanceSolarPanel, () -> {
                    node(PNBlocks.largeEnhanceSolarPanel, () -> {});
                });

                node(PNBlocks.enhancePowerNode, () -> {
                    node(PNBlocks.enhancePowerNodeLarge, () -> {});
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
                });
            });
        });

        PNPlanets.luna.techTree = PNPlanets.terra.techTree;
    }
}
