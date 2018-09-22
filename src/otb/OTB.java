/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otb;

/**
 *
 * @author Shubhashis
 */
public class OTB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread ob = new Thread(new Splash());
        ob.start();
//        Splash ob1 = new Splash();
//        ob1.setVisible(true);
//        LogInRegister ob = new LogInRegister();
////        MainFrame ob = new MainFrame();
//        ob.setVisible(true);
    }
    
}
