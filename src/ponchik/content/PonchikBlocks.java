package ponchik.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*; 
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import ponchik.world.blocks.crafting.multicraft.IOEntry;
import ol.world.blocks.crafting.multicraft.MultiCrafter;
import ponchik.world.blocks.crafting.multicraft.Recipe; 

public class PonchikBlocks{
public static 
//turret 
asort, bit, light, lino, scar, pool, 
//factory
bigSeller, seller, copperPress, electroPress, materialFactory, partsMaker, plateSeller,
//units
attackerFab, minerFab, minerRefab, unitBuy;

public static void load()
{
  //factory
  bigSeller = new MutliCrafter("Big seller"){{
    requirements(Category.production, with(Items.copper, 400, Items.lead, 300, PonchikItems.ThoriumPlate, 200));
    size = 3;
    health = 800;
    powerCapacity = 0;
    craftEffect = Fx.none;
    itemCapacity = 20;
    resolvedRecipes = Seq.with(
      new Recipe(
        new IOEntry(
          Seq.with(ItemStack.with(
            Items.titanium, 2
            )
          ),
          Seq.with(), 1f),
          new IOEntry(
            Seq.with(ItemStack.with(
              PonchikItems.coin, 2
              )),
              Seq.with()), 100f
        ));
  }};
 }
}