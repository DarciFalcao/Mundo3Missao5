/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclient;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author canal
 */
@Entity
@Table(name = "PessoaJuridica")
@NamedQueries({
    @NamedQuery(name = "PessoaJuridica.findAll", query = "SELECT p FROM PessoaJuridica p"),
    @NamedQuery(name = "PessoaJuridica.findByIDPessoa", query = "SELECT p FROM PessoaJuridica p WHERE p.iDPessoa = :iDPessoa"),
    @NamedQuery(name = "PessoaJuridica.findByCnpj", query = "SELECT p FROM PessoaJuridica p WHERE p.cnpj = :cnpj")})
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDPessoa")
    private Integer iDPessoa;
    @Column(name = "CNPJ")
    private String cnpj;
    @JoinColumn(name = "IDPessoa", referencedColumnName = "IDPessoa", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoa pessoa;
    @OneToMany(mappedBy = "iDPessoaJuridica")
    private Collection<MovimentoCompra> movimentoCompraCollection;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Integer iDPessoa) {
        this.iDPessoa = iDPessoa;
    }

    public Integer getIDPessoa() {
        return iDPessoa;
    }

    public void setIDPessoa(Integer iDPessoa) {
        this.iDPessoa = iDPessoa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Collection<MovimentoCompra> getMovimentoCompraCollection() {
        return movimentoCompraCollection;
    }

    public void setMovimentoCompraCollection(Collection<MovimentoCompra> movimentoCompraCollection) {
        this.movimentoCompraCollection = movimentoCompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPessoa != null ? iDPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        if ((this.iDPessoa == null && other.iDPessoa != null) || (this.iDPessoa != null && !this.iDPessoa.equals(other.iDPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroclient.PessoaJuridica[ iDPessoa=" + iDPessoa + " ]";
    }
    
}
