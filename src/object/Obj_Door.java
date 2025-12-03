package object;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Obj_Door extends SuperObject {
    public Obj_Door() {
        name = "Door";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Object/door.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}