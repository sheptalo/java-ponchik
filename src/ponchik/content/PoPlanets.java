package ponchik.content;

import arc.graphics.*;
import mindustry.game.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.content.*;


public class PoPlanets{
    public static Planet
    Voulis;

//TODO new planet generator.my own tech tree? 

public static void load(){
        Voulis = new Planet("voulis", Planets.serpulo, 3f, 2){{
            generator = new SerpuloPlanetGenerator();
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
            hiddenItems.addAll(Items.erekirItems).removeAll(Items.serpuloItems);
        }};
} 
} 
