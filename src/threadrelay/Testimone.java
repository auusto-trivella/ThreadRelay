/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Testimone {
    private int stato = 0; // Iniziamo da 0 per aspettare il "VIA"
    private final PropertyChangeSupport support;

    public Testimone() {
        // Inizializza il supporto per i listener
        support = new PropertyChangeSupport(this);
    }

    // Metodi per gestire gli osservatori
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public synchronized void setStato(int nuovoStato) {
        int vecchioStato = this.stato;
        this.stato = nuovoStato;
        // Notifica il cambiamento ai listener (la Form)
        support.firePropertyChange("stato", vecchioStato, nuovoStato);
        // Sveglia i thread Atleti in attesa
        notifyAll();
    }

    public synchronized void passaTestimone(int attuale) {
        if (this.stato == attuale) {
            setStato(this.stato + 1);
        }
    }

    public synchronized int getStato() {
        return stato;
    }
}
/*
    public synchronized void passaTestimone(int attuale) {
        if (this.stato == attuale) {
            this.stato++; 
            notifyAll();
        }
    }

    public synchronized int getStato() {
        return stato;
    }
*/
