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
            node(PNBlocks.enhanceMechanicalDrill, () -> {});

            node(PNBlocks.bacterium, () -> {});

            node(PNBlocks.logisticsDuct, () -> {
                node(PNBlocks.logisticsDuctRouter, () -> {
                    node(PNBlocks.logisticsOverflowDuct, () -> {});
                    node(PNBlocks.logisticsUnderflowDuct, () -> {});
                });

                node(PNBlocks.logisticsDuctBridge, () -> {});

                node(PNBlocks.logisticsUnloader, () -> {});
            });

            node(PNBlocks.enhanceCombustionGenerator, () -> {
                node(PNBlocks.enhanceSolarPanel, () -> {
                    node(PNBlocks.enhanceSolarPanelLarge, () -> {});
                });

                node(PNBlocks.enhancePowerNode, () -> {
                    node(PNBlocks.enhancePowerNodeLarge, () -> {});
                });
            });

            node(PNBlocks.silverWall, () -> {
                node(PNBlocks.ironWall, () -> {
                    node(PNBlocks.ironWallLarge, () -> {});
                });

                node(PNBlocks.silverWallLarge);
            });

            nodeProduce(PNItems.silver, () -> {
                nodeProduce(PNItems.iron, () -> {});
            });
        });

        PNPlanets.luna.techTree = PNPlanets.terra.techTree;
    }
}
