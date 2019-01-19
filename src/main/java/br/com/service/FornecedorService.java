package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Fornecedor;
import br.com.model.dto.PesquisaDTO;
import br.com.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;

	@Transactional
	public void save(Fornecedor fornecedor) {
		this.repository.save(fornecedor);
	}

	@Transactional
	public void remove(Long id) {
		this.repository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Fornecedor> list() {
		return this.repository.findAll();
	}

	@Transactional(readOnly = true)
	public Fornecedor getById(Long id) {
		return this.repository.getOne(id);
	}

	public List<Fornecedor> filtrar(PesquisaDTO dto) {
		String nome = dto.getNome() == null ? "%" : dto.getNome() + "%";
		return repository.findByNomeContaining(nome);
	}

	@Transactional
	public boolean ativarDesativar(Long id) {
		boolean ativou = false;

		Fornecedor fornecedor = this.repository.getOne(id);
		if (fornecedor.isAtivo()) {
			fornecedor.setAtivo(false);
			return ativou;
		} else {
			fornecedor.setAtivo(true);
			ativou = true;
		}
		return ativou;
	}

}
