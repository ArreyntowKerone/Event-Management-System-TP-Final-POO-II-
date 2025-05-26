package com.example.eventmanager;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.ResourceBundle;

import com.example.eventmanager.usefulclasses.Evenement;
import com.example.eventmanager.usefulclasses.GestionEvenements;

import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/*public class listController {
    @FXML
    private TextArea fullist;
    public void initialize(){
        GestionEvenements.displayEventsInTextArea(fullist, GestionEvenements.getEvenements());
    }
}*/

public class listController implements Initializable {

    @FXML
    private TableColumn<Evenement, LocalDateTime> dateclm;

    @FXML
    private TableColumn<Evenement, String> idclm;

    @FXML
    private TableColumn<Evenement, String> locationclm;

    @FXML
    private TableColumn<Evenement, Integer> maxcap;

    @FXML
    private TableColumn<Evenement, String> nameclm;

    @FXML
    private TableView<Evenement> tableviewid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Logger logger = LoggerFactory.getLogger(listController.class);
        try {
            // Thread-safe initialization
            Platform.runLater(() -> {
                Map<String, Evenement> events = GestionEvenements.getInstance().getEvenements();
                
                if (events == null || events.isEmpty()) {
                    logger.warn("No events found");
                    return;
                }
    
                // Set up the TableColumn cell value factories
                idclm.setCellValueFactory(new PropertyValueFactory<>("id"));
                nameclm.setCellValueFactory(new PropertyValueFactory<>("nom"));
                locationclm.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                maxcap.setCellValueFactory(new PropertyValueFactory<>("capaciteMax"));
                dateclm.setCellValueFactory(new PropertyValueFactory<>("date"));

    
                // Performance-optimized population
                ObservableList<Evenement> eventList = FXCollections.observableArrayList();
                eventList.addAll(events.values());
                tableviewid.setItems(eventList);
                });
    } catch (Exception e) {
        System.out.println(e.getMessage());
        new Alert(Alert.AlertType.ERROR, "Failed to load events").show();
    }
    }
}




