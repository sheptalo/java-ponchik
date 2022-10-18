package ponchik.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class PoItems{
	public static Item 
	coin, copperPlate, leadPlate, silver, mechGun, mechJet, thoriumPlate, vilenium, titaniumPlate;
	public static final Seq<Item> serpuloItems = new Seq<>(), voItems = new Seq<>();

	public static void load(){
	  vilenium = new Item("vilenium", Color.valueOf("abcdef")){{
		hardness = 3;
	  }};
	  coin = new Item("coin", Color.valueOf("abcdef")){{
	    
	  }};
	  silver = new Item("silver", Color.valueOf("abcdef")){{

	  }};
	  copperPlate = new Item("copperPlate", Color.valueOf("abcdef")){{
	    
	  }};
	  leadPlate = new Item("leadPlate", Color.valueOf("abcdef")){{
	    
	  }};
	  mechGun = new Item("mechGun", Color.valueOf("abcdef")){{
	    
	  }};
	  mechJet = new Item("mechJet", Color.valueOf("abcdef")){{
	    
	  }};
	  thoriumPlate = new Item("thoriumPlate", Color.valueOf("abcdef")){{
	    
	  }};
	  titaniumPlate = new Item("titaniumPlate", Color.valueOf("abcdef")){{
	    
	  }};
	  vilenium = new Item("vilenium", Color.valueOf("abcdef")){{
	    
	  }};
	  serpuloItems.addAll(
	    titaniumPlate, thoriumPlate, mechGun, mechJet, leadPlate, copperPlate, silver, coin);
	    voItems.addAll(vilenium);
	}
} 
