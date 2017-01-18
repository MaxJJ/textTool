/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railtransme.models;

import com.railtransme.entities.MyTool;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class MyToolModel {

        @Getter 
        private MyTool myTool;
       @Getter
        private StringProperty tagProperty = new SimpleStringProperty();
       @Getter
        private StringProperty textProperty = new SimpleStringProperty();

    public void setMyTool(MyTool myTool) {
        this.myTool = myTool;
        tagProperty.setValue(this.myTool.getTag());
        textProperty.setValue(this.myTool.getItem());
    }

        

}


