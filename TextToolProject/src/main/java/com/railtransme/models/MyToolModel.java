/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railtransme.models;

import com.railtransme.entities.MyTool;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */
@Component
public class MyToolModel {

        @Getter @Setter
        private MyTool myTool;
       


}


