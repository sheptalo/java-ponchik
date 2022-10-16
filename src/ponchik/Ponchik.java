package ponchik;

import arc.*;
import arc.func.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.EventType.*;
import mindustry.game.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.net.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.mod.Mod;
import ponchik.content.*;

public class Ponchik extends Mod{

    @Override
    public void init(){
    }

    @Override
    public void loadContent(){
      PonchikBlocks.load();
    }
}
