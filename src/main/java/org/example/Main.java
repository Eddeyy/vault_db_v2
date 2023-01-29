package org.example;

import org.example.gui.Window;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;

public class Main {



    public static void main(String args[]) throws SQLException, ClassNotFoundException, IOException {
        File file = new File("log2023-01-21_17.log");
        System.setOut(new PrintStream(file));
        BufferedImage image = ImageIO.read(new File("foreground.png"));
        Window window;
        window = new Window();
        window.setVisible(true);

        Connection konekszyn = DriverManager.getConnection(
               "jdbc:oracle:thin:@25.43.54.68:1521/szogunpdb1", "VAULT", "vaultdba");

        Statement statement = konekszyn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM dwellers");
        rs.next();
        String str = rs.getString("firstname");
        System.out.println(str);
        System.out.println("hello darkness my old friend");
        System.out.println("hello darkness my old friend");
        System.out.println("hello darkness my old friend");
        System.out.println("hello darkness my old friend");
    }
}
