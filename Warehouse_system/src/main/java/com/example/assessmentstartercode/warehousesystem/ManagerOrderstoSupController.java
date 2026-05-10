package com.example.assessmentstartercode.warehousesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class ManagerOrderstoSupController {
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("managerInside.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    private void onFulfillOrderClick() throws IOException {
        String selectedInfo = productListView.getSelectionModel().getSelectedItem();
        if (selectedInfo == null) {
            labelText.setText("Choose item");
            return;
        }
        String itemName = selectedInfo.split("\\|")[0].trim();
        Item itemToMove = findItemByName(itemName);

        if (itemToMove != null) {
            System.out.println(itemToMove);
            boolean success = MidLayer.buffer.fulfillSupplierOrder(itemToMove);
            if (success) {
                labelText.setText("Success " + itemName);
                updateList();
            } else {
                System.out.println("Fail");
            }
        } else {
            System.out.println("Null");
        }
    }


    private void updateList() {
        productListView.getItems().clear();
        for (Map.Entry<Item, Integer> entry : MidLayer.buffer.getOrdersMap().entrySet()) {
            String info = entry.getKey().getItemName() + " | Qty: " + entry.getValue();
            productListView.getItems().add(info);
        }
    }

    private Item findItemByName(String name) {
        for (Item i : MidLayer.shop.getItemsMap().keySet()) {
            if (i.getItemName().equals(name)) {
                return i;
            }
        }
        return null;
    }
}