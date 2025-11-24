package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroDose {

    private int id;
    private int idAgenda;
    private LocalDate data;
    private LocalTime horario;
    private boolean tomada;
    private String observacao;

    public RegistroDose(int id, int idAgenda, LocalDate data, LocalTime horario, boolean tomada, String observacao) {
        this.id = id;
        this.idAgenda = idAgenda;
        this.data = data;
        this.horario = horario;
        this.tomada = tomada;
        this.observacao = observacao;
    }

    public RegistroDose() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public boolean isTomada() {
        return tomada;
    }

    public void setTomada(boolean tomada) {
        this.tomada = tomada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "RegistroDose {" +
                "id=" + id +
                ", idAgenda=" + idAgenda +
                ", data=" + data +
                ", horario=" + horario +
                ", tomada=" + tomada +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
