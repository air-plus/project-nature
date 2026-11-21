var isDesktop = !Vars.mobile;

function setStaticFinalField(field, value) {
    if (isDesktop) {
        const Unsafe = java.lang.Class.forName("sun.misc.Unsafe");
        const unsafeField = Unsafe.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        const unsafe = unsafeField.get(null);
        const base = unsafe.staticFieldBase(field);
        const offset = unsafe.staticFieldOffset(field);
        unsafe.putObject(base, offset, value);
    } else {
        field.set(null, value);
    }
}

const teamClass = Team.all[0].getClass();
const allField = teamClass.getDeclaredField("all");
allField.setAccessible(true);

const currentAll = Team.all;
if (currentAll.length < 9) {
    const newAll = java.lang.reflect.Array.newInstance(teamClass, 9);
    for (let i = 0; i < currentAll.length; i++) newAll[i] = currentAll[i];
    for (let i = currentAll.length; i < 9; i++) newAll[i] = new Team(i, "team-" + i);
    setStaticFinalField(allField, newAll);
}

const myTeam = Team.all[27];
myTeam.name = "bioed";
myTeam.color.set(Color.valueOf("00ffce"));
myTeam.setPalette(
    Color.valueOf("00ffce"),
    Color.valueOf("3ad2b5"),
    Color.valueOf("189885")
);
if (!isDesktop) myTeam.ignoreUnitCap = true;

const baseField = teamClass.getDeclaredField("baseTeams");
baseField.setAccessible(true);
const newBaseArr = java.lang.reflect.Array.newInstance(teamClass, 7);
for (let i = 0; i < 6; i++) newBaseArr[i] = Team.baseTeams[i];
newBaseArr[6] = myTeam;
setStaticFinalField(baseField, newBaseArr);

Events.on(ClientLoadEvent, e => {
    const region = Core.atlas.find("bioed");
    if (region && region.found()) {
        Fonts.registerIcon("bioed", "bioed", 0xE100, region);
        myTeam.emoji = Fonts.getUnicodeStr("bioed");
    }
});
