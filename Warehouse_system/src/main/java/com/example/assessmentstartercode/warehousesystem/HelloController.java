package com.example.assessmentstartercode.warehousesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class HelloController {
    @FXML
    private TextField loginfield;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label welcomeText;
    @FXML
    private ChoiceBox<String> dataChoiceBox;

    @FXML
    protected void onOkButtonClick() throws Exception {
        String selectedOption = dataChoiceBox.getValue();

        if (selectedOption.equals("Load from file")) {

            Shop loadedShop = MidLayer.shop.readFromFile("shop.sav");
            Buffer loadedBuffer = MidLayer.buffer.readFromFile("buffer.sav");

            if (loadedShop != null) {
                MidLayer.shop = loadedShop;
                System.out.println("File not found. Default data is used.");
            }
            if (loadedBuffer != null) {
                MidLayer.buffer = loadedBuffer;
                System.out.println("File not found. Default data is used.");
            }
        }

        for (var entry : MidLayer.buffer.stock.entrySet()) {
            MidLayer.buffer.checkSupplierNeed(entry.getKey());
            //MidLayer.buffer.fulfillSupplierOrder(entry.getKey());
            System.out.println("auto check to supplier");
        }

        String login = loginfield.getText();
        String pass = passwordField.getText();

        boolean salesauthorized = false;
        for (Employee e : MidLayer.salesassoc) {
            if (e.login(login, pass)) {
                salesauthorized = true;
                break;
            }
        }

        boolean warehouseauthorized = false;
        if (!salesauthorized) {
            for (Employee e : MidLayer.warehouseassoc) {
                if (e.login(login, pass)) {
                    warehouseauthorized = true;
                    break;
                }
            }
        }

        boolean managersauthorized = false;
        if (!salesauthorized && !warehouseauthorized) {
            for (Employee e : MidLayer.managers) {
                if (e.login(login, pass)) {
                    managersauthorized = true;
                    break;
                }
            }
        }

        if (salesauthorized) {
            Stage stage = (Stage) loginfield.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inside.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } else if (warehouseauthorized) {
            Stage stage = (Stage) loginfield.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wareinside.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } else if (managersauthorized) {
            Stage stage = (Stage) loginfield.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("managerInside.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } else {
            welcomeText.setText("Wrong login or password!");
        }
    }

    @FXML
    public void initialize() {
        dataChoiceBox.getItems().addAll("Load from file", "Use default data");
        dataChoiceBox.setValue("Load from file");
    }

    @FXML
    protected void onCloseButtonClick() throws Exception {
        MidLayer.shop.writeToFile("shop.sav");
        MidLayer.buffer.writeToFile("buffer.sav");
        System.exit(0);
    }
}