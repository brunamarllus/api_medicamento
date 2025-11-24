package service;

import model.Medicamento;
import model.Usuario;
import model.AgendaMedicamento;
import model.RegistroDose;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Sistema de Controle de Medicamentos ===");

        // Cadastro do usuário
        Usuario usuario = new Usuario(1, "Maria Silva", "maria@email.com");
        System.out.println("\nUsuário cadastrado:");
        System.out.println(usuario);

        // Cadastro do medicamento
        Medicamento medicamento = new Medicamento(
                1,
                "Clonazepam",
                "2mg",
                "Medicamento controlado para ansiedade."
        );
        System.out.println("\nMedicamento cadastrado:");
        System.out.println(medicamento);

        // Agenda do medicamento
        AgendaMedicamento agenda = new AgendaMedicamento(
                1,
                usuario,
                medicamento,
                "08:00",
                "01/12/2025",
                "31/12/2025"
        );
        System.out.println("\nAgenda cadastrada:");
        System.out.println(agenda);

        // Registro de dose tomada
        RegistroDose doseTomada = new RegistroDose(
                1,
                agenda.getId(),
                LocalDate.of(2025, 12, 1),
                LocalTime.of(8, 0),
                true,
                "Dose tomada normalmente."
        );

        System.out.println("\nRegistro de dose TOMADA:");
        System.out.println(doseTomada);

        // Registro de dose perdida
        RegistroDose dosePerdida = new RegistroDose(
                2,
                agenda.getId(),
                LocalDate.of(2025, 12, 2),
                LocalTime.of(8, 0),
                false,
                "Usuária esqueceu de tomar."
        );

        System.out.println("\nRegistro de dose PERDIDA:");
        System.out.println(dosePerdida);

    }
}
