package main.java;

import main.java.model.Medicamento;
import main.java.model.Usuario;
import main.java.model.AgendaMedicamento;
import main.java.model.RegistroDose;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sistema de Controle de Medicamentos ===");
        System.out.println("Siga as instruções para cadastrar usuário, medicamento, criar a agenda e registrar doses.");

        // Cadastro do usuário
        System.out.println("\n--- Cadastro de Usuário ---");
        System.out.print("Nome (ex: Maria Silva): ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) nome = "Maria Silva";
        System.out.print("Email (ex: maria@example.com): ");
        String email = sc.nextLine().trim();
        if (email.isEmpty()) email = "maria@example.com";

        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome(nome);
        usuario.setEmail(email);

        System.out.println("Usuário cadastrado: " + usuario);

        // Cadastro do medicamento
        System.out.println("\n--- Cadastro de Medicamento ---");
        System.out.print("Nome do medicamento (ex: Clonazepam): ");
        String medNome = sc.nextLine().trim();
        if (medNome.isEmpty()) medNome = "Clonazepam";
        System.out.print("Dosagem (ex: 2mg): ");
        String dosagem = sc.nextLine().trim();
        if (dosagem.isEmpty()) dosagem = "2mg";
        System.out.print("Descrição (opcional): ");
        String descricao = sc.nextLine().trim();

        Medicamento medicamento = new Medicamento();
        medicamento.setId(1);
        medicamento.setNome(medNome);
        medicamento.setDosagem(dosagem);
        medicamento.setDescricao(descricao);

        System.out.println("Medicamento cadastrado: " + medicamento);

        // Cadastro da agenda
        System.out.println("\n--- Cadastro de Agenda ---");
        System.out.print("Horário (HH:mm, ex: 08:00): ");
        String horarioStr = sc.nextLine().trim();
        if (horarioStr.isEmpty()) horarioStr = "08:00";
        // validação simples do horário
        try {
            LocalTime.parse(horarioStr);
        } catch (DateTimeParseException ex) {
            System.out.println("Formato de horário inválido; usando 08:00");
            horarioStr = "08:00";
        }

        System.out.print("Data início (dd-mm-yyyy), ex: 01-12-2025): ");
        String dataInicio = sc.nextLine().trim();
        if (dataInicio.isEmpty()) dataInicio = "01-12-2025";
        try {
            LocalDate.parse(dataInicio);
        } catch (DateTimeParseException ex) {
            System.out.println("Formato de data inválido; usando 01-12-2025");
            dataInicio = "01-12-2025";
        }

        System.out.print("Data fim (dd-mm-yyyy, ex: 31-12-2025): ");
        String dataFim = sc.nextLine().trim();
        if (dataFim.isEmpty()) dataFim = "31-12-2025";
        try {
            LocalDate.parse(dataFim);
        } catch (DateTimeParseException ex) {
            System.out.println("Formato de data inválido; usando 31-12-2025");
            dataFim = "31-12-2025";
        }

        AgendaMedicamento agenda = new AgendaMedicamento();
        agenda.setId(1);
        agenda.setUsuario(usuario);
        agenda.setMedicamento(medicamento);
        agenda.setHorario(horarioStr);
        agenda.setDataInicio(dataInicio);
        agenda.setDataFim(dataFim);

        System.out.println("Agenda cadastrada: " + agenda);

        // Registro de dose tomada
        System.out.println("\n--- Registro de Dose (Tomada) ---");
        System.out.print("Data da tomada (dd-mm-yyyy, enter para hoje): ");
        String tomadaData = sc.nextLine().trim();
        LocalDate tomadaDate;
        if (tomadaData.isEmpty()) {
            tomadaDate = LocalDate.now();
        } else {
            try {
                tomadaDate = LocalDate.parse(tomadaData);
            } catch (DateTimeParseException ex) {
                System.out.println("Data inválida; usando hoje.");
                tomadaDate = LocalDate.now();
            }
        }

        System.out.print("Horário da tomada (HH:mm, enter para " + horarioStr + "): ");
        String tomadaHorario = sc.nextLine().trim();
        if (tomadaHorario.isEmpty()) tomadaHorario = horarioStr;
        try {
            LocalTime.parse(tomadaHorario);
        } catch (DateTimeParseException ex) {
            System.out.println("Horário inválido; usando " + horarioStr);
            tomadaHorario = horarioStr;
        }

        System.out.print("Observação (opcional): ");
        String obsTomada = sc.nextLine().trim();

        RegistroDose doseTomada = new RegistroDose();
        doseTomada.setId(1);
        doseTomada.setIdAgenda(agenda.getId());
        doseTomada.setData(tomadaDate);
        doseTomada.setHorario(LocalTime.parse(tomadaHorario));
        doseTomada.setTomada(true);
        doseTomada.setObservacao(obsTomada);

        System.out.println("Registro de dose TOMADA: " + doseTomada);

        // Registro de dose perdida
        System.out.println("\n--- Registro de Dose (Perdida) ---");
        System.out.print("Data da dose perdida (dd-mm-yyyy, enter para amanhã): ");
        String perdidaData = sc.nextLine().trim();
        LocalDate perdidaDate;
        if (perdidaData.isEmpty()) {
            perdidaDate = LocalDate.now().plusDays(1);
        } else {
            try {
                perdidaDate = LocalDate.parse(perdidaData);
            } catch (DateTimeParseException ex) {
                System.out.println("Data inválida; usando amanhã.");
                perdidaDate = LocalDate.now().plusDays(1);
            }
        }

        System.out.print("Horário da dose perdida (HH:mm, enter para " + horarioStr + "): ");
        String perdidaHorario = sc.nextLine().trim();
        if (perdidaHorario.isEmpty()) perdidaHorario = horarioStr;
        try {
            LocalTime.parse(perdidaHorario);
        } catch (DateTimeParseException ex) {
            System.out.println("Horário inválido; usando " + horarioStr);
            perdidaHorario = horarioStr;
        }

        System.out.print("Observação (opcional): ");
        String obsPerdida = sc.nextLine().trim();

        RegistroDose dosePerdida = new RegistroDose();
        dosePerdida.setId(2);
        dosePerdida.setIdAgenda(agenda.getId());
        dosePerdida.setData(perdidaDate);
        dosePerdida.setHorario(LocalTime.parse(perdidaHorario));
        dosePerdida.setTomada(false);
        dosePerdida.setObservacao(obsPerdida);

        System.out.println("Registro de dose PERDIDA: " + dosePerdida);

        sc.close();
    }
}
