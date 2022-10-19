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
silf, stoneSilf, silfWall, monu, stoneMonu, petrolLiquid, silfVent, monuVent,
//ores
oreVilenium, oreOlovo,
//factory
 bigSeller, seller, copperPress, electroPress, chromeextractor, plateSeller, petrolCrafter, plasma, bigplasma,
//walls
chromeWall, bigchromeWall, vileniumWall,bigvileniumWall,
 //turrets
 lino, pool, scar, asort, bit, light,
 //units
attackerFab, minerFab, minerRefab, unitBuy,
//just PoBlocks
 smallContainer,vileniumrouter, smallLiqContainer,mediumContainer,mediumLiqContainer,vileniumConveyor,
 chromeConveyor,vileniumjunction,vileniumBridge, coreSelit;

public static void load()
{
    vileniumrouter = new Router("vileniumrouter"){{
        requirements(Category.distribution, ItemStack.with(PoItems.vilenium, 3));
        buildCostMultiplier = 4f;
        researchCost = ItemStack.with(PoItems.vilenium, 10);
    }};
    vileniumConveyor = new Conveyor("vileniumConveyor"){{
        requirements(Category.distribution, ItemStack.with(PoItems.vilenium, 2));
        health = 50;
        speed = 0.08f;
        displayedSpeed = 4.2f;
        buildCostMultiplier = 2f;
        researchCost = ItemStack.with(PoItems.vilenium, 5);
    
    }};
    chromeConveyor = new Conveyor("chromeConveyor"){{
        requirements(Category.distribution, ItemStack.with(PoItems.chrome, 1,PoItems.vilenium, 1 ));
        health = 100;
        speed = 0.15f;
        researchCost = ItemStack.with(PoItems.chrome, 500,PoItems.vilenium, 1000);
    }};
    vileniumjunction = new Junction("vileniumjunction"){{
        requirements(Category.distribution, ItemStack.with(PoItems.vilenium, 5));
        speed = 26;
        capacity = 6;
        health = 40;
        buildCostMultiplier = 6f;
        researchCost = ItemStack.with(PoItems.vilenium, 20);
    }};
    vileniumBridge = new BufferedItemBridge("vileniumBridge"){{
        requirements(Category.distribution, ItemStack.with(PoItems.vilenium, 6));
        fadeIn = moveArrows = false;
        range = 4;
        speed = 74f;
        arrowSpacing = 6f;
        bufferCapacity = 10;
    }};
    //energy
    generator = new ConsumeGenerator("generator"){{
        requirements(Category.power, ItemStack.with(PoItems.olovo, 100, PoItems.vilenium, 125));
        powerProduction = 20f;
        hasLiquids = true;
        hasItems = false;
        size = 3;
        ambientSound = Sounds.steam;
        generateEffect = Fx.generatespark;
        ambientSoundVolume = 0.03f;
        drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(), new DrawLiquidRegion());

        consumeLiquid(PoLiquids.suro, 0.1f);
    }};
    //walls
    vileniumWall = new Wall("vileniumWall"){{
        requirements(Category.defense, ItemStack.with(PoItems.vilenium,8));
        health = 420;
        researchCost = ItemStack.with(PoItems.vilenium, 200);
    }};
    bigvileniumWall = new Wall("bigvileniumWall"){{
        requirements(Category.defense, ItemStack.with(PoItems.vilenium,32));
        health = 1680;
        researchCost = ItemStack.with(PoItems.vilenium, 700);
    }};
    chromeWall = new Wall("chromeWall"){{
        requirements(Category.defense, ItemStack.with(PoItems.chrome, 6));
        health = 720;
        researchCost = ItemStack.with(PoItems.chrome, 200);
    }};
    bigchromeWall = new Wall("bigchromeWall"){{
        requirements(Category.defense, ItemStack.with(PoItems.chrome, 24));
        health = 2880;
        researchCost = ItemStack.with(PoItems.chrome, 700);

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
        smallContainer = new StorageBlock("smallContainer"){{
            requirements(Category.effect, ItemStack.with(PoItems.olovo, 100));
            size = 1;
            health = 100;
            itemCapacity = 100;
            researchCost = ItemStack.with(PoItems.olovo, 300);
        }};
        mediumContainer = new StorageBlock("mediumContainer"){{
          requirements(Category.effect, ItemStack.with(PoItems.olovo, 200, PoItems.vilenium, 100));
          size = 2;
          health = 300;
          itemCapacity = 300;
          researchCost = ItemStack.with(PoItems.vilenium, 700, PoItems.olovo, 900);
        }};
        smallLiqContainer = new LiquidRouter("smallLiqContainer"){{
            requirements(Category.liquid, ItemStack.with(PoItems.olovo, 100));
            size = 1;
            health = 100;
            liquidCapacity = 10f;
            researchCost = ItemStack.with(PoItems.olovo, 300);
        }};
        mediumLiqContainer = new LiquidRouter("mediumLiqContainer"){{
            requirements(Category.liquid, ItemStack.with(PoItems.vilenium, 100,PoItems.olovo, 200));
            size = 2;
            health = 300;
            liquidCapacity = 50f;
            researchCost = ItemStack.with(PoItems.vilenium, 700, PoItems.olovo, 900);
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
            requirements(Category.production, ItemStack.with(PoItems.vilenium, 150, PoItems.chrome, 200, PoItems.olovo, 100));
            consumePower(0.5f);

            drillTime = 100f;
            tier = 5;
            size = 3;
            range = 5;
            
        }};
        chromeextractor = new AttributeCrafter("chromeextractor"){{
            requirements(Category.production, ItemStack.with(PoItems.vilenium, 80));
            attribute = Attribute.steam;
            displayEfficiency = false;
            craftEffect = Fx.turbinegenerate;
            craftTime = 120f;
            size = 3;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            outputItems = ItemStack.with(PoItems.chrome, 1);
            consumePower(0.5f);
        }};
//environment
silfVent = new SteamVent("silfVent"){{
    attributes.set(Attribute.steam, 1f);
    parent = blendGroup = PoBlocks.silf;
}};
    monuVent = new SteamVent("monuVent"){{
        attributes.set(Attribute.steam, 1f);
parent = blendGroup = PoBlocks.monu;
}};
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
            variants = 2;
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
  requirements(Category.turret, ItemStack.with(PoItems.olovo, 100, PoItems.vilenium, 75));
  size = 1;
health = 200;
reload = 500;
shootSound = Sounds.shotgun;
inaccuracy = 1;

range = 125;
targetAir = true;
rotateSpeed = 1;
itemCapacity = 30;
researchCost = ItemStack.with(PoItems.olovo, 200, PoItems.vilenium,150);
            ammo(
                    PoItems.vilenium, new BasicBulletType(9, 4f){{
                    lifetime = 60f;
                    ammoMultiplier = 5;
                    shootEffect = Fx.shootSmall;
                    width = 6f;
                    height = 8f;
                    splashDamage = 30f * 1.5f;
                    splashDamageRadius = 25f;
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
