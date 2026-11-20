package somethings.content;

import mindustry.type.UnitType;
import mindustry.gen.LegsUnit;
import mindustry.ai.types.BuilderAI;
import mindustry.type.weapons.RepairBeamWeapon;
import mindustry.entities.bullet.BulletType;

public class STHUnitTypes {
    public static UnitType delta;

    public static void load() {
        delta = new UnitType("delta") {{
            constructor = LegsUnit::create;
            coreUnitDock = true;
            aiController = () -> new BuilderAI(true, 400f);
            isEnemy = false;

            health = 150f;
            hitSize = 8f;
            speed = 3f;
            accel = 0.1f;
            drag = 0.05f;
            rotateSpeed = 15f;
            itemCapacity = 40;

            legCount = 4;
            legGroupSize = 2;
            legLength = 12f;

            mineTier = 1;
            mineSpeed = 6f;
            buildSpeed = 1.8f;

            weapons.add(new RepairBeamWeapon() {{
                x = 0f;
                y = 0f;
                shootY = 0f;
                beamWidth = 0.8f;

                repairSpeed = 3f;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;

                bullet = new BulletType() {{
                    maxRange = 80f;
                }};
            }});
        }};
    }
}
