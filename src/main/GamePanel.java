package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

/**
 * Important part about games -> Time
 * When implementing a game - it's static until the player makes an action, at that point it updates
 * That's where we get FPS (Frames Per Second) and typically it's 60
 * so that means
 * when a player makes an action (presses down key) the game updates the frame
 */
public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale =  3;
    public final int tileSize = originalTileSize * scale; //48x48

    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    final int FPS = 60;
    final long NANOSECOND = 1000000000;

    TileManager tileM = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this, keyHandler);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);

        //Double buffering can improve rendering performance
        this.setDoubleBuffered(true);
        // This adds a listener to the panel it will recognize the key now
        this.addKeyListener(keyHandler);
        // Set our focus to the panel so it can fo
        this.setFocusable(true);
    }

    public void startGameThread() {
        // we instantiate this thread and then we pass in main.GamePanel
        gameThread = new Thread(this);

        // we start the thread which starts the run method
        gameThread.start();
    }

    // When we start the game thread it starts this run method
    @Override
    public void run() {
        double drawInterval = NANOSECOND / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread.isAlive()) {
            currentTime = System.nanoTime();
            // get past time / the draw Interval
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            // update lastTime
            lastTime = currentTime;
            // if delta is greater or equal to 1 that means we hit a draw Interval
            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= NANOSECOND) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    /**
     * Funny learning - when we ran this with no FPS set, the square flew off so we need to set the fps by using TIME:)
     */
//    @Override
//    public void run() {
//        /***
//         * Popular game loop - Sleep method first
//         */
//        // every 0.016667 seconds we draw screen
//        double drawInterval = 1000000000 / FPS;
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while(gameThread.isAlive()) {
//            update();
//
//            repaint();
//
//            try {
//                //how much time left after the above methods run
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//
//                if(remainingTime < 0) {
//                    remainingTime = 0;
//                }
//
//                // sleep takes in milliseconds
//                Thread.sleep((long) remainingTime);
//
//
//                //after sleep we calculate next draw time
//                nextDrawTime += drawInterval;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
////        // this is where we start our game loop
////        while(gameThread.isAlive()) {
////            //We need to get the currentTime AND calculate 1 second
////            long currentTime = System.nanoTime();
////
////            System.out.println("Current time: " + currentTime);
////            // 1 UPDATE: update information such as character positions
////            update();
////
////            // 2 DRAW: daw the screen with the updated information
////            repaint();
////        }
//    }

    public void update() {
        player.update();
    }


    //built in method for Java
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // We change the graphics to graphics2d for our 2d game
        Graphics2D g2 = (Graphics2D) g;
        // THINK OF THIS LIKE LAYERS
        tileM.draw(g2);

        player.draw(g2);

        // good practice to save memory
        g2.dispose();
    }
}

