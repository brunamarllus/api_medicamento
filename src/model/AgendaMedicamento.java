package model;

public class AgendaMedicamento {

    private int id;
    private Usuario usuario;
    private Medicamento medicamento;
    private String horario;
    private String dataInicio;
    private String dataFim;

    public AgendaMedicamento(int id, Usuario usuario, Medicamento medicamento,
                             String horario, String dataInicio, String dataFim) {
        this.id = id;
        this.usuario = usuario;
        this.medicamento = medicamento;
        this.horario = horario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public String getHorario() {
        return horario;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    @Override
    public String toString() {
        return "Agenda {" +
                "id=" + id +
                ", usuario=" + usuario.getNome() +
                ", medicamento=" + medicamento.getNome() +
                ", horário='" + horario + '\'' +
                ", início='" + dataInicio + '\'' +
                ", fim='" + dataFim + '\'' +
                '}';
    }
}
