package com.example.assessmentstartercode.warehousesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteItemController {

    @FXML
    private ComboBox<String> itemComboBox;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        for (Item item : MidLayer.shop.getItemsMap().keySet()) {
            itemComboBox.getItems().add(item.getItemName());
        }
    }

    @FXML
    private void handleSell() {
        String selectedName = itemComboBox.getValue();

        if (selectedName == null) {
            statusLabel.setText("Error. Choose item");
            return;
        }
        Item selectedItem = findItemByName(selectedName);

        if (selectedItem == null) {
            statusLabel.setText("Item not found");
            return;
        }

        MidLayer.shop.getItemsMap().remove(selectedItem);
        MidLayer.buffer.getItemsMap().remove(selectedItem);
        statusLabel.setText("Deleted: " + selectedName);
    }

    @FXML
    private void onBackClick() throws IOException {
        Stage stage = (Stage) itemComboBox.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("managerInside.fxml")
        );
        stage.setScene(new Scene(fxmlLoader.load()));
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