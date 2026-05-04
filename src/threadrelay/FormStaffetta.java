
package threadrelay;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class FormStaffetta extends javax.swing.JFrame {

    // Array di pannelli e label per gestire i 4 atleti facilmente
    private JPanel[] pannelliAtleti = new JPanel[4];
    private JLabel[] labelStatoAtleti = new JLabel[4];
    private JLabel labelMessaggioPrincipale;

    public FormStaffetta() {
        initComponents();
        this.setTitle("Gara di Staffetta 4x100");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        // Layout principale: un bordo con padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // 1. Titolo e Messaggio in alto
        labelMessaggioPrincipale = new JLabel("In attesa dello sparo d'inizio...", SwingConstants.CENTER);
        labelMessaggioPrincipale.setFont(new Font("SansSerif", Font.BOLD, 18));
        mainPanel.add(labelMessaggioPrincipale, BorderLayout.NORTH);

        // 2. Griglia centrale per i 4 atleti
        JPanel gridAtleti = new JPanel(new GridLayout(4, 1, 10, 10));
        
        for (int i = 0; i < 4; i++) {
            pannelliAtleti[i] = new JPanel(new BorderLayout());
            pannelliAtleti[i].setBackground(new Color(240, 240, 240)); // Grigio chiaro (inattivo)
            pannelliAtleti[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            
            JLabel nomeAtleta = new JLabel("  ATLETA " + (i + 1));
            nomeAtleta.setFont(new Font("SansSerif", Font.BOLD, 14));
            
            labelStatoAtleti[i] = new JLabel("In attesa...  ", SwingConstants.RIGHT);
            labelStatoAtleti[i].setFont(new Font("SansSerif", Font.ITALIC, 12));
            
            pannelliAtleti[i].add(nomeAtleta, BorderLayout.WEST);
            pannelliAtleti[i].add(labelStatoAtleti[i], BorderLayout.EAST);
            
            gridAtleti.add(pannelliAtleti[i]);
        }
        
        mainPanel.add(gridAtleti, BorderLayout.CENTER);

        // 3. Footer con pulsante o info (opzionale)
        JLabel footer = new JLabel("Simulazione Thread Java", SwingConstants.CENTER);
        footer.setForeground(Color.GRAY);
        mainPanel.add(footer, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Metodo chiamato dagli Atleti per aggiornare la grafica
     */
    public void aggiornaInterfaccia(int idAtletaCorrente) {
        SwingUtilities.invokeLater(() -> {
            // Se idAtletaCorrente è tra 1 e 4 (gara in corso)
            if (idAtletaCorrente >= 1 && idAtletaCorrente <= 4) {
                labelMessaggioPrincipale.setText("GARA IN CORSO!");
                labelMessaggioPrincipale.setForeground(new Color(200, 0, 0)); // Rosso corsa
                
                for (int i = 0; i < 4; i++) {
                    int idLogico = i + 1;
                    if (idLogico == idAtletaCorrente) {
                        // Atleta che corre ora
                        pannelliAtleti[i].setBackground(Color.YELLOW);
                        pannelliAtleti[i].setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
                        labelStatoAtleti[i].setText("STA CORRENDO!  ");
                        labelStatoAtleti[i].setForeground(Color.BLACK);
                    } else if (idLogico < idAtletaCorrente) {
                        // Atleti che hanno già finito
                        pannelliAtleti[i].setBackground(new Color(200, 255, 200)); // Verde chiaro
                        labelStatoAtleti[i].setText("ARRIVATO  ");
                        labelStatoAtleti[i].setForeground(new Color(0, 100, 0));
                    }
                }
            } 
            // Se l'id è 5, la gara è finita
            else if (idAtletaCorrente > 4) {
                labelMessaggioPrincipale.setText("GARA CONCLUSA!");
                labelMessaggioPrincipale.setForeground(new Color(0, 150, 0)); // Verde vittoria
                // Tutti verdi
                for (int i = 0; i < 4; i++) {
                    pannelliAtleti[i].setBackground(new Color(150, 255, 150));
                    labelStatoAtleti[i].setText("FINE GARA  ");
                }
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
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FormStaffetta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Crea e visualizza la form */
        java.awt.EventQueue.invokeLater(() -> {
            FormStaffetta frame = new FormStaffetta();
            frame.setVisible(true);

            // Logica di avvio della staffetta
            Testimone testimone = new Testimone();

            // Creiamo i 4 atleti passandogli il riferimento a questa finestra (frame)
            for (int i = 1; i <= 4; i++) {
                new Atleta(testimone, i, frame).start();
            }

            // Thread starter: dà il via dopo 2 secondi
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    testimone.setStato(1); // Parte l'atleta 1
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

