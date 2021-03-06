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
    /**
     * 宣告 各種變數
     */
     String digital ="";
     double x,y,a,b =0,c;
     String z = "",r = "0";
    
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
        MEM_RECALL,   // MR
        Back            // ←
    }
    /**
     * 按下數字的功能
     * @param digit 
     */
    public void appendDigit(int digit) {
       digital += String.valueOf(digit);
        getDisplay();
        // TODO code application logic here
    }
    /**
     * 按下點的功能
     * @param dot
     * 判斷小數點只能有一個
     */
    public void appendDot(String dot) {
        if(digital.indexOf(".")>0)
        {
            
        }else
        {
           digital  += dot;
           getDisplay(); 
        }
        
        // TODO code application logic here
    }
    /**
     * 各種運算功能
     * @param operator 
     */
    public void performOperation(Operator operator) {  
        /**
         * 按下MS 功能
         */
        if(operator == Operator.MEM_SET)
        {
            r = digital;
        }
        /**
         * 按下MC
         */
        if(operator == Operator.MEM_CLEAR)
        {
            r = "0";
        }
        /**
         * 按下MR
         */
        if(operator == Operator.MEM_RECALL)
        {        
           if(r.indexOf(".0")==r.length()-2)
           {
               c = Double.parseDouble(r);
               digital = String.valueOf((int)c);
               b = Double.parseDouble(digital) ;
               getDisplay();
               digital ="" ;
           }else
           {
               digital = r;
               b = Double.parseDouble(digital) ;
               getDisplay();
               digital = "";
           }                  
        }
        /**
         *  按下M+
         */
        if(operator ==Operator.MEM_PLUS)
        {
            
              if(digital =="")
            {  
                r  = String.valueOf((int)b);
                digital =""; 
                getDisplay();
            }else
            {
                r = String.valueOf(Double.parseDouble(r)+ Double.parseDouble(digital));     
                digital = "";
                getDisplay();
            }
        }
         /**
         * 按下M-功能
         */
        if(operator ==Operator.MEM_MINUS)
         {
               if(digital =="")
            {               
                r  = String.valueOf((int)b);
                digital ="";               
            }else
            {
                r = String.valueOf(Double.parseDouble(r)- Double.parseDouble(digital));               
                digital = "";
                getDisplay();
            }
         }
        /**
         * 按下 % 功能 (%功能有錯誤)
         */
         if(digital =="")
         {

         }else
         {
                 if(operator ==Operator.PERCENT)
                 {
                     a = Double.parseDouble(digital);
                     a = a/100;
                     digital = String.valueOf(a);
                     getDisplay();
                 }
         }
      
        /**
         * 按下 1/x 功能
         */
        if(digital =="")
         {

         }else
         {
               if(operator == Operator. RECIPROCAL)
                 {
                     a = Double.parseDouble(digital);
                     a = 1/a;
                     digital = String.valueOf(a);
                     getDisplay();
                 }
         }
       
        /**
         * 按下 ＣE　功能
         */
        if(operator == Operator.CLEAR_ENTRY)
        {
            digital = "0";
            getDisplay();
            digital ="";
        }
        /**
         * 按下 倒退鍵功能
         */
          if(operator == Operator.Back)
          {
              if(digital == "")
              {
                        
              }else
              {
                   if(digital.length()>0) digital = digital.substring(0,digital.length()-1);
                   getDisplay();   
              }
          }
        /**
         * 按下 C  功能
         */
        if(operator == Operator.CLEAR)
         {

                digital = "0";
                b = 0;
                getDisplay();
                digital ="";
         }
        /**
         * 按下 開根號功能
         */
        if(operator == Operator.SQRT)
        {
            if(digital == "")
            {
                
            }else
            {
                 digital = String.valueOf(Math.sqrt(Double.parseDouble(digital)));
                 a= Double.parseDouble(digital); 
                if(digital.indexOf(".0")==digital.length()-2)
                {
                    // System.out.print(a);
                    digital = String.valueOf((int)a);
                    getDisplay();
                }else
                {
                       getDisplay();
                }
            }
           
        }
        /**
         * 正負數轉變功能
         */
        if(operator == Operator.PLUS_MINUS)
        {
             if(digital == "")
             {
                 
             }else    
             {
                 if(Double.parseDouble(digital)>0)
                  {          
                       digital = "-"+ digital;
                       getDisplay();
                  }else{
                       digital =  String.valueOf(Math.abs(Double.parseDouble(digital))) ;
                        if(digital.indexOf(".0")==digital.length()-2)
                        {
                            digital =  String.valueOf((int)Math.abs(Double.parseDouble(digital))) ;
                            getDisplay();
                        }                
                  }   
             }
        }
        /**
         * 按下+功能
         */
        if(operator == Operator.PLUS)
        {
           if(digital.length()>0)
           {
               x = Double.parseDouble(digital); 
                digital = "";
                z = "+"; 
           }else
           {
                x =b;
                b= 0;
                digital = "";
                z = "+"; 
           }           
        }
        /**
         * 按下-功能
         */
         if(operator == Operator.MINUS)
        {
              if(digital.length()>0)
           {
               x = Double.parseDouble(digital); 
                digital = "";
                z = "-"; 
           }else
           {
                x =b;
                b= 0;
                digital = "";
                z = "-"; 
           }  
        }
         /**
          * 按下*功能
          */
         if(operator == Operator. TIMES)
        {
             if(digital.length()>0)
           {
               x = Double.parseDouble(digital); 
                digital = "";
                z = "*"; 
           }else
           {
                x =b;
                b= 0;
                digital = "";
                z = "*"; 
           }  
        }
         /**
          * 按下/功能
          */
           if(operator == Operator.OVER)
        {
              if(digital.length()>0)
           {
               x = Double.parseDouble(digital); 
                digital = "";
                z = "/"; 
           }else
           {
                x =b;              
                digital = "";
                z = "/"; 
           }  
        }
        /**
         * 按下等於功能
         */  
        if(operator == Operator.EQUAL)
        {
            if(z == "+")
            {
                 y = Double.parseDouble(digital); 
                digital = String.valueOf(x+y);
                if(digital.indexOf(".0")==digital.length()-2)
                {
                  digital = String.valueOf((int)(x+y)); 
                 // System.out.print(digital);
                   getDisplay();
                    b = Double.parseDouble(digital);
                   digital = "";
                }
                else
                {
                   getDisplay();
                    b = Double.parseDouble(digital);
                    digital = ""; 
                }
                
            }
            if(z == "-")
            {
                  y = Double.parseDouble(digital); 
                digital = String.valueOf(x-y);
                if(digital.indexOf(".0")==digital.length()-2)
                {
                  digital = String.valueOf((int)(x-y)); 
                 // System.out.print(digital);
                   getDisplay();
                   b = Double.parseDouble(digital);
                   digital = "";
                }
                else
                { 
                   getDisplay();
                   b = Double.parseDouble(digital);
                   digital = ""; 
                }
            }
             if(z == "*")
            {
                  y = Double.parseDouble(digital); 
                digital = String.valueOf(x*y);
                if(digital.indexOf(".0")==digital.length()-2)
                {
                  digital = String.valueOf((int)(x*y)); 
                 // System.out.print(digital);
                   getDisplay();
                   b = Double.parseDouble(digital);
                   digital = "";
                }
                else
                {
                   getDisplay();
                    b = Double.parseDouble(digital);
                    digital = ""; 
                }
            }
              if(z == "/")
            {
                  y = Double.parseDouble(digital); 
                digital = String.valueOf(x/y);
                if(digital.indexOf(".0")==digital.length()-2)
                {
                  digital = String.valueOf((int)(x/y)); 
                //  System.out.print(digital);
                   getDisplay();
                    b = Double.parseDouble(digital);
                   digital = "";
                }
                else
                {
                   getDisplay();
                    b = Double.parseDouble(digital);
                    digital = ""; 
                }
            }           
        }
    }
    
    /**
     * 把Controller丟過來的運符號，依照符號去執行各種功能
     *  operator 拿來存運算符號 
     */
     public void setOperator(String operator) {
         if(operator == "+") performOperation(Operator.PLUS); 
          if(operator =="＝")performOperation(Operator.EQUAL);   
          if(operator =="-") performOperation(Operator. MINUS); 
          if(operator =="*") performOperation(Operator.TIMES); 
          if(operator =="/") performOperation(Operator.OVER); 
          if(operator == "±") performOperation(Operator.PLUS_MINUS);
          if(operator == "√") performOperation(Operator.SQRT);
          if(operator == "C") performOperation(Operator.CLEAR);
          if(operator == "←") performOperation(Operator.Back);
          if(operator == "CE") performOperation(Operator.CLEAR_ENTRY);
          if(operator == "1/x") performOperation(Operator.RECIPROCAL);
          if(operator == "%") performOperation(Operator.PERCENT);
          if(operator == "M+") performOperation(Operator.MEM_PLUS);
          if(operator == "MR") performOperation(Operator.MEM_RECALL);
          if(operator == "MC") performOperation(Operator.MEM_CLEAR);
          if(operator == "M-") performOperation( Operator.MEM_MINUS);
          if(operator == "MS") performOperation( Operator.MEM_SET);
          
         
    }
     
    /**
     * update 資料 
     * @return 
     */ 
    public String getDisplay() {   
        setChanged();
	notifyObservers(digital);
        return null;
    }
}
