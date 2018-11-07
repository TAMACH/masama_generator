package views.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import db.bean.SQLSchema;
import db.bean.Table;
import db.connection.SQLConnection;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Tab;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author amirouche
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    SQLConnection cnx;
    SQLSchema schema;
    @FXML
    private VBox insertTab;
    @FXML
    private Accordion left;
    @FXML
    private Tab tabName;

    public void createTablesView() {
        for (Table table : schema.getTables()) {
            TitledPane titledPane = new TitledPane(table.getTableName(), table.createTableView());
            left.getPanes().add(titledPane);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cnx = new SQLConnection("C:\\Users\\tamac\\OneDrive\\Desktop\\test.sql");
            schema = new SQLSchema();
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTablesView();
        left.expandedPaneProperty().addListener((ObservableValue<? extends TitledPane> ov, TitledPane old_val, TitledPane new_val) -> {
            if (new_val != null) {
                Table tableByName = schema.getTableByName(new_val.getText());
                insertTab.getChildren().clear();
                insertTab.getChildren().add(tableByName.createInsertsForTable());
                tabName.setText(tableByName.getTableName());
            }
        });
    }

    @FXML
    private void onOpenFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selectionner un script sql");
        File fileUrl = fileChooser.showOpenDialog(null);
        try {
            cnx = new SQLConnection(fileUrl.getPath());
            schema = new SQLSchema();
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTablesView();
    }

}
