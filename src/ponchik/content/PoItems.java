package ponchik.content;

import arc.graphics.Color;
import arc.struct.*;
import mindustry.type.*;

public class PoItems{
	public static Item 
	coin, copperPlate, leadPlate, silver, mechGun, mechJet, thoriumPlate, vilenium, olovo, titaniumPlate;
	
	public static final Seq<Item> serpuloItems = new Seq<>(), voItems = new Seq<>();

	public static void load(){
		olovo = new Item("olovo", Color.valueOf("abcdef")){{
			hardness = 3;
		}};
	  vilenium = new Item("vilenium", Color.valueOf("abcdef")){{
		hardness = 3;
	  }};
	  coin = new Item("coin", Color.valueOf("abcdef"));
	  silver = new Item("silver", Color.valueOf("abcdef"));
	  copperPlate = new Item("copperPlate", Color.valueOf("abcdef"));
	  leadPlate = new Item("leadPlate", Color.valueOf("abcdef"));
	  thoriumPlate = new Item("thoriumPlate", Color.valueOf("abcdef"));
	  titaniumPlate = new Item("titaniumPlate", Color.valueOf("abcdef"));
	  vilenium = new Item("vilenium", Color.valueOf("abcdef")){{
	    
	  }};
	  
	  serpuloItems.addAll(
	    titaniumPlate, thoriumPlate, mechGun, mechJet, leadPlate, copperPlate, coin);
	    
	    voItems.addAll(vilenium, olovo, silver);
	}
} 
