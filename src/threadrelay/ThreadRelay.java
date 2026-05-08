/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadrelay;

public class ThreadRelay {

    public static void main(String[] args) {

        Testimone t = new Testimone();
        FormStaffetta f = new FormStaffetta(t);
        f.setVisible(true);
    }
}
