package main.java.model;

public class AgendaMedicamento {

    private Integer id;
    private Usuario usuario;
    private Medicamento medicamento;
    private String horario;
    private String dataInicio;
    private String dataFim;

    public AgendaMedicamento(Integer id, Usuario usuario, Medicamento medicamento,
                             String horario, String dataInicio, String dataFim) {
        this.id = id;
        this.usuario = usuario;
        this.medicamento = medicamento;
        this.horario = horario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // construtor sem-args para frameworks/serialização
    public AgendaMedicamento() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Agenda {" +
                "id=" + id +
                ", usuario=" + (usuario != null ? usuario.getNome() : "null") +
                ", medicamento=" + (medicamento != null ? medicamento.getNome() : "null") +
                ", horário='" + horario + '\'' +
                ", início='" + dataInicio + '\'' +
                ", fim='" + dataFim + '\'' +
                '}';
    }
}
