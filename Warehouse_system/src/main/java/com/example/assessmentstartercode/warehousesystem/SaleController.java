package com.example.assessmentstartercode.warehousesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SaleController {

    @FXML
    private ComboBox<String> itemComboBox;
    @FXML
    private TextField quantityField;
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
        String qtyText = quantityField.getText();
        if (selectedName == null || qtyText.isEmpty()) {
            statusLabel.setText("Error. Choose item and quantity.");
            return;
        }
        try {
            int quantity = Integer.parseInt(qtyText);
            if (quantity < 1 || quantity > 9999) {
                statusLabel.setText("Quantity must be between 1 and 9999.");
                return;
            }
            Item selectedItem = findItemByName(selectedName);
            if (selectedItem == null) {
                statusLabel.setText("Item not found.");
                return;
            }
            int available = MidLayer.shop.getItemQuantity(selectedItem);
            if (quantity > available) {
                statusLabel.setText("Not enough stock.");
                return;
            }
            MidLayer.shop.sellItem(selectedItem, quantity);
            statusLabel.setText("Sale successful.");
            quantityField.clear();
        } catch (NumberFormatException e) {
            statusLabel.setText("Error. Must be a number.");
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