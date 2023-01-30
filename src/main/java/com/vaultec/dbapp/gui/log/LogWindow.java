package com.vaultec.dbapp.gui.log;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


@Component
public class LogWindow extends JLabel implements Runnable {

    ArrayList<String> logStr = new ArrayList<>();
    volatile boolean active;
    String currFileName;
    public LogWindow() {
        setBackground(new Color(0, 0, 0, 230));
        //setBackground(Color.BLACK);
        setForeground(Color.GREEN);
        logStr.add("<html><p>");
        logStr.add("</p></html>");
        active = true;
        currFileName = "log" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH")) + ".log";
        setHorizontalAlignment(SwingConstants.LEFT);
        setVerticalAlignment(SwingConstants.TOP);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setOpaque(true);
    }

    @Override
    public void run() {
        BufferedReader fileReader = null;
        Path tempFile = null;
        try {
            tempFile = Paths.get("./" + currFileName);
            if(!Files.exists(tempFile)) {
                Files.createFile(tempFile);
            }
            fileReader = new BufferedReader(new FileReader("./" + currFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        while(active) {
            String line = "";
            try {
                line = fileReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(line == null) {
                continue;
            }
            logStr.add(logStr.size()-1, line);
            String message = "";
            for(var str : logStr) {
                message = message + str + "<br>";
            }
            setText(message);
        }
    }

    public void stop() {
        active = false;
    }
}