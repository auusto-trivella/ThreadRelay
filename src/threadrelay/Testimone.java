/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

import java.util.ArrayList;

public class Testimone implements Subject {
    private int stato = 1;
    private boolean inPausa = false;
    private ArrayList<Observer> osservatori = new ArrayList<>();

    // METODO 1: Per l'interfaccia Subject
    @Override
    public void addObserver(Observer o) {
        osservatori.add(o);
    }

    // METODO 2: Per l'interfaccia Subject (notifica i metri)
    @Override
    public void notifyObservers(int idAtleta, int metri) {
        for (Observer o : osservatori) {
            o.update(idAtleta, metri);
        }
    }

    // METODO 3: Quello che chiama l'Atleta per far muovere la barra
    public void aggiornaPosizione(int id, int m) {
        notifyObservers(id, m);
    }

    // METODO 4: Per gestire il tasto Ferma/Continua
    public synchronized void controllaPausa() throws InterruptedException {
        while (inPausa) {
            wait(); // Il thread si ferma qui
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

    @Override
    public void removeObserver(Observer o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}