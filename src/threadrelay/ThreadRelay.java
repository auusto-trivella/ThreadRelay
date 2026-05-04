/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadrelay;


public class ThreadRelay {

    public static void main(String[] args) {
            
FormStaffetta frame = new FormStaffetta();
            frame.setTitle("Staffetta 4x100 - Chiamata Diretta");
            frame.setVisible(true);

            Testimone testimone = new Testimone();

            Atleta a1 = new Atleta(testimone, 1, frame);
            Atleta a2 = new Atleta(testimone, 2, frame);
            Atleta a3 = new Atleta(testimone, 3, frame);
            Atleta a4 = new Atleta(testimone, 4, frame);

            a1.start();
            a2.start();
            a3.start();
            a4.start();
    }
}
