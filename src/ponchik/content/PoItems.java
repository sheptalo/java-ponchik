package ponchik.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class PoItems{
	public static Item 
	coin, copperPlate, leadPlate, silver, mechGun, mechJet, thoriumPlate, rawVilenium, titaniumPlate;
	public static void load(){
	  rawVilenium = new Item("rawVilenium", Color.valueOf("abcdef")){{
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

	}
} 
