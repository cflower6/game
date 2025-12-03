package main;

import object.Obj_Chest;
import object.Obj_Door;
import object.Obj_Key;

public class AssetsSetter {

    GamePanel gp;

    public AssetsSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.superObjects[0] = new Obj_Key();
        gp.superObjects[0].worldX = 23 * gp.tileSize;
        gp.superObjects[0].worldY = 7 * gp.tileSize;

        gp.superObjects[1] = new Obj_Key();
        gp.superObjects[1].worldX = 23 * gp.tileSize;
        gp.superObjects[1].worldY = 40 * gp.tileSize;

        gp.superObjects[2] = new Obj_Key();
        gp.superObjects[2].worldX = 38 * gp.tileSize;
        gp.superObjects[2].worldY = 9 * gp.tileSize;

        gp.superObjects[3] = new Obj_Door();
        gp.superObjects[3].worldX = 10 * gp.tileSize;
        gp.superObjects[3].worldY = 11 * gp.tileSize;

        gp.superObjects[4] = new Obj_Door();
        gp.superObjects[4].worldX = 8 * gp.tileSize;
        gp.superObjects[4].worldY = 28 * gp.tileSize;

        gp.superObjects[5] = new Obj_Door();
        gp.superObjects[5].worldX = 12 * gp.tileSize;
        gp.superObjects[5].worldY = 22 * gp.tileSize;

        gp.superObjects[6] = new Obj_Chest();
        gp.superObjects[6].worldX = 10 * gp.tileSize;
        gp.superObjects[6].worldY = 7 * gp.tileSize;
    }
}
