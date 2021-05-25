package br.newtonpaiva.poo.u5.lab5b.holerite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private String cnpj;

    private String endereco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "empresa_id")
    private Set<Funcionario> funcionarios = new HashSet<Funcionario>();

    public Empresa() {
        // TODO Auto-generated constructor stub
    }

    public Empresa(String nome, String cnpj, String endereco) {
        super();
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + "]";
    }

    public void adicionarFuncionario(Funcionario f) {
        this.funcionarios.add(f);
        f.setEmpresa(this);
    }

    public void removerFuncionario(Funcionario f) {
        this.funcionarios.remove(f);
        f.setEmpresa(null);
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

}
