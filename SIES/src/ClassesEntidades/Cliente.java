/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesEntidades;
/**
 *
 * @author gustavo
 */
public class Cliente {
    
    String nome=null;
    String cpf=null;
    String endereco=null;
    String email=null;

    public Cliente(String nome, String cpf, String endereco, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String insereCliente(){
        
        return "INSERT INTO tb_cliente (nome,logadouro,e_mail,cpf) VALUES("+getNome()+","+getEndereco()+","+getEmail()+","+getCpf()+")";
        
    }
    
    public String alteraNome(String nome)
    {
        return "UPDATE tb_cliente SET  ";
    }
    
    
    
    
}
