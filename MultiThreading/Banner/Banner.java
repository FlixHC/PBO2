import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Banner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Banner");
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            ArrayList<Character> chars = new ArrayList<>();
            {
                String text = "Felix Hartono";

                for (int i = 0; i < text.length(); i++) {
                    chars.add(text.charAt(i));
                }

                new Thread(() -> {
                    while (true) {
                        char last = chars.remove(chars.size() - 1);
                        chars.add(0, last);

                        repaint();
                                
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            @Override
            protected void paintComponent(Graphics style) { //Function yang disediakan javax.swing
                super.paintComponent(style);
                style.setColor(Color.BLUE); // Set warna
                style.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Set font & style

                StringBuilder sb = new StringBuilder(); //StringBuilder digunakan untuk 
                for (int i = 0; i < chars.size(); i++) {
                    sb.append(chars.get(i));
                }

                style.drawString(sb.toString(), 50, 60); 
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}
