package ponchik.content;


import arc.graphics.Color;
import arc.struct.*;
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
// wallOre = true;
public class PoBlocks{
public static Block
//energy
generator, petrolFactory,
//environment
silf, stoneSilf, silfWall, monu, stoneMonu, petrolLiquid,
//ores
oreVilenium, oreOlovo,
//factory
 bigSeller, seller, copperPress, electroPress, chemikTable, plateSeller, petrolCrafter, plasma, bigplasma,
//walls
silverWall, bigSilverWall,
 //turrets
 lino, pool, scar, asort, bit, light,
 //units
attackerFab, minerFab, minerRefab, unitBuy,
//just PoBlocks
 smallContainer, smallLiqContainer,mediumContainer,mediumLiqContainer, coreSelit;

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
        health = 500;

    }};
    bigSilverWall = new Wall("bigSilverWall"){{
        requirements(Category.defense, ItemStack.with(PoItems.silver, 24));
        health = 2000;


    }};
  //factory
  petrolCrafter = new GenericCrafter("petrolCrafter"){{
    requirements(Category.production, ItemStack.with(Items.lead, 50));
    size = 2;
    health = 500;
    liquidCapacity = 10f;
    craftTime = 180f;
    outputLiquid = new LiquidStack(PoLiquids.petrol, 0.1f);
    consumeLiquid(Liquids.oil, 0.1f);
  }};
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
            size = 3;
            itemCapacity = 20;
            craftTime = 180f;
            outputItem = new ItemStack(PoItems.silver, 1);
            consumeItems(ItemStack.with(Items.graphite, 5, Items.silicon, 10));
        }};
// category effect
        smallContainer = new StorageBlock("smallContainer"){{
            requirements(Category.effect, ItemStack.with(PoItems.olovo, 50));
            size = 1;
            health = 100;
            itemCapacity = 100;
        }};
        mediumContainer = new StorageBlock("mediumContainer"){{
          requirements(Category.effect, ItemStack.with(PoItems.olovo, 100));
          size = 2;
          health = 300;
          itemCapacity = 300;
        }};
        smallLiqContainer = new LiquidRouter("smallLiqContainer"){{
            requirements(Category.liquid, ItemStack.with(PoItems.olovo, 50));
            size = 1;
            health = 100;
            liquidCapacity = 10f;
        }};
        mediumLiqContainer = new LiquidRouter("mediumLiqContainer"){{
            requirements(Category.liquid, ItemStack.with(PoItems.vilenium, 100));
            size = 2;
            health = 200;
            liquidCapacity = 50f;
        }};
        coreSelit = new CoreBlock("coreSelit"){{
            requirements(Category.effect, ItemStack.with(PoItems.vilenium, 750, PoItems.olovo,500));
            health = 1500;
            itemCapacity = 4000;
            isFirstTier = true;
            size = 4;
            armor = 1;
            unitCapModifier = 5;
            alwaysUnlocked = true;
            buildCostMultiplier = 0.7f;
        }};
             plasma = new BeamDrill("plasma"){{
            requirements(Category.production, ItemStack.with(PoItems.vilenium, 60));
            consumePower(0.15f);

            drillTime = 160f;
            tier = 3;
            size = 2;
            range = 5;
        }};
        bigplasma = new BeamDrill("bigplasma"){{
            requirements(Category.production, ItemStack.with(PoItems.vilenium, 150, PoItems.silver, 200));
            consumePower(0.5f);

            drillTime = 100f;
            tier = 5;
            size = 3;
            range = 5;
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
        oreOlovo = new OreBlock("oreOlovo"){{
            oreDefault = true;
            variants = 3;
          oreThreshold = 25.4F;
          oreScale = 0.3F;
          wallOre = true;
          itemDrop = PoItems.olovo;
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
                    Items.copper, new BasicBulletType(9, 4f){{
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
asort = new ItemTurret("asort"){{
    size = 3;
health = 600;
reload = 500;
ammoUseEffect = Fx.casing1;
shootSound = Sounds.shotgun;
inaccuracy = 5;
range = 500;
rotateSpeed= 2;
ammo(
    Items.graphite, new BasicBulletType(5, 100f){{
        lifetime = 100f;
        ammoMultiplier = 5;
        shootEffect = Fx.explosion;
        width = 9;
        height = 9;
        splashDamage = 50f * 2f;
    }},
    Items.pyratite, new BasicBulletType(5, 150f){{
        lifetime = 100f;
        reloadMultiplier = 0.5f;
        ammoMultiplier = 3;
        shootEffect = Fx.explosion;
        width = 9;
        height = 9;
        splashDamage = 50f * 2f;
    }}
);
}};
 }
}
