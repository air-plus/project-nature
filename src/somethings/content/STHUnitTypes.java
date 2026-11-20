package somethings.content;

import mindustry.type.UnitType;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.CommandAI;
import mindustry.type.weapons.RepairBeamWeapon;
import mindustry.entities.bullet.BulletType;

public class STHUnitTypes {
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
            itemCapacity = 20;

            legCount = 4;
            legLength = 12f;

            mineTier = 1;
            mineSpeed = 2f;
            buildSpeed = 2f;

            weapons.add(new RepairBeamWeapon() {{
                x = 0f;
                y = 0f;
                shootY = 0f;
                beamWidth = 0.8f;

                repairSpeed = 3f;

                bullet = new BulletType() {{
                    maxRange = 80f;
                }};
            }});
        }};
    }
}
