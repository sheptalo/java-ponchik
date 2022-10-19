package ponchik.content;

import arc.struct.*;
import mindustry.game.Objectives.*;
import static mindustry.content.TechTree.*;
import static ponchik.content.PoBlocks.*;
public class PoTechTree {
    public static void load(){
        PoPlanets.Voulis.techTree = nodeRoot("Voulis", coreSelit, () -> {
            node(plasma, ()->{
            node(vileniumConveyor, () ->{
                node(vileniumjunction,()->{
                    node(vileniumrouter,()->{
                        node(chromeConveyor,()->{

                        });
                        node(smallContainer,()->{
                            node(mediumContainer,()->{

                            });
                            node(smallLiqContainer,()->{
                                node(mediumLiqContainer,()->{
                                });
                                });
                        });
                    });
                });
            });

        });    
    });
    node(lino, ()->{
        node(vileniumWall, ()->{
            node(bigvileniumWall,()->{
                node(chromeWall, ()->{

                });
            });
        });
    });
    nodeProduce(PoItems.vilenium, ()->{
        nodeProduce(PoLiquids.suro,()->{

        });
        nodeProduce(PoItems.olovo, ()->{

        });
        nodeProduce(PoItems.chrome, ()->{

        });
    });
    
    }
}
