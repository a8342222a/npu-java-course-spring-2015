/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 *
 * @author daniel
 */
public class Controller {
      
    private final Calculator mModel; 
    private final Computer mView;
   
    public Controller(Calculator model,Computer controller) {
        mModel = model;
        mView = controller;
    }


    public void setData()
    {
        
    }
}
