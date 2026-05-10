package com.example.assessmentstartercode.warehousesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddNewItemController {
    @FXML
    private TextField itemIdField;
    @FXML
    private TextField itemNameField;
    @FXML
    private TextField itemPriceField;
    @FXML
    private TextField pcsInPackageField;
    @FXML
    private TextField packagesInPalletField;
    @FXML
    private TextField reorderPointField;
    @FXML
    private Label statusLabel;


    @FXML
    private void onAddItemClick() {

        try {
            String id = itemIdField.getText().trim();
            String name = itemNameField.getText().trim();

            double price = Double.parseDouble(itemPriceField.getText().trim());
            int pcs = Integer.parseInt(pcsInPackageField.getText().trim());
            int packs = Integer.parseInt(packagesInPalletField.getText().trim());
            int reorder = Integer.parseInt(reorderPointField.getText().trim());

            Item newItem = new Item(id, name, price, pcs, packs, reorder);

            MidLayer.shop.fillItems(newItem, 0);
            MidLayer.buffer.fillItems(newItem, 0);

            statusLabel.setText("Item added successfully");

            //clear all fields
            itemIdField.clear();
            itemNameField.clear();
            itemPriceField.clear();
            pcsInPackageField.clear();
            packagesInPalletField.clear();
            reorderPointField.clear();

        } catch (NumberFormatException e) {
            statusLabel.setText("Enter correct numeric values");
        } catch (Exception e) {
            statusLabel.setText("Error creating item");
        }
    }

    @FXML
    private void onBackClick() throws IOException { //action on back click
        Stage stage = (Stage) itemIdField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("managerInside.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }

}