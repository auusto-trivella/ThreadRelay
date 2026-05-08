/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author trivella.augusto
 */
public class Atleta extends Thread {

    private Testimone box;
    private int idAtleta;

    public Atleta(Testimone box, int idAtleta) {
        this.box = box;
        this.idAtleta = idAtleta;
    }

    public void run() {
        try {
            synchronized (box) {
                // aspetta il suo turno
                while (box.getStato() != idAtleta) {
                    box.wait();
                }
            }

            System.out.println("Atleta " + idAtleta + " è partito!");

            for (int metri = 0; metri <= 90; metri += 10) {
                Thread.sleep(100); 
                if (metri == 90) {
                    System.out.println("Atleta " + idAtleta + " ai 90m: CHIAMATA CAMBIO!");

                    box.passaTestimone(idAtleta);
                }
            }

            Thread.sleep(100);
            System.out.println("Atleta " + idAtleta + " ha terminato i suoi 100m.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
