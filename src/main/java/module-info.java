module com.app.dictionary {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires google.api.client;
    requires com.google.api.client.json.gson;
    requires com.google.api.services.translate;
    requires com.google.api.client.json.jackson2;
    requires com.google.api.client;


    opens com.app.dictionary to javafx.fxml;
    exports com.app.dictionary;
    exports com.app.dictionary.base;
}