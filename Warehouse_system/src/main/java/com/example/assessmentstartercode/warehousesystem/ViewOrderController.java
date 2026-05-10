package com.example.assessmentstartercode.warehousesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class ViewOrderController {
    @FXML
    private ListView<String> productListView;

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
        Stage stage = (Stage) productListView.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inside.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }


    private void updateList() {
        productListView.getItems().clear();
        labelText.setText("List of items orders");
        for (Map.Entry<Item, Integer> entry : MidLayer.shop.getOrdersMap().entrySet()) {
            String info = entry.getKey().getItemName() + " | Qty: " + entry.getValue();
            productListView.getItems().add(info);
        }
    }
}