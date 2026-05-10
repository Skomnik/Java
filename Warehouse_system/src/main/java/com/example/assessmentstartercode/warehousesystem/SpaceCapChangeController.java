package com.example.assessmentstartercode.warehousesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SpaceCapChangeController {

    @FXML
    private ComboBox<String> itemComboBox;
    @FXML
    private TextField oldquantityField;
    @FXML
    private TextField newquantityField;
    @FXML
    private Label statusLabel;


    @FXML
    public void initialize() {
        oldquantityField.setEditable(false);
        for (Item item : MidLayer.shop.getItemsMap().keySet()) {
            itemComboBox.getItems().add(item.getItemName());
        }
        itemComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Item selectedItem = findItemByName(newValue);
                if (selectedItem != null) {
                    oldquantityField.setText(Integer.toString(selectedItem.getReorderPoint()));
                    statusLabel.setText("Done");
                }
            }
        });
    }

    @FXML
    private void handleSell() {
        String selectedName = itemComboBox.getValue();
        String qtyText = newquantityField.getText();
        if (selectedName == null || qtyText.isEmpty()) {
            statusLabel.setText("Error. Choose item and enter number.");
            return;
        }

        try {
            int quantity = Integer.parseInt(qtyText);
            if (quantity < 1 || quantity > 9999) {
                statusLabel.setText("Must be between 1 and 9999.");
                return;
            }

            Item selectedItem = findItemByName(selectedName);

            if (selectedItem == null) {
                statusLabel.setText("Item not found.");
                return;
            }

            selectedItem.setReorderPoint(quantity);
            oldquantityField.setText(String.valueOf(quantity));
            newquantityField.clear();
            statusLabel.setText("Changed");

        } catch (NumberFormatException e) {
            statusLabel.setText("Error. Must be numbers.");
        }
    }


    @FXML
    private void onBackClick() throws IOException {
        Stage stage = (Stage) itemComboBox.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inside.fxml"));
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