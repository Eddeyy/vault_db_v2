package com.vaultec.dbapp;

import com.vaultec.dbapp.model.Room;
import com.vaultec.dbapp.repository.ItemsRepository;
import com.vaultec.dbapp.repository.RoomsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/*
    Startup class of the database management app.

    Here the main window will be initialized and any events will be managed.
 */

@Component
@RequiredArgsConstructor
public class Startup {

    private final RoomsRepository repo;

    @EventListener(ApplicationReadyEvent.class)
    public void startUp() {
        System.out.println("App started!");

        repo.findAll().forEach(System.out::println);

        EventQueue.invokeLater(() ->
        {
            // Initialize main window bean
            // var window = SpringBootApp.getApc().getBean(somejframeclass.class);
            // window.setVisible(true);
        });
    }
}
