package ponchik.content;

import arc.graphics.*;
import mindustry.game.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import ponchik.system.generators.VoulisPlanetGenerator;
import mindustry.content.*;

public class PoPlanets{
    public static Planet
    Voulis;

//TODO my own tech tree? 

public static void load(){
        Voulis = new Planet("voulis", Planets.sun, 3f, 2){{
            generator = new VoulisPlanetGenerator();
                meshLoader = () -> new HexMesh(this, 5);

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 1;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
            };
            atmosphereColor = Color.valueOf("3c1b8f");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            alwaysUnlocked = true;
            clearSectorOnLose = true;
            defaultCore = PoBlocks.coreSelit;
            hiddenItems.addAll(PoItems.voItems).removeAll(Items.serpuloItems, PoItems.serpuloItems, erekirItems);
        }};
} 
} 
