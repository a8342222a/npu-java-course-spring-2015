/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import tw.edu.npu.mis.Model.Operator;


public class Controller {
  /**
    *宣告 Model mModel變數 和 Computer mView變數 
    */    
    Model mModel;
   Computer mView;
   
   /**
    * 讓Controller 知道Model 的屬性和方法 
    */
    public Controller(/*Computer view,*/Model model) {
       // mView = view;
       mModel = model;  
    }
    /**
     * 
     * 傳遞數字
     */
    public void setData(String data)
    {
        mModel.appendDigit(Integer.parseInt(data));
        
    }
    /**
     * 傳遞點
     */
    public void setDot(String dot)
    {
        mModel.appendDot(dot);
    }
    /**
     * 傳遞運算符號
     */
    public void setOperator(String operator)
    {
        mModel.setOperator(operator);
    }
    
    /**
     * 新增view 到Controller
     */
    public void addView(Computer view){
		mView = view;
                mModel.getDisplay();
   
    }
    
  
}
