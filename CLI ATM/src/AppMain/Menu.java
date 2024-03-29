/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppMain;

/**
 * 
 * @author Andika Risky Septiawan
 */
import java.io.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Menu {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(isr);
    
    Utama ut = new Utama();
    
    public void clear() throws AWTException {
        Robot rob = new Robot();
        try {
            rob.keyPress(KeyEvent.VK_CONTROL);
            rob.keyPress(KeyEvent.VK_L);
            rob.keyRelease(KeyEvent.VK_L);
            rob.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    
    public void Delayy() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }
    
    public void menu() throws IOException, AWTException {
        clear();
        System.out.println("Selamat Datang di Desktop Banking BROLink");
        System.out.println("=====================================");
        System.out.println("Pilih menu lalu ketik angka (cth: 1),\nselanjutnya tekan enter");
        System.out.println("1. Login/Masuk \n2. Register/Daftar \n3. Lupa pin \n4. (Mode Admin) \n\n0. Keluar\n");
        System.out.print("Pilihan Anda --> ");
        String pilihan = input.readLine().trim();
        
        switch (pilihan) {
            case "1" :
                clear();
                ut.login("menuLogin");
                this.menu();
                break;
            case "2" :
                clear();
                ut.registerData();
                this.menu();
                break;
            case "3" :
                clear();
                ut.lupaPin();
                this.menu();
                break;
            case "4" :
                clear();
                ut.login("modeAdmin");
                this.menu();
                break;
            case "0" :
                System.exit(0);
                break;
            default:
                this.menu();
                break;
        }
    }
    
    public static void main(String[] args) throws IOException, AWTException {
        Menu m = new Menu();
        m.menu();
    }
}
