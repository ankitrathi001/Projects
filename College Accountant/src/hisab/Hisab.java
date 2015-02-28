/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hisab;

/**
 *
 * @author Anshul
 */
public class Hisab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
}
