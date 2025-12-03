package object;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Obj_Chest extends SuperObject {
    public Obj_Chest() {
        name = "Chest";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Object/chest.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}