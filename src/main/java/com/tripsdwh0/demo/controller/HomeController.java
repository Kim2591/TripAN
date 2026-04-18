package com.tripsdwh0.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tripsdwh0.demo.model.Trip;

@Controller
public class HomeController {
    
    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        List<String> lista = new LinkedList<String>();
        lista.add("En la montaña");
        lista.add("En la ciudad");
        lista.add("En los pueblos");
        lista.add("En las playas");
        model.addAttribute("listadoTrip", lista);
        
        return "listado";
    }
    
    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Trip trip = new Trip();
        trip.setNomTrip("Rapel en Volcatenango");
        trip.setDescripcion("Aventa rapel en un circuito conectado en las...");
        trip.setFecha(new Date());
        trip.setCosto(10.0);
        model.addAttribute("trip", trip);
        return "detalle";
    }
    
    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Trip> lista = getTips();
        model.addAttribute("trips", lista);
        return "tabla";  // ← Quita la barra "/", solo "tabla"
    }

    private List<Trip> getTips() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // ← Cambia "mm" a "MM" (meses)
        List<Trip> lista = new LinkedList<Trip>();
        try {
            Trip trip1 = new Trip();
            trip1.setId(1);
            trip1.setNomTrip("Rapel en Volcatenando");
            trip1.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
            trip1.setFecha(sdf.parse("10-05-2022"));
            trip1.setCosto(5.0);

            Trip trip2 = new Trip();
            trip2.setId(2);
            trip2.setNomTrip("Deslizadero en El picnic");
            trip2.setDescripcion("Deslizarte en un divertido tovogan sobre la colina");
            trip2.setFecha(sdf.parse("10-05-2022"));
            trip2.setCosto(5.0);

            Trip trip3 = new Trip();
            trip3.setId(3);
            trip3.setNomTrip("Comida y Flores");
            trip3.setDescripcion("Disfrutar de un amplio jardín el cual podras comprar");
            trip3.setFecha(sdf.parse("10-05-2022"));
            trip3.setCosto(1.0);

            Trip trip4 = new Trip();
            trip4.setId(4);
            trip4.setNomTrip("Caminatas");
            trip4.setDescripcion("Disfruta hacer senderismo por las montañas chaletacas");
            trip4.setFecha(sdf.parse("01-02-2022"));
            trip4.setCosto(1.0);

            lista.add(trip1);
            lista.add(trip2);
            lista.add(trip3);
            lista.add(trip4);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }
}