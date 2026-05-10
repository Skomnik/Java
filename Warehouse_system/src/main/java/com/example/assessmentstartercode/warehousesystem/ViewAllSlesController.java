package com.example.assessmentstartercode.warehousesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class ViewAllSlesController {
    @FXML
    private ListView<String> allsalesListView;

    @FXML
    public void initialize() {
        updateList();
    }

    @FXML
    private Label labelText;

    @FXML
    protected void onCloseButtonClick() throws Exception {
        MidLayer.shop.writeToFile("shop.sav");
        MidLayer.buffer.writeToFile("buffer.sav");
        System.exit(0);
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        Stage stage = (Stage) allsalesListView.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("managerinside.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

    }


    private void updateList() {
        allsalesListView.getItems().clear();
        labelText.setText("All sales");
        for (Map.Entry<Item, Integer> entry : MidLayer.shop.getAllsales().entrySet()) {
            String info = entry.getKey().getItemName() + " | Qty: " + entry.getValue();
            allsalesListView.getItems().add(info);
        }
    }
}
