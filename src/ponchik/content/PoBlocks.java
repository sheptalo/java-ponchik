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
import ponchik.world.blocks.crafting.multicraft.*;


public class PoBlocks{
public static Block
 bigSeller, seller, copperPress, electroPress, materialFactory, partsMaker, plateSeller;
//unitsattackerFab, minerFab, minerRefab, unitBuy;

public static void load()
{
  //factory
  bigSeller = new MultiCrafter("Big seller"){{
    requirements(Category.production, ItemStack.with(Items.copper, 400, Items.lead, 300, PoItems.thoriumPlate, 200));
    size = 3;
    health = 800;
    powerCapacity = 0;
    craftEffect = Fx.none;
    itemCapacity = 20;
    resolvedRecipes = Seq.with(
 			new Recipe(
					new IOEntry(
					Seq.with(ItemStack.with(
							Items.titanium, 1
				    )),
					Seq.with(),
							0.7f),
					new IOEntry(
					Seq.with(ItemStack.with(
					PoItems.coin, 2
				    )),
				    Seq.with()),
					140f
			));
		}}; 
        copperPress = new GenericCrafter("Copper press"){{
            requirements(Category.crafting, with(Items.copper, 65));
            craftTime = 120f;
            size = 1;
            hasPower = true;
            hasItems = true;
            rotate = false;
            solid = true;

            consumePower(1.5f);
            consumeItem(Items.titanium);
             outputItem = new ItemStack(PoItems.copperPlate, 1);
        }};
 }
}
