/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railtransme.ui;

import com.railtransme.entities.MyTool;
import com.railtransme.repositories.MyToolRepository;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maksims
 */
@Service
public class SettingService {
    @Autowired
private MyToolRepository repo;
   
@Autowired
private MainController controller;
@Autowired
private ActionsService act;

    void searchTextField() {
        
        controller.getSearchTextField().textProperty().addListener(act.searchTextFieldChangeListener());
    }

    void listView() {
        controller.getListView().setItems(listItems(repo.findAll()));
        controller.getListView().itemsProperty().addListener(act.listViewChangeListener());
    }

    void newButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deleteButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void cancelButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void saveButton() {
        
        controller.getSaveButton().setOnAction(act.saveButtonEventHandler());
    }

    public ObservableList<MyTool> listItems(List<MyTool> list) {
        
        return FXCollections.observableArrayList(list);
    }
    
}
