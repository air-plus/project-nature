package projectnature.content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.consumer.ConsumeLiquidFlammable;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.type.ItemStack;
import mindustry.type.Category;
import mindustry.content.Items;

/**
 * Blocks.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class PNBlocks {
    /** All blocks. */
    public static Block oreIron;
    public static Block stgGenerator, iterativePowerNode;
    public static Block ironWall, ironWallLarge;
    public static Block coreArmored;

    /** Load all blocks. */
    public static void load() {
        oreIron = new OreBlock(PNItems.iron) {{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};

        stgGenerator = new ConsumeGenerator("stg-generator") {{
            health = 20;
            size = 1;
            requirements(Category.power, ItemStack.with(
                Items.copper, 20,
                PNItems.iron, 10
            ));

            itemDuration = 60;
            powerProduction = 10;
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

        ironWall = new Wall("iron-wall") {{
            health = 80 * 4;
            size = 1;
            requirements(Category.defense, ItemStack.with(
                PNItems.iron, 6
            ));
        }};

        ironWallLargw = new Wall("iron-wall-large") {{
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
