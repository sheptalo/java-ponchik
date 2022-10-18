package ponchik.content;


import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import ponchik.world.blocks.crafting.multicraft.*;

public class PoBlocks{
public static Block
//energy
generator, petrolFactory,
//environment
silf, stoneSilf, silfWall, monu, stoneMonu, petrolLiquid,
//ores
oreVilenium,
//factory
 bigSeller, seller, copperPress, electroPress, chemikTable, plateSeller,
//walls
silverWall, bigSilverWall,
 //turrets
 lino, pool, scar, asort, bit, light,
 //units
attackerFab, minerFab, minerRefab, unitBuy,
//just PoBlocks
 smallContainer, smallLiqContainer,mediumContainer, coreSelit;

public static void load()
{
    //energy
    generator = new ConsumeGenerator("generator"){{
        requirements(Category.power, ItemStack.with(Items.copper, 100, PoItems.silver, 50, Items.lead, 100, Items.silicon, 65));
        powerProduction = 20f;
        hasLiquids = true;
        hasItems = false;
        size = 3;
        ambientSound = Sounds.steam;
        generateEffect = Fx.generatespark;
        ambientSoundVolume = 0.03f;
        drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(), new DrawLiquidRegion());

        consumeLiquid(PoLiquids.petrol, 0.1f);
    }};
    //walls
    silverWall = new Wall("silverWall"){{
        requirements(Category.defense, ItemStack.with(PoItems.silver, 6));
        health = 80;

    }};
    bigSilverWall = new Wall("bigSilverWall"){{
        requirements(Category.defense, ItemStack.with(PoItems.silver, 6));
        health = 80;

    }};
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
            requirements(Category.effect,BuildVisibility.editorOnly, ItemStack.with(Items.copper, 500, Items.lead,500));
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
petrolLiquid = new Floor("petrolLiquid"){{
    speedMultiplier = 0.5f;
    variants = 0;
    liquidDrop = PoLiquids.petrol;
    liquidMultiplier = 1.5f;
    isLiquid = true;
    status = StatusEffects.wet;
    statusDuration = 120f;
    drownTime = 140f;
    albedo = 0.9f;
    emitLight = false;
}};
silf = new Floor("silf");
stoneMonu = new Floor("stoneMonu");
monu = new Floor("monu");
        silfWall = new StaticWall("silf-wall");
        oreVilenium = new OreBlock("oreVilenium"){{
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
reload = 500;
shootSound = Sounds.shotgun;
inaccuracy = 1;

range = 125;
targetAir = true;
rotateSpeed = 1;
itemCapacity = 30;
            ammo(
                    PoItems.silver, new BasicBulletType(9, 4f){{
                                          lifetime = 60f;
                    ammoMultiplier = 5;
                    shootEffect = Fx.shootSmall;
                    width = 6f;
                    height = 8f;
                    splashDamage = 30f * 1.5f;
                    splashDamageRadius = 25f;
                    }}, 
                    Items.coal, new BasicBulletType(20, 7f){{
                        pierceCap = 4;
                    }}
                    );
}};
 }
}
