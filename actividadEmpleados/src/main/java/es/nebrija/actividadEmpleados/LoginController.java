package es.nebrija.actividadEmpleados;

import java.io.IOException;

import es.nebrija.actividadEmpleados.dao.UsuarioDao;
import es.nebrija.actividadEmpleados.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController {

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtPassword;

    private UsuarioDao usuarioDao = new UsuarioDao();
    
    @FXML
    void switchTologin(ActionEvent event) {

    	String nombreUsuario = txtNombreUsuario.getText();
    	String password = txtPassword.getText();
    	
    	Usuario usuario = usuarioDao.validarUsuario(nombreUsuario, password);
    	
    	if (usuario != null) {
    		showAlert("Login correcto", "Bienvenido" + usuario.getNombreUsuario());
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
    		try {
    	        Stage stage = (Stage) txtNombreUsuario.getScene().getWindow();
    	        stage.getScene().setRoot(loader.load());
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	        showAlert("Error", "No se pudo cargar la pantalla de formulario.");
    	    }
    	} else {
    		showAlert("Error", "Nombre de usuario o contraseña incorrectos");
    	}
    }
    
    @FXML
    void switchToRegistro(ActionEvent event) {

    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("registro.fxml"));
    		Stage stage = (Stage) txtNombreUsuario.getScene().getWindow();
            stage.getScene().setRoot(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    

}
