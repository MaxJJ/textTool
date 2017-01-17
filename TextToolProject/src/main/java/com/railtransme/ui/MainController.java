/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railtransme.ui;

import com.railtransme.entities.MyTool;
import com.railtransme.repositories.MyToolRepository;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author User
 */

public class MainController implements Initializable {
@Autowired
private MyToolRepository repo;
@Autowired
private SettingService set;
@Autowired
private ActionsService act;

    @FXML @Getter
    private ListView<MyTool> listView;
    @FXML @Getter
    private Button newButton;
  @FXML @Getter
    private Button saveButton;
    @FXML @Getter
    private Button cancelButton;
    @FXML @Getter
    private Button deleteButton;
    @FXML @Getter
    private TextField searchTextField;
    @FXML @Getter
    private TextField tagTextField;
    @FXML @Getter
    private TextArea itemTextArea;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
        
    }  
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init(){
      
        set.searchTextField();
        set.listView();
        set.newButton();
        set.deleteButton();
        set.cancelButton();
        set.saveButton();
        
        
    }

}
