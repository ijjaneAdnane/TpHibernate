package org.example.test;


import org.example.entities.Machine;
import org.example.entities.Salle;
import org.example.services.MachineService;
import org.example.services.SalleService;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        Salle s1 = new Salle("A1");
        Salle s2 = new Salle("B2");

        salleService.create(s1);
        salleService.create(s2);


        Machine m1 = new Machine("M1", new Date(), salleService.getById(1));
        Machine m2 = new Machine("M2", new Date(), salleService.getById(2));

        machineService.create(m1);
        machineService.create(m2);

        for (Salle salle : salleService.getAll()) {
            System.out.println("Salle" +salle.getCode());
        }

        for (Machine machine : machineService.getAll()) {
            System.out.println("Machine" +machine.getRef());
        }
        Date d1 = new Date(110,0,1);
        Date d2 = new Date();

        System.out.println("Machine achetées entre" +d1 + "et" +d2 + "sont");

        for (Machine machine : machineService.findBetweenDate(d1,d2)) {
            System.out.println("Machine" +machine.getRef() + " " + machine.getDateAchat());
        }
    }
}
