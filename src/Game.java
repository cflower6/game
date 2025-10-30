import main.GamePanel;

import javax.swing.*;


public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("My game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        // Window to be sized to fit the preferred size and layouts of it's subcomponents (=main.GamePanel)
        // Basically our window (JFrame) is sized to our JPanel (gamePanel)
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}