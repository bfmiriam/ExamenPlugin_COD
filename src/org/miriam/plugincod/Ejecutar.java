/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miriam.plugincod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.miriam.plugincod.Ejecutar"
)
@ActionRegistration(
        iconBase = "org/miriam/plugincod/boton16.png",
        displayName = "#CTL_Ejecutar"
)
@ActionReference(path = "Menu/Versioning", position = 0)
@Messages("CTL_Ejecutar=Ejecutar")
public final class Ejecutar implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = "javapackager -deploy -native deb -Bcategory=Education "
                + "-Bicon="+JOptionPane.showInputDialog("path de la imagen") 
                + " -BlicenseType=Propietary -outdir "+JOptionPane.showInputDialog("Introduce ruta")+" -outfile "+ 
                JOptionPane.showInputDialog("Introduce nombre de la aplicacion")+" -srcdir "+JOptionPane.showInputDialog("Introduce ruta para el bundle")+" -srcfiles "
                + JOptionPane.showInputDialog("Introduce nombre de la aplicacion")+".jar -appclass "
                +JOptionPane.showInputDialog("Introduce main de la clase")
                +" -name "+ JOptionPane.showInputDialog("Introduce nombre de la aplicacion")+
                " -title "+JOptionPane.showInputDialog("Introduce titulo");
                
        
        try {
            Runtime rt = Runtime.getRuntime();
            //Process pr = rt.exec("cmd /c dir");
            Process pr = rt.exec(comando);

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);

        } catch (Exception ex) {
            System.out.println(e.toString());
            ex.printStackTrace();
        }
    }
}
