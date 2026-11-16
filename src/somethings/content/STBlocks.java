package somethings.content;

import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.type.ItemStack;
import mindustry.type.Category;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawArcSmelt;

public class STBlocks {
    public static Block coreShardTe, zAlloyMixer;

    public static void load() {
        coreShardTe = new CoreBlock("core-shard-te") {{
            health = 12000;
            size = 3;
            itemCapacity = 8000;
            unitCapModifier = 12;
            unitType = STUnitTypes.hypha;
            alwaysUnlocked = true;
            isFirstTier = true;

            requirements(Category.effect, ItemStack.with(
                Items.copper, 2000,
                Items.lead, 1000
            ));
        }};

        zAlloyMixer = new GenericCrafter("z-alloy-mixer") {{
            health = 8000;
            size = 3;
            craftTime = 120f;

            requirements(Category.crafting, ItemStack.with(
                Items.copper, 4000,
                Items.lead, 4000,
                Items.silicon, 2000,
                Items.surgeAlloy, 800
            ));
            consumeItems(ItemStack.with(
                Items.surgeAlloy, 2,
                Items.silicon, 1
            ));
            consumeLiquid(Liquids.slag, 2f);
            consumePower(1.8f);

            outputItem = new ItemStack(STItems.zAlloy, 2);
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawArcSmelt()
            );
        }};
    }
}
