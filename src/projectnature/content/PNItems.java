package projectnature.content;

import mindustry.type.Item;
import arc.graphics.Color;

/**
 * Items.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class PNItems {
    /** All items. */
    public static Item
    silver, iron;

    /** Load all items. */
    public static void load() {
        silver = new Item("silver", Color.valueOf("c0c0c0")) {{
            hardness = 1;
            cost = 0.5f;
        }};

        iron = new Item("iron", Color.valueOf("c0c0c0")) {{
            hardness = 1;
            cost = 0.7f;
        }};
    }
}
