package projectnature.content;

import mindustry.type.UnitType;
import mindustry.gen.LegsUnit;
import mindustry.ai.types.BuilderAI;
import mindustry.type.weapons.RepairBeamWeapon;
import mindustry.graphics.Pal;
import mindustry.entities.bullet.BulletType;

/**
 * Unit types.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class PNUnitTypes {
    /** All unit types. */
    public static UnitType delta;

    /** Load all unit types. */
    public static void load() {
        delta = new UnitType("delta") {{
            constructor = LegsUnit::create;
            coreUnitDock = true;
            aiController = () -> new BuilderAI(true, 400f);
            isEnemy = false;

            health = 600f;
            hitSize = 8f;
            speed = 2f;
            armor = 2f;
            rotateSpeed = 6f;
            itemCapacity = 40;

            legCount = 4;
            legGroupSize = 2;
            legLength = 12f;
            legBaseOffset = 4f;
            legMoveSpace = 0.8f;
            legForwardScl = 0.5f;
            legExtension = -2f;
            legPairOffset = 2f;

            mineTier = 2;
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
                laserColor = Pal.accent;
                healColor = Pal.accent;

                bullet = new BulletType() {{
                    maxRange = 80f;
                }};
            }});
        }};
    }
}
