/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import tw.edu.npu.mis.Model.Operator;

/**
 *
 * @author daniel
 */
public class Controller {
      
    Model mModel;
   Computer mView;
   
    public Controller(/*Computer view,*/Model model) {
       // mView = view;
       mModel = model;  
    }
 
    public void setData(String data)
    {
        mModel.appendDigit(Integer.parseInt(data));
        mView.test();
    }
    
    public void setDot(String dot)
    {
        mModel.appendDot(dot);
    }
    
    public void setOperator(String operator)
    {
        mModel.setOperator(operator);
    }
    
    public void addView(Computer view){
		mView = view;
                mModel.getDisplay();
   
    }
    
  
}
