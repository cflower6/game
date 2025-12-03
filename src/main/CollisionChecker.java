package main;

import entity.Entity;

/**
 * We want to check all points of the invisible square
 *
 *
 */
public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    // not player but ALL entities (player, monsters, NPC, etc)
    public void checkTile(Entity entity) {
        //These are the edges of the box
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        // why are we dividing by tileSize?
        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        // we only need to check 2 tiles at a time
        int tileNum1;
        int tileNum2;

        switch (entity.direction) {
            case "up":
                // we find tile # and we check collision
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;

                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    System.out.println("Collision Detected");
                    entity.collisionOn = true;
                }
                break;
            case "down":
                // we find tile # and we check collision
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;

                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    System.out.println("Collision Detected");
                    entity.collisionOn = true;
                }
                break;
            case "left":
                // we find tile # and we check collision
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;

                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    System.out.println("Collision Detected");
                    entity.collisionOn = true;
                }
                break;
            case "right":
                // we find tile # and we check collision
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;

                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    System.out.println("Collision Detected");
                    entity.collisionOn = true;
                }
                break;
        }
    }
}