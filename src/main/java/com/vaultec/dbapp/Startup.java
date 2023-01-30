package com.vaultec.dbapp;

import com.vaultec.dbapp.gui.Window;
import com.vaultec.dbapp.model.Room;
import com.vaultec.dbapp.repository.ItemsRepository;
import com.vaultec.dbapp.repository.RoomsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
    Startup class of the database management app.

    Here the main window will be initialized and any events will be managed.
 */

@Component
@RequiredArgsConstructor
public class Startup {

    private final RoomsRepository repo;

    @Autowired
    private final Window window;

    @EventListener(ApplicationReadyEvent.class)
    public void startUp() {
        System.out.println("App started!");

        repo.findAll().forEach(System.out::println);

        EventQueue.invokeLater(() ->
        {
            File file = new File("log" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH")) + ".log");
            try{
                System.setOut(new PrintStream(file));
                window.initComponents();
                window.setVisible(true);
            } catch(IOException e) {
                System.out.println(e.toString());
            }
        });
    }
}
