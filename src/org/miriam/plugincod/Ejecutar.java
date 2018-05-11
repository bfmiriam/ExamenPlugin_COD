/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miriam.plugincod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        // TODO implement action body
    }
}
