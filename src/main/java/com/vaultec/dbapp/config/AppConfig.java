package com.vaultec.dbapp.config;

import com.vaultec.dbapp.gui.ContentPanel;
import com.vaultec.dbapp.gui.Window;
import com.vaultec.dbapp.gui.cards.*;
import com.vaultec.dbapp.gui.log.LogWindow;
import com.vaultec.dbapp.model.entity.Dweller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean()
    public Window getWindow() throws IOException {
        return new Window();
    }

    @Bean
    public ContentPanel getContentPanel() {
        return new ContentPanel();
    }

    @Bean
    public LogWindow getLogWindow() {
        return new LogWindow();
    }
    @Bean
    public DwellersCard getDwellersCard(){ return new DwellersCard(); }

    @Bean
    public WarehouseCard getWarehouseCard(){ return new WarehouseCard(); }
    @Bean
    public ComplaintsCard getComplaintsCard(){ return new ComplaintsCard(); }
    @Bean
    public HospitalCard getHospitalCard(){ return new HospitalCard(); }

    @Bean
    public LoginCard getLoginCard(){ return new LoginCard(); }

    @Bean
    public MainMenuCard getMainMenuCard(){ return new MainMenuCard(); }
    @Bean
    public Dweller getCurrentDweller(){ return new Dweller(); }
}
