package ponchik.content;
import arc.graphics.Color;
import mindustry.type.Liquid;
public class PoLiquids {
    public static Liquid
    petrol;

    public static void load(){
        petrol = new Liquid("petrol", Color.valueOf("abcdef")){{
            coolant = false;
        }};
    }
}
