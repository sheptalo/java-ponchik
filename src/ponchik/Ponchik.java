package ponchik;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import ponchik.content.*;

public class Ponchik extends Mod{

public void thanks(){
        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
          //show dialog upon startup
          Time.runTask(10f, () -> {
              BaseDialog dialog = new BaseDialog("thanks for downloading");
              dialog.cont.add("Thanks for downloading it makes me happier").row();
              dialog.cont.image(Core.atlas.find("po-icon")).pad(20f).row();
              dialog.cont.button("Ok", dialog::hide).size(100f, 50f);
              dialog.show();
          });
      });
  }


    @Override
    public void loadContent(){
      PoItems.load();
      PoLiquids.load();
      PoBlocks.load();
      PoPlanets.load();
    }
}
