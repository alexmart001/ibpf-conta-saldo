package br.com.impacta.ibpf.contasaldo.repositories;

import java.util.Date;
import java.util.List;

import br.com.impacta.ibpf.contasaldo.entities.ContaSaldo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaSaldoRepository extends CrudRepository<ContaSaldo, Long> {

	@Query("select a from ContaSaldo a where a.contaId = :contaId and a.dataEvento = :dataEvento")
	ContaSaldo findByContaData(@Param("contaId") Long conta, @Param("dataEvento") Date dataEvento);

	@Query("select a from ContaSaldo a where a.contaId = :contaId and a.dataEvento <= :dataEvento order by a.contaId Asc, a.dataEvento desc")
	List<ContaSaldo> findByContaSList(@Param("contaId") Long conta, @Param("dataEvento") Date dataEvento);

	@Query("select a from ContaSaldo a where a.contaId = :contaId order by a.contaId Asc, a.dataEvento Asc")
	List<ContaSaldo> findByContaSListFirst(@Param("contaId") Long conta);

}
