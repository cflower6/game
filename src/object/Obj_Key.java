package object;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Obj_Key extends SuperObject {
    public Obj_Key() {
        name = "Key";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Object/key.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
