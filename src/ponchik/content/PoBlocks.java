package ponchik.content;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.struct.Seq;
import arc.util.Tmp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.draw.*;
import mindustry.world.meta.BuildVisibility;
import ponchik.world.blocks.crafting.multicraft.*;
import mindustry.world.blocks.environment.*;

public class PoBlocks{
public static Block
//environment
silf, stoneSilf, silfWall,
//ores
rawVilenium,
//factory
 bigSeller, seller, copperPress, electroPress, chemikTable, plateSeller,

 //turrets
 lino, pool, scar, asort, bit, light,
 //units
attackerFab, minerFab, minerRefab, unitBuy,
//just blocks
 smallContainer, smallLiqContainer,mediumContainer, coreSelit;

public static void load()
{
  //factory
  seller = new MultiCrafter("seller"){{
    requirements(Category.production, ItemStack.with(Items.copper, 200, Items.lead, 150));
    size = 2;
    health = 300;
    powerCapacity = 0;
    craftEffect = Fx.none;
    itemCapacity = 20;
    resolvedRecipes = Seq.with(
 			new Recipe(
					new IOEntry(
					Seq.with(ItemStack.with(
							Items.copper, 5
				    )),
					Seq.with(),
							0.7f),
					new IOEntry(
					Seq.with(ItemStack.with(
					PoItems.coin, 1
				    )),
				    Seq.with()),
					10f
			),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(Items.lead, 5)),
                    Seq.with(), 0),
                    new IOEntry(
                        Seq.with(ItemStack.with(PoItems.coin, 1)),
                    Seq.with()), 10f
            )
            
            
            );
		}}; 
  bigSeller = new MultiCrafter("bigSeller"){{
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
					40f
			));
		}}; 
        chemikTable = new GenericCrafter("chemicTable"){{
            requirements(Category.production, ItemStack.with(Items.copper, 200, Items.silicon, 250));
            health = 500;
            itemCapacity = 20;
            craftTime = 180f;
            outputItem = new ItemStack(PoItems.silver, 1);
            consumeItems(ItemStack.with(Items.graphite, 5, Items.silicon, 10));
        }};
// category effect
        smallContainer = new StorageBlock("smallContainer"){{
            requirements(Category.effect, ItemStack.with(Items.copper, 50, Items.lead, 25));
            size = 1;
            health = 100;
            itemCapacity = 100;
        }};
        mediumContainer = new StorageBlock("mediumContainer"){{
          requirements(Category.effect, ItemStack.with(Items.copper, 75,PoItems.leadPlate,50));
          size = 2;
          health = 300;
          itemCapacity = 300;
        }};
        smallLiqContainer = new LiquidRouter("smallLiqContainer"){{
            requirements(Category.liquid, ItemStack.with(Items.lead, 80));
            size = 1;
            health = 100;
            liquidCapacity = 100f;
        }};
        coreSelit = new CoreBlock("coreSelit"){{
            requirements(Category.effect, ItemStack.with(Items.copper, 500, Items.lead,500));
            health = 1500;
            itemCapacity = 4000;
            isFirstTier = true;
            size = 4;
            armor = 1;
            unitCapModifier = 5;
            alwaysUnlocked = true;
            buildCostMultiplier = 0.7f;
        }};
//environment
silf = new Floor("silf");
        silfWall = new StaticWall("silf-wall");
        rawVilenium = new OreBlock("rawVilenium"){{
          oreDefault = true;
          	variants = 3;
			oreThreshold = 25.4F;
			oreScale = 0.3F;
			itemDrop = PoItems.vilenium;
			localizedName = itemDrop.localizedName;
			mapColor.set(itemDrop.color);
			useColor = true;
		}};
//turrets
lino = new ItemTurret("lino"){{
  requirements(Category.turret, ItemStack.with(Items.lead, 30, PoItems.copperPlate,20));
  size = 1;
health = 200;
reloadTime = 500;
ammoUseEffect = casing1;
shootSound = shotgun;
inaccuracy = 1;
shots = 1;
range = 125;
targetAir = true;
rotateSpeed = 1;
itemCapacity = 30;
            ammo(
                    Items.copper, new BulletType(6, 4.5f, range, FireColor.fromMap.get(Items.copper)),
                    PoItems.silver, new BulletType(9, 4f, range, Color.white){{
                                          lifetime = 60f;
                    ammoMultiplier = 5f;
                    shootEffect = Fx.shootSmall;
                    reloadMultiplier = 0.5f;
                    width = 6f;
                    height = 8f;
                    hitEffect = Fx.flakExplosion;
                    splashDamage = 30f * 1.5f;
                    splashDamageRadius = 25f;
                    }}, 
                    Items.coal, new BulletType(20, 7f, range, Color.black){{
                        pierceCap = 4;
                    }}
                    );
}};
 }
}
