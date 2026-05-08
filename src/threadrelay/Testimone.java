/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

import java.util.ArrayList;

public class Testimone implements Subject {
    private int stato = 1, velocita=100;
    private boolean inPausa = false;
    private ArrayList<Observer> osservatori = new ArrayList<>();


    @Override
    public void addObserver(Observer o) {
        osservatori.add(o);
    }


    @Override
    public void notifyObservers(int idAtleta, int metri) {
        for (Observer o : osservatori) {
            o.update(idAtleta, metri);
        }
    }

public void aggiornaPosizione(int idAtleta, int metri) {
    
    for (Observer o : osservatori) {
        o.update(idAtleta, metri);
    }
}

   
    public synchronized void controllaPausa() throws InterruptedException {
        while (inPausa) {
            wait();
        }
    }

    public synchronized void setPausa(boolean b) {
        this.inPausa = b;
        if (!b) notifyAll();
    }

    public synchronized void passaTestimone(int attuale) {
        if (this.stato == attuale) {
            this.stato++;
            notifyAll();
        }
    }

    public synchronized int getStato() {
        return stato;
    }

    public int getVelocita() {
        return velocita;
    }

    public void setVelocita(int velocita) {
        this.velocita = velocita;
    }

    @Override
    public void removeObserver(Observer o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}