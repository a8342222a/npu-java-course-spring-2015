/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Model  extends java.util.Observable {
     String digital ="";
     int x,y;
     String z;
    
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    
    public void appendDigit(int digit) {
       
       digital += String.valueOf(digit);
        getDisplay();
        // TODO code application logic here
    }
    
    public void appendDot(String dot) {
        digital  += dot;
        getDisplay();
        // TODO code application logic here
    }
    
    public void performOperation(Operator operator) {
        if(operator == Operator.SQRT)
        {
            digital = String.valueOf(Math.sqrt(Integer.parseInt(digital)));
             getDisplay();
        }
        if(operator == Operator.PLUS_MINUS)
        {
            if(Integer.parseInt(digital)>0)
            {          
                digital = "-"+ digital;
                 getDisplay();
            }else{
                digital =  String.valueOf((int)Math.abs(Integer.parseInt(digital))) ;
                 getDisplay();
            }
            
        }
        if(operator == Operator.PLUS)
        {
            x = Integer.parseInt(digital); 
            digital = "";
            z = "+";
          
        }
         if(operator == Operator.MINUS)
        {
            x = Integer.parseInt(digital); 
            digital = "";
            z = "-";
            
        }
         if(operator == Operator. TIMES)
        {
            x = Integer.parseInt(digital); 
            digital = "";
            z = "*";
            
        }
           if(operator == Operator.OVER)
        {
            x = Integer.parseInt(digital); 
            digital = "";
            z = "/";
            
        }
           
        if(operator == Operator.EQUAL)
        {
            if(z == "+")
            {
                 y = Integer.parseInt(digital); 
                digital = String.valueOf(x+y);
                getDisplay();
                digital = "";
            }
            if(z == "-")
            {
                 y = Integer.parseInt(digital); 
                digital = String.valueOf(x-y);
                getDisplay();
                digital = "";
            }
             if(z == "*")
            {
                 y = Integer.parseInt(digital); 
                digital = String.valueOf(x*y);
                getDisplay();
                digital ="";
            }
              if(z == "/")
            {
                 y = Integer.parseInt(digital); 
                digital =String.valueOf(x/y);
                getDisplay();
                digital = "";
            }
           
            
        }
    
        // TODO code application logic here
    }
    
     public void setOperator(String operator) {
         if(operator == "+") performOperation(Operator.PLUS); 
          if(operator =="＝")performOperation(Operator.EQUAL);   
          if(operator =="-") performOperation(Operator. MINUS); 
          if(operator =="*") performOperation(Operator.TIMES); 
          if(operator =="/") performOperation(Operator.OVER); 
          if(operator == "±") performOperation(Operator.PLUS_MINUS);
          if(operator == "√") performOperation(Operator.SQRT);
        
    }
     
     
    public String getDisplay() {   
        setChanged();
	notifyObservers(digital);
        return null;
    }
    

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        // TODO code application logic here
    }
*/
}
