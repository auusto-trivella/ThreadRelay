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

            System.out.println("Atleta " + idAtleta + " ha preso il testimone");
            Thread.sleep(1000);
            System.out.println("Atleta " + idAtleta + " ha passato il testimone");

            box.passaTestimone(idAtleta);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
