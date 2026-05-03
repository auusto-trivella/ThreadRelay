package threadrelay;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingUtilities;

public class FormStaffetta extends javax.swing.JFrame implements PropertyChangeListener {

    // Usiamo la variabile che NetBeans ha già dichiarato in fondo alla classe
    // private javax.swing.JLabel jLabel1; 

    public FormStaffetta() {
        initComponents();
        // Invece di creare una nuova label, usiamo quella dell'interfaccia di NetBeans
        jLabel1.setText("In attesa del via...");
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.setLocationRelativeTo(null); 
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("stato".equals(evt.getPropertyName())) {
            int nuovoValore = (int) evt.getNewValue();
            
            SwingUtilities.invokeLater(() -> {
                if (nuovoValore <= 4) {
                    jLabel1.setText("<html><div style='text-align: center;'><h2>GARA IN CORSO</h2>"
                            + "Atleta attuale: <b style='font-size:18px; color:blue;'>" + nuovoValore + "</b></div></html>");
                } else {
                    jLabel1.setText("<html><h2 style='color:green;'>GARA CONCLUSA!</h2>Tutti hanno corso.</html>");
                }
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
        // 1. Setup Look & Feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Loggare errore se necessario
        }

        // 2. Avvio dell'applicazione
        java.awt.EventQueue.invokeLater(() -> {
            // Crea la finestra
            FormStaffetta frame = new FormStaffetta();
            frame.setVisible(true);

            // Crea il Motore della staffetta
            Testimone testimone = new Testimone();
            testimone.addPropertyChangeListener(frame); // La finestra osserva il testimone

            // Avvia i thread atleti
            for (int i = 1; i <= 4; i++) {
                new Atleta(testimone, i).start();
            }

            // Piccolo thread per dare il "VIA" dopo 2 secondi
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    testimone.setStato(1); 
                } catch (InterruptedException e) {}
            }).start();
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Staffetta Thread Relay");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE(388, Short.MAX_VALUE) )
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
