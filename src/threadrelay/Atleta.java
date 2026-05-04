/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 * @author trivella.augusto
 */
public class Atleta extends Thread {
    private Testimone box;
    private int idAtleta;
    private FormStaffetta frame; 


    public Atleta(Testimone box, int idAtleta, FormStaffetta frame) {
        this.box = box;
        this.idAtleta = idAtleta;
        this.frame = frame; 
    }

    @Override
    public void run() {
        try {
            synchronized (box) {

                while (box.getStato() != idAtleta) {
                    box.wait();
                }
            }

            if (frame != null) {
                frame.aggiornaInterfaccia(idAtleta);
            }

            System.out.println("Atleta " + idAtleta + " ha preso il testimone");
            Thread.sleep(1500); // Simula la corsa
            System.out.println("Atleta " + idAtleta + " ha passato il testimone");


            box.passaTestimone(idAtleta);
            
            if (idAtleta == 4 && frame != null) {
                frame.aggiornaInterfaccia(5); 
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}