/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railtransme.ui;

import com.railtransme.entities.MyTool;
import com.railtransme.models.MyToolModel;
import com.railtransme.repositories.MyToolRepository;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maksims
 */
@Service
public class ActionsService {
 @Autowired
private MyToolRepository repo;

@Autowired
private MainController controller;
@Autowired
private SettingService set;  
@Autowired
private MyToolModel model;

   public ChangeListener searchTextFieldChangeListener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public ChangeListener listViewChangeListener() {
       return (ChangeListener) (ObservableValue observable, Object oldValue, Object newValue) -> {
           controller.getListView().getItems().clear();
           controller.getListView().setItems((ObservableList<MyTool>) newValue);
       };
         
    }

   public EventHandler<ActionEvent> saveButtonEventHandler() {
       return (ActionEvent event) -> {
           
         repo.save(model.getMyTool());
         controller.getListView().itemsProperty().getValue().add(model.getMyTool());
       };
    }


}
