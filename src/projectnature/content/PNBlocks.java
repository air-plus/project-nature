package projectnature.content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
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
    public static Block oreIron, coreArmored;

    /** Load all blocks. */
    public static void load() {
        oreIron = new OreBlock(PNItems.iron) {{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};

        coreArmored = new CoreBlock("core-armored") {{
            alwaysUnlocked = true;
            health = 12000;
            size = 4;
            itemCapacity = 8000;
            requirements(Category.effect, ItemStack.with(
                Items.copper, 2000,
                Items.lead, 1000
            ));

            unitCapModifier = 16;
            unitType = PNUnitTypes.delta;
        }};
    }
}
