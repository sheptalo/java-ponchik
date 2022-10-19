package ponchik.content;

import arc.struct.*;
import mindustry.game.Objectives.*;
import static mindustry.content.TechTree.*;
import static ponchik.content.PoBlocks.*;
public class PoTechTree {
    public static void load(){
        PoPlanets.Voulis.techTree = nodeRoot("Voulis", coreSelit, () -> {
            node(vileniumConveyor, () ->{
                node(vileniumjunction,()->{
                    node(vileniumrouter,()->{

                    });
                });
            });
        });
    }
}
