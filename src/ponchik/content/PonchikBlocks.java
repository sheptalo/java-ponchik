package ponchik.content;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.struct.Seq;
import arc.util.Tmp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.*;
import mindustry.world.meta.BuildVisibility;
import ponchik.world.blocks.crafting.multicraft.IOEntry;
import ponchik.world.blocks.crafting.multicraft.MultiCrafter;
import ponchik.world.blocks.crafting.multicraft.Recipe;


public class PonchikBlocks{
public static Block
//turret 
asort, bit, light, lino, scar, pool, 
//factory
bigSeller, seller, copperPress, electroPress, materialFactory, partsMaker, plateSeller,
//units
attackerFab, minerFab, minerRefab, unitBuy;

public static void load()
{
  //factory
  bigSeller = new MultiCrafter("Big seller"){{
    requirements(Category.production, with(Items.copper, 400, Items.lead, 300, PonchikItems.thoriumPlate, 200));
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
