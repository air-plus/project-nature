package somethings.content;

import arc.Core;
import arc.Events;
import arc.graphics.Color;
import arc.graphics.g2d.TextureAtlas.AtlasRegion;
import mindustry.Vars;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.game.Team;
import mindustry.ui.Fonts;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Teams.
 *
 * @author air-plus
 * @version 1.0.0
 */
public class STHTeam {
    /** All teams. */
    public static Team bioed;

    /** Load all teams. */
    public static void load() {
        bioed = Team.all[27];
        bioed.name = "bioed";
        bioed.color.set(Color.valueOf("006400"));
        bioed.setPalette(
            Color.valueOf("006400"),
            Color.valueOf("008000"),
            Color.valueOf("004d00")
        );

        try {
            Class<?> teamClass = Team.class;

            Field baseField = teamClass.getDeclaredField("baseTeams");
            baseField.setAccessible(true);

            Team[] oldArr = Team.baseTeams;
            Team[] newArr = (Team[]) Array.newInstance(teamClass, oldArr.length + 1);
            System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
            newArr[oldArr.length] = bioed;

            setStaticFinalField(baseField, newArr);
        } catch (Throwable t) {
            throw new RuntimeException("Failed to register team `bioed`.", t);
        }

        Events.on(ClientLoadEvent.class, e -> {
            AtlasRegion region = Core.atlas.find("bioed");
            if (region != null && region.found()) {
                Fonts.registerIcon("bioed", "bioed", 0xE100, region);
                bioed.emoji = Fonts.getUnicodeStr("bioed");
            }
        });
    }

    /**
     * Set a static final field.
     * Uses `sun.misc.Unsafe` (via reflection) on desktop, and plain reflection on mobile.
     */
    private static void setStaticFinalField(Field field, Object value) throws Exception {
        if (!Vars.mobile) {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field unsafeField = unsafeClass.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            Object unsafe = unsafeField.get(null);

            Object base = unsafeClass.getMethod("staticFieldBase", Field.class).invoke(unsafe, field);
            long offset = (Long) unsafeClass.getMethod("staticFieldOffset", Field.class).invoke(unsafe, field);
            Method putObject = unsafeClass.getMethod("putObject", Object.class, long.class, Object.class);
            putObject.invoke(unsafe, base, offset, value);
        } else {
            field.set(null, value);
        }
    }
}
