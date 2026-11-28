package projectnature.content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.world.draw.DrawTurret;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.distribution.DuctRouter;
import mindustry.world.blocks.distribution.OverflowDuct;
import mindustry.world.blocks.distribution.DuctBridge;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.meta.BlockGroup;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.consumers.ConsumeLiquidFlammable;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.type.ItemStack;
import mindustry.type.Category;
import mindustry.content.Liquids;

/**
 * Blocks.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class PNBlocks {
    /** All blocks. */
    public static Block

    oreSilver, oreIron,

    bacterium,

    enhanceMechanicalDrill,

    logisticsDuctRouter, logisticsOverflowDuct, logisticsUnderflowDuct,
    logisticsDuctBridge, logisticsDuct, logisticsUnloader,

    enhanceCombustionGenerator, enhancePowerNode, enhancePowerNodeLarge,
    enhanceSolarPanel, enhanceSolarPanelLarge,

    silverWall, silverWallLarge, ironWall,
    ironWallLarge,

    coreArmored;

    /** Load all blocks. */
    public static void load() {
        oreSilver = new OreBlock(PNItems.silver) {{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};

        oreIron = new OreBlock(PNItems.iron) {{
            oreDefault = true;
            oreThreshold = 0.828f;
            oreScale = 23.952381f;
        }};

        enhanceMechanicalDrill = new Drill("enhance-mechanical-drill") {{
            health = 160;
            size = 2;
            requirements(Category.production, ItemStack.with(
                PNItems.silver, 12
            ));

            tier = 2;
            drillTime = 640;
            consumePower(0.1f);
            consumeLiquid(Liquids.water, 0.05f).boost();
        }};

        bacterium = new ItemTurret("bacterium") {{
            health = 1600;
            size = 2;
            requirements(Category.turret, ItemStack.with(
                PNItems.silver, 30
            ));

            ammo(
                PNItems.silver, new BasicBulletType(2.5f, 11) {{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                    ammoMultiplier = 2;
                }}
            );
            drawer = new DrawTurret() {{
                for (int i = 0; i < 2; i++) {
                    parts.add(
                        new RegionPart("-barrel-" + (i == 0 ? "l" : "r")) {{
                            progress = PartProgress.recoil;
                            recoilIndex = i;
                            under = true;
                            moveY = -2f;
                            x = (i == 0 ? -2 : 2);
                        }}
                    );
                }
            }};
            range = 160;
            shoot = new ShootAlternate(3f);
            rotateSpeed = 10f;
            recoils = 2;
            recoil = 0.2f;
            shootY = 6f;
            consumePower(1f);
            coolant = consumeCoolant(0.1f);
        }};

        logisticsDuctRouter = new DuctRouter("logistics-duct-router") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                PNItems.silver, 4
            ));

            speed = 4f;
        }};

        logisticsOverflowDuct = new OverflowDuct("logistics-overflow-duct") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                PNItems.silver, 4
            ));

            speed = 4f;
        }};

        logisticsUnderflowDuct = new OverflowDuct("logistics-underflow-duct") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                PNItems.silver, 4
            ));

            speed = 4f;
            invert = true;
        }};

        logisticsDuctBridge = new DuctBridge("logistics-duct-bridge") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                PNItems.silver, 6
            ));

            speed = 4f;
            range = 6;
            buildCostMultiplier = 2f;
        }};

        logisticsDuct = new Duct("logistics-duct") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                PNItems.silver, 1
            ));

            speed = 4f;
            bridgeReplacement = logisticsDuctBridge;
        }};

        // TODO: Change `PNItems.iron` to expensive material.
        logisticsUnloader = new Unloader("logistics-unloader") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                PNItems.silver, 25,
                PNItems.iron, 30
            ));

            speed = 60f / 11f;
            group = BlockGroup.transportation;
        }};

        enhanceCombustionGenerator = new ConsumeGenerator("enhance-combustion-generator") {{
            health = 20;
            size = 1;
            requirements(Category.power, ItemStack.with(
                PNItems.silver, 20,
                PNItems.iron, 10
            ));

            itemDuration = 60f;
            powerProduction = 10f;
            consume(new ConsumeItemFlammable());
            consume(new ConsumeLiquidFlammable());
        }};

        enhancePowerNode = new PowerNode("enhance-power-node") {{
            health = 10;
            size = 1;
            requirements(Category.power, ItemStack.with(
                PNItems.silver, 2,
                PNItems.iron, 3
            ));

            maxNodes = 10;
            laserRange = 10;
            consumePowerBuffered(400f);
        }};

        enhancePowerNodeLarge = new PowerNode("enhance-power-node-large") {{
            health = 20;
            size = 2;
            requirements(Category.power, ItemStack.with(
                PNItems.silver, 8,
                PNItems.iron, 12
            ));

            maxNodes = 15;
            laserRange = 20;
            consumePowerBuffered(4000f);
        }};

        enhanceSolarPanel = new SolarGenerator("enhance-solar-panel") {{
            health = 40;
            size = 1;
            requirements(Category.power, ItemStack.with(
                PNItems.silver, 10,
                PNItems.iron, 5
            ));

            powerProduction = 0.12f;
        }};

        enhanceSolarPanelLarge = new SolarGenerator("enhance-solar-panel-large") {{
            health = 400;
            size = 3;
            requirements(Category.power, ItemStack.with(
                PNItems.silver, 80,
                PNItems.iron, 60
            ));

            powerProduction = 1.6f;
        }};

        silverWall = new Wall("silver-wall") {{
            health = 320;
            size = 1;
            requirements(Category.defense, ItemStack.with(
                PNItems.silver, 6
            ));
        }};

        silverWallLarge = new Wall("silver-wall-large") {{
            health = 1280;
            size = 2;
            requirements(Category.defense, ItemStack.with(
                PNItems.silver, 24
            ));
        }};

        ironWall = new Wall("iron-wall") {{
            health = 320;
            size = 1;
            requirements(Category.defense, ItemStack.with(
                PNItems.iron, 6
            ));
        }};

        ironWallLarge = new Wall("iron-wall-large") {{
            health = 1280;
            size = 2;
            requirements(Category.defense, ItemStack.with(
                PNItems.iron, 24
            ));
        }};

        coreArmored = new CoreBlock("core-armored") {{
            alwaysUnlocked = true;
            health = 12000;
            size = 4;
            itemCapacity = 8000;
            requirements(Category.effect, ItemStack.with(
                PNItems.silver, 2000,
                PNItems.iron, 1000
            ));

            unitCapModifier = 16;
            unitType = PNUnitTypes.delta;
        }};
    }
}
