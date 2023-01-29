package org.example;

import com.vaultec.dbapp.gui.Window;

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
        Window window;
        window = new Window();
        window.setVisible(true);
    }
}
