package somethings.content;

import mindustry.type.UnitType;
import mindustry.gen.LegsUnit;

public class STUnitTypes {
    public static UnitType hypha;

    public static void load() {
        hypha = new UnitType("hypha") {{
            constructor = LegsUnit::create;

            isEnemy = false;
            health = 150f;
            hitSize = 8f;
            speed = 3f;
            accel = 0.1f;
            drag = 0.05f;
            rotateSpeed = 15f;
            legCount = 4;
            legLength = 12f;
            mineTier = 1;
            mineSpeed = 2f;
            itemCapacity = 20;
        }};
    }
}
