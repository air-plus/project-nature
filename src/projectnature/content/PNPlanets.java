package projectnature.content;

import mindustry.type.Planet;
import mindustry.type.Weather;
import mindustry.content.Weathers;
import mindustry.maps.generators.BlankPlanetGenerator;
import mindustry.graphics.g3d.SunMesh;
import mindustry.graphics.g3d.NoiseMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import arc.graphics.Color;
import mindustry.graphics.Pal;
import mindustry.game.Team;
import mindustry.world.meta.Env;

/**
 * Planets.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class PNPlanets {
    /** All planets. */
    public static Planet sol, terra, luna;

    /** Load all planets. */
    public static void load() {
        sol = new Planet("sol", null, 5f) {{
            accessible = false;

            meshLoader = () -> new SunMesh(
                this, 5, 4, 0.5, 2, 1.5, 1, 1.2f,
                Color.valueOf("ffaa00"),
                Color.valueOf("ffdd55"),
                Color.valueOf("ffffcc")
            );
        }};

        // TODO: Add Erekir-like fog.
        terra = new Planet("terra", sol, 1f, 3) {{
            alwaysUnlocked = true;
            iconColor = Color.valueOf("545f5b");

            generator = new BlankPlanetGenerator();
            defaultEnv = Env.terrestrial | Env.groundOil | Env.groundWater | Env.oxygen;
            allowLaunchToNumbered = false;
            defaultCore = PNBlocks.coreArmored;
            landCloudColor = Color.valueOf("e0e0e0").a(0.5f);
            orbitRadius = 100f;
            atmosphereColor = Pal.water;

            meshLoader = () -> new MultiMesh(
                new NoiseMesh(
                    this, 114514, 5, radius, 3, 0.5f, 1f, 1f,
                    Color.valueOf("545f5b"),
                    Pal.water,
                    1, 0.5f, 1f, 0.5f
                ),
                new NoiseMesh(
                    this, 1919810, 5, radius, 3, 0.5f, 1f, 1f,
                    Color.valueOf("545f5b"),
                    Pal.water,
                    1, 0.5f, 1f, 0.5f
                )
            );
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(
                    this, 114514, 1f, 0.1f, 5,
                    Color.valueOf("e0e0e0").a(0.5f),
                    4, 0.5f, 1.2f, 0.4f
                ),
                new HexSkyMesh(
                    this, 1919810, 1f, 0.15f, 5,
                    Color.valueOf("ffffff").a(0.8f),
                    4, 0.5f, 1.2f, 0.4f
                )
            );

            ruleSetter = r -> {
                r.waveTeam = PNTeam.bioed;
                r.placeRangeCheck = true;
                r.derelictRepair = true;
                r.coreDestroyClear = true;
                r.weather.add(
                    new Weather.WeatherEntry(Weathers.rain) {{
                        always = true;
                    }}
                );
            };
        }};

        luna = new Planet("luna", terra, 0.2f, 1) {{
            alwaysUnlocked = true;
            iconColor = Color.valueOf("8c8c8c");

            generator = new BlankPlanetGenerator();
            defaultEnv = Env.space;
            defaultCore = PNBlocks.coreArmored;
            hasAtmosphere = false;
            tidalLock = true;
            orbitRadius = 3f;
            camRadius = 0.1f;

            meshLoader = () -> new MultiMesh(
                new NoiseMesh(
                    this, 114514, 5, radius,
                    4, 0.55f, 0.8f, 0.5f,
                    Color.valueOf("8c8c8c"),
                    Color.valueOf("4f4f4f"),
                    3, 0.5f, 1.2f, 0.45f
                ),
                new NoiseMesh(
                    this, 1919810, 5,
                    radius * 1.02f, 6, 0.6f, 3f, 0.3f,
                    Color.valueOf("b0b0b0").a(0.35f),
                    Color.valueOf("3a3a3a").a(0.35f),
                    4, 0.5f, 2.5f, 0.5f
                )
            );

            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.lighting = true;
                r.ambientLight = new Color(0f, 0f, 0f, 0.8f);
                r.solarMultiplier = 1.5f;
                r.weather.clear();
            };
        }};
    }
}
