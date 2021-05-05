package br.com.impacta.ibpf.contasaldo.resources;

import br.com.impacta.ibpf.contasaldo.entities.ContaSaldo;
import br.com.impacta.ibpf.contasaldo.repositories.ContaSaldoRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contassaldo")
public class ContaSaldoResource {

	@Autowired
	private ContaSaldoRepository contaSaldoRepository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ContaSaldo> findById(@PathVariable Long id) {
		return contaSaldoRepository.findById(id)
				.map(contaSaldo -> ResponseEntity.ok().body(contaSaldo))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(value = "/saldoContaData")
	public ResponseEntity<ContaSaldo> findByContaData(@RequestParam Long conta, @RequestParam("dataEvento") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataEvento) {
		ContaSaldo contaSaldo = contaSaldoRepository.findByContaData(conta, dataEvento);
		return ResponseEntity.ok(contaSaldo);
	}

	@GetMapping(value = "/saldoConta")
	public ResponseEntity<ContaSaldo> findByConta(@RequestParam("contaId") Long conta) {
		Date dataEvento = new Date();

		List<ContaSaldo> listaContaSaldo = contaSaldoRepository.findByContaSList(conta, dataEvento);
		return ResponseEntity.ok(listaContaSaldo.get(0));
	}

	@GetMapping(value = "/saldoContaIni")
	public ResponseEntity<ContaSaldo> findByContaIni(@RequestParam("contaId") Long conta) {
		List<ContaSaldo> listaContaSaldo = contaSaldoRepository.findByContaSListFirst(conta);
		return ResponseEntity.ok(listaContaSaldo.get(0));
	}

}
