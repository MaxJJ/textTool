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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
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
private MyToolModel model;
   
@Autowired
private MainController controller;
@Autowired
private ActionsService act;

    void searchTextField() {
        
        controller.getSearchTextField().textProperty().addListener(searchTextFieldChangeListener());
        controller.getSearchTextField().setOnKeyPressed(searchTextFieldOnKeyPressed());
    }

    void listView() {
        
        controller.getListView().setItems(listItems(repo.findAll()));
        controller.getListView().itemsProperty().addListener(listViewChangeListener());
        controller.getListView().setCellFactory(listViewCallback());
        controller.getListView().getSelectionModel().selectedItemProperty().addListener(selectionChangeListener());
        bindModel();
        
    }

    void newButton() {
        controller.getNewButton().setOnAction((eh)->{ 
            MyTool newItem = new MyTool();
            model.setMyTool(newItem);
            act.setDisableND();
            act.disableListView();
        });
     
    }

    void deleteButton() {
      controller.getDeleteButton().setOnAction((eh)->{ 
         MyTool obj = model.getMyTool();
         repo.delete(obj);
         act.clearAndFill();
         act.setDisableSCD();
      });
    }

    void cancelButton() {
        Button cancelButton = controller.getCancelButton();
        TextField searchTf = controller.getSearchTextField();
        
        cancelButton.setOnAction((eh)->{
            searchTf.requestFocus();
                searchTf.textProperty().set("");
                act.setDisableSCD();
                act.enableListView();
                act.clearEditor();
                });
       
    }

    void saveButton() {
        
        controller.getSaveButton().setOnAction(saveButtonEventHandler());
        
    }
    void upperCaseButton() {
        
        controller.getUpperCaseButton().setOnAction((eh)->{ 
         String text = model.getTextProperty().getValueSafe();
        model.getTextProperty().setValue(text.toUpperCase());   
        });
    }

    public ObservableList<MyTool> listItems(List<MyTool> list) {
        
        return FXCollections.observableArrayList(list);
    }
    
       public ChangeListener searchTextFieldChangeListener() {
       return (ChangeListener) (ObservableValue ov, Object t, Object t1) -> {
           
         List<MyTool> list=  repo.findByTagLikeIgnoreCase("%"+t1+"%");
         controller.getListView().itemsProperty().getValue().clear();
         controller.getListView().itemsProperty().getValue().addAll(list);
       };
    }

        private EventHandler<? super KeyEvent> searchTextFieldOnKeyPressed() {
       return new EventHandler<KeyEvent>() {
           @Override
           public void handle(KeyEvent t) {
               
               if(t.getCode()==KeyCode.ENTER){
                 controller.getListView().requestFocus();
               }
           }
       };
    }
   public ChangeListener listViewChangeListener() {
       return (ChangeListener) (ObservableValue observable, Object oldValue, Object newValue) -> {
           controller.getListView().getItems().clear();
           controller.getListView().setItems((ObservableList<MyTool>) newValue);
       };
         
    }

   public EventHandler<ActionEvent> saveButtonEventHandler() {
       return (ActionEvent event) -> {
           MyTool item = model.getMyTool();
           item.setTag(model.getTagProperty().getValueSafe());
           item.setItem(model.getTextProperty().getValueSafe());
           
         repo.save(item);
         ObservableList<MyTool> mylist = controller.getListView().getItems();
         int index = mylist.indexOf(item);
         if(index<0){
           mylist.add(item);
         }else{
           mylist.set(index, item);
         }
        
         act.setDisableSCD();
         act.clearEditor();
         act.enableListView();
         controller.getSearchTextField().requestFocus();
       };
    }

    public Callback<ListView<MyTool>, ListCell<MyTool>> listViewCallback() {
        return (ListView<MyTool> p) -> {
            TextFieldListCell<MyTool> cell = new TextFieldListCell<>();
            cell.setConverter(new StringConverter<MyTool>() {
                @Override
                public String toString(MyTool t) {
                    return t.getTag();
                }
                
                @Override
                public MyTool fromString(String string) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            return cell;
        };
    }

   

    private void bindModel() {
        
        model.getTagProperty().bindBidirectional(controller.getTagTextField().textProperty());
        model.getTextProperty().bindBidirectional(controller.getItemTextArea().textProperty());
    }

    private ChangeListener selectionChangeListener() {
        
    return (ChangeListener<MyTool>) (ObservableValue<? extends MyTool> ov, MyTool t, MyTool t1) -> {
       if(t1==null){t1=new MyTool();}
        model.setMyTool(t1);
         controller.getSaveButton().setDisable(false);
         act.setDisableN();
    };
    }

    
}
