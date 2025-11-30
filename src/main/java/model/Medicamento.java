package main.java.model;

public class Medicamento {

    private Integer id;
    private String nome;
    private String dosagem;
    private String descricao;

    public Medicamento(Integer id, String nome, String dosagem, String descricao) {
        this.id = id;
        this.nome = nome;
        this.dosagem = dosagem;
        this.descricao = descricao;
    }

    // construtor sem-args para frameworks/serialização
    public Medicamento() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
