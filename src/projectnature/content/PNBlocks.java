package projectnature.content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.graphics.Pal;
import mindustry.world.draw.DrawTurret;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.distribution.DuctRouter;
import mindustry.world.blocks.distribution.OverflowDuct;
import mindustry.world.blocks.distribution.DuctBridge;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.consumers.ConsumeLiquidFlammable;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.type.ItemStack;
import mindustry.type.Category;
import mindustry.content.Items;
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

    oreIron,

    bacterium,

    iterativeMechanicalDrill,

    copperDuctRouter, copperOverflowDuct, copperUnderflowDuct,
    copperDuctBridge, copperDuct,

    iterativeCombustionGenerator, iterativePowerNode, iterativePowerNodeLarge,
    iterativeSolarPanel, largeIterativeSolarPanel,

    ironWall, ironWallLarge,

    coreArmored;

    /** Load all blocks. */
    public static void load() {
        oreIron = new OreBlock(PNItems.iron) {{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};

        iterativeMechanicalDrill = new Drill("iterative-mechanical-drill") {{
            health = 160;
            size = 2;
            requirements(Category.production, ItemStack.with(
                Items.copper, 12
            ));

            tier = 2;
            drillTime = 640;
            consumePower(0.1f);
            consumeLiquid(Liquids.water, 0.05f).boost();
        }};

        bacterium = new ItemTurret("bacterium") {{
            size = 2;
            health = 400 * size * size;
            requirements(Category.turret, ItemStack.with(
                Items.copper, 30
            ));

            ammo(
                Items.copper, new BasicBulletType(2.5f, 11) {{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                    ammoMultiplier = 2;
                }}
            );
            drawer = new DrawTurret() {{
                parts.add(new RegionPart("-barrel") {{
                    progress = PartProgress.recoil;
                    x = 3f;
                    moveY = -2f;
                    heatColor = Pal.turretHeat;
                    mirror = true;
                }});
            }};
            recoil = 2f;
            shootY = 6f;
            consumePower(1f);
            coolant = consumeCoolant(0.1f);
        }};

        copperDuctRouter = new DuctRouter("copper-duct-router") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                Items.copper, 4
            ));

            speed = 4f;
        }};

        copperOverflowDuct = new OverflowDuct("copper-overflow-duct") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                Items.copper, 4
            ));

            speed = 4f;
        }};

        copperUnderflowDuct = new OverflowDuct("copper-underflow-duct") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                Items.copper, 4
            ));

            speed = 4f;
            invert = true;
        }};

        copperDuctBridge = new DuctBridge("copper-duct-bridge") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                Items.copper, 6
            ));

            speed = 4f;
            range = 6;
            buildCostMultiplier = 2f;
        }};

        copperDuct = new Duct("copper-duct") {{
            health = 40;
            size = 1;
            requirements(Category.distribution, ItemStack.with(
                Items.copper, 1
            ));

            speed = 4f;
            bridgeReplacement = copperDuctBridge;
        }};

        iterativeCombustionGenerator = new ConsumeGenerator("iterative-combustion-generator") {{
            health = 20;
            size = 1;
            requirements(Category.power, ItemStack.with(
                Items.copper, 20,
                PNItems.iron, 10
            ));

            itemDuration = 60f;
            powerProduction = 10f;
            consume(new ConsumeItemFlammable());
            consume(new ConsumeLiquidFlammable());
        }};

        iterativePowerNode = new PowerNode("iterative-power-node") {{
            health = 10;
            size = 1;
            requirements(Category.power, ItemStack.with(
                Items.copper, 2,
                PNItems.iron, 3
            ));

            maxNodes = 10;
            laserRange = 10;
            consumePowerBuffered(400f);
        }};

        iterativePowerNodeLarge = new PowerNode("iterative-power-node-large") {{
            health = 20;
            size = 2;
            requirements(Category.power, ItemStack.with(
                Items.copper, 8,
                PNItems.iron, 12
            ));

            maxNodes = 15;
            laserRange = 20;
            consumePowerBuffered(4000f);
        }};

        iterativeSolarPanel = new SolarGenerator("iterative-solar-panel") {{
            health = 40;
            size = 1;
            requirements(Category.power, ItemStack.with(
                Items.copper, 10,
                PNItems.iron, 5
            ));

            powerProduction = 0.12f;
        }};

        largeIterativeSolarPanel = new SolarGenerator("iterative-solar-panel-large") {{
            health = 400;
            size = 3;
            requirements(Category.power, ItemStack.with(
                Items.copper, 80,
                PNItems.iron, 60
            ));

            powerProduction = 1.6f;
        }};

        ironWall = new Wall("iron-wall") {{
            health = 80 * 4;
            size = 1;
            requirements(Category.defense, ItemStack.with(
                PNItems.iron, 6
            ));
        }};

        ironWallLarge = new Wall("iron-wall-large") {{
            health = 80 * 4 * 4;
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
                Items.copper, 2000,
                PNItems.iron, 1000
            ));

            unitCapModifier = 16;
            unitType = PNUnitTypes.delta;
        }};
    }
}
