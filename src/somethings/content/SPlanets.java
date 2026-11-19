package somethings.content;

import mindustry.type.Planet;
import mindustry.type.Weather;
import mindustry.content.Weathers;
import mindustry.maps.generators.BlankPlanetGenerator;
import mindustry.graphics.g3d.SunMesh;
import mindustry.graphics.g3d.NoiseMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.HexMesh;
import arc.graphics.Color;
import mindustry.game.Team;

public class SPlanets {
    public static Planet solStar, terra, luna;

    public static void load() {
        solStar = new Planet("sol", null, 2.5f) {{
            accessible = false;

            meshLoader = () -> new SunMesh(
                this, 5, 4, 0.5, 2, 1.5, 1, 1.2f,
                Color.valueOf("ffaa00"),
                Color.valueOf("ffdd55"),
                Color.valueOf("ffffcc")
            );
        }};

        terra = new Planet("terra", solStar, 1f, 3) {{
            alwaysUnlocked = true;
            iconColor = Color.valueOf("697723");

            generator = new BlankPlanetGenerator();
            meshLoader = () -> new NoiseMesh(
                this, 114514, 5, 1f, 3, 0.5f, 1f, 1f,
                Color.valueOf("697723"),
                Color.valueOf("00477d"),
                1, 0.5f, 1f, 0.5f
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
                r.weather.add(new Weather.WeatherEntry(Weathers.rain) {{
                    always = true;
                }});
            };
        }};

        luna = new Planet("luna", terra, 0.2f, 2) {{
            alwaysUnlocked = true;
            iconColor = Color.valueOf("c0c0c0");

            generator = new BlankPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
        }};
    }
}
