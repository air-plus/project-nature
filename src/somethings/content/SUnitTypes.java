package somethings.content;

import mindustry.type.UnitType;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.CommandAI;

public class SUnitTypes {
    public static UnitType delta;

    public static void load() {
        delta = new UnitType("delta") {{
            controller = u -> u.team.isAI() ? new BuilderAI(true, 400f) : new CommandAI();
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
