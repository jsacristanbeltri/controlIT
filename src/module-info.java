module ControlIT {
    requires javafx.controls;
    requires javafx.fxml;

    opens Inventory;
    opens Management;
    opens sample;
    opens User;
}

