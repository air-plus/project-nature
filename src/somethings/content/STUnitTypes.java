package somethings.content;

import mindustry.type.UnitType;
import mindustry.entities.units.LegsUnit;
import mindustry.entities.EntityMapping;

public class STUnitTypes {
    public static UnitType hypha;

    public static void load() {
        hypha = new UnitType("hypha") {{
            constructor = LegsUnit::create;
            EntityMapping.nameMap.put(name, constructor);

            isEnemy = false;
            health = 150f;
            hitSize = 8f;
            speed = 3f;
            accel = 0.1f;
            drag = 0.05f;
            rotateSpeed = 15f;
        }};
    }
}
