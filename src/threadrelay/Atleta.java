package threadrelay;


import threadrelay.Testimone;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
                while (box.getStato() != idAtleta) {
                    box.wait();
                }
            }
            for (int metri = 0; metri <= 100; metri += 10) {
                box.controllaPausa();
                Thread.sleep(box.getVelocita());
                box.aggiornaPosizione(idAtleta, metri);
                if (metri == 90) {
                    box.passaTestimone(idAtleta);
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
