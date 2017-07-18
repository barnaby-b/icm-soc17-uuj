package hr.icm.soc17.examples.loginapp.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginAppController {

	@FXML
	private GridPane mainGrid;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField passwordTextField;
	
	@FXML
	private Label loginMessage;

	public LoginAppController() {
		
	}
	
	public void initialize() {
		loginMessage.setText("");
	}
}
