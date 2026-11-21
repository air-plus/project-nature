package somethings.content;

import mindustry.type.Item;
import mindustry.graphics.Pal;

/**
 * Items.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class STHItems {
    /** All items. */
    public static Item zAlloy;

    /** Load all items. */
    public static void load() {
        zAlloy = new Item("z-alloy", Pal.accent) {{
            charge = 1f;
            cost = 1.25f;
            explosiveness = 0.7f;
            flammability = 0.3f;
        }};
    }
}
