/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railtransme.ui;

import com.railtransme.entities.MyTool;
import com.railtransme.models.MyToolModel;
import com.railtransme.repositories.MyToolRepository;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javax.annotation.PostConstruct;
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

    void clearAndFill() {
        model.getTagProperty().set("");
        model.getTextProperty().set("");
        controller.getSearchTextField().requestFocus();
      controller.getListView().getItems().clear();
        controller.getListView().getItems().addAll(repo.findAll());
    }
@PostConstruct
    void setDisableSCD() {
       
        controller.getNewButton().disableProperty().setValue(Boolean.FALSE);
        controller.getSaveButton().disableProperty().setValue(Boolean.TRUE);
        controller.getCancelButton().disableProperty().setValue(Boolean.TRUE);
        controller.getDeleteButton().disableProperty().setValue(Boolean.TRUE);
        
    }
    void setDisableN() {
       
        controller.getNewButton().setDisable(true);
        controller.getSaveButton().setDisable(false);
        controller.getCancelButton().setDisable(false);
        controller.getDeleteButton().setDisable(false);
        
    }
    void setDisableD() {
       
        controller.getNewButton().setDisable(false);
        controller.getSaveButton().setDisable(false);
        controller.getCancelButton().setDisable(false);
        controller.getDeleteButton().setDisable(true);
        
    }




}
