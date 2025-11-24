package model;

public class Medicamento {

    private int id;
    private String nome;
    private String dosagem;
    private String descricao;

    public Medicamento(int id, String nome, String dosagem, String descricao) {
        this.id = id;
        this.nome = nome;
        this.dosagem = dosagem;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Medicamento {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dosagem='" + dosagem + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

