/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railtransme.ui;

import com.railtransme.models.MyToolModel;
import com.railtransme.repositories.MyToolRepository;
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
    
    void clearEditor(){
        model.getTagProperty().set("");
        model.getTextProperty().set("");
        
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
    void setDisableND() {
       
        controller.getNewButton().setDisable(true);
        controller.getSaveButton().setDisable(false);
        controller.getCancelButton().setDisable(false);
        controller.getDeleteButton().setDisable(true);
        
    }
    
    void disableListView(){
        controller.getSearchTextField().setDisable(true);
        controller.getListView().setDisable(true);
    }
    void enableListView(){
        controller.getSearchTextField().setDisable(false);
        controller.getListView().setDisable(false);
    }




}
