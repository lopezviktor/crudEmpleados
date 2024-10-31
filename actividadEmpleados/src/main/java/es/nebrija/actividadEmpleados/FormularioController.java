package es.nebrija.actividadEmpleados;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class FormularioController {

    @FXML
    private Button btnAddEmpleado;

    @FXML
    private Button btnEditarEmpleado;

    @FXML
    private TableColumn<?, ?> idApellidos;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> idDireccion;

    @FXML
    private TableColumn<?, ?> idNombre;

    @FXML
    private TableColumn<?, ?> idSalario;

    @FXML
    private TableColumn<?, ?> idTelefono;

    @FXML
    void switchToAddEmpleado(ActionEvent event) throws IOException {
    	App.setRoot("addEmpleado");
    }

    @FXML
    void switchToEditarEmpleado(ActionEvent event) throws IOException{
    	App.setRoot("editEmpleado");
    }
}
