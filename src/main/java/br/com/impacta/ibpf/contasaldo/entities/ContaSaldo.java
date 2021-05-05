package br.com.impacta.ibpf.contasaldo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_saldo_conta")
public class ContaSaldo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_evento", nullable = false)
	private Date dataEvento;

	@Column(name = "saldo", nullable = false)
	private Double saldo;

	@Column(name = "status", nullable = false)
	private boolean status;

	@Column(name = "conta_id", nullable = false)
	private Long contaId;

	public ContaSaldo() {
	}

	public ContaSaldo(Long id, Date dataEvento, Double saldo, boolean status, Long contaId) {
		this.id = id;
		this.dataEvento = dataEvento;
		this.saldo = saldo;
		this.status = status;
		this.contaId = contaId;
	}

	public ContaSaldo(Date dataEvento, Double saldo, boolean status, Long contaId) {
		this.id = id;
		this.dataEvento = dataEvento;
		this.saldo = saldo;
		this.status = status;
		this.contaId = contaId;
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public boolean isStatus() {
		return status;
	}

	void setStatus(boolean status) {
		this.status = status;
	}

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}

	@Override
	public String toString() {
		return "ContaSaldo{" +
				"id=" + id +
				", dataEvento=" + dataEvento +
				", saldo=" + saldo +
				", status=" + status +
				", contaId=" + contaId +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ContaSaldo that = (ContaSaldo) o;

		if (status != that.status) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (dataEvento != null ? !dataEvento.equals(that.dataEvento) : that.dataEvento != null) return false;
		if (saldo != null ? !saldo.equals(that.saldo) : that.saldo != null) return false;
		return contaId != null ? contaId.equals(that.contaId) : that.contaId == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (dataEvento != null ? dataEvento.hashCode() : 0);
		result = 31 * result + (saldo != null ? saldo.hashCode() : 0);
		result = 31 * result + (status ? 1 : 0);
		result = 31 * result + (contaId != null ? contaId.hashCode() : 0);
		return result;
	}

}
