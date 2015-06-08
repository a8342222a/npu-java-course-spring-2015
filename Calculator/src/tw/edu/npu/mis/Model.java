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
     String z,data;
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
       data = digital;
        getDisplay();
        // TODO code application logic here
    }
    
    public void appendDot(String dot) {
        digital  += dot;
        System.out.print(digital);
        getDisplay();
        // TODO code application logic here
    }
    
    public void performOperation(Operator operator) {
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
                digital = "";
                data = String.valueOf(x+y);
                getDisplay();
            }
            if(z == "-")
            {
                 y = Integer.parseInt(digital); 
                digital = "";
                data = String.valueOf(x-y);
                getDisplay();
            }
             if(z == "*")
            {
                 y = Integer.parseInt(digital); 
                digital = "";
                data = String.valueOf(x*y);
                getDisplay();
            }
              if(z == "/")
            {
                 y = Integer.parseInt(digital); 
                digital = "";
                data =String.valueOf(x/y);
                System.out.print(data);
                getDisplay();
            }
           
            
        }
    
        // TODO code application logic here
    }
    
     public void setOperator(String operator) {
         if(operator == "+")
         {
            performOperation(Operator.PLUS); 
         }
          if(operator =="＝")
         {
            performOperation(Operator.EQUAL); 
         }
          if(operator =="-")
          {
               performOperation(Operator. MINUS); 
          }
            if(operator =="*")
          {
               performOperation(Operator.TIMES); 
          }
              if(operator =="/")
          {
               performOperation(Operator.OVER); 
          }
    }
     
     
    public String getDisplay() {   
        setChanged();
	notifyObservers(data);
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
