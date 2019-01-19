package br.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import br.com.model.Fornecedor;
import br.com.model.dto.PesquisaDTO;
import br.com.service.FornecedorService;

@Controller
@RequestMapping("/fornecedores")
public class FornecedoresController {

	private static final String PAGES_FORNECEDOR_NOVO_FORNECEDOR = "pages/fornecedor/novo_fornecedor";

	private static final String PAGES_FORNECEDOR_FORNECEDORES = "pages/fornecedor/fornecedores";

	@Autowired
	private FornecedorService service;

	@GetMapping
	public ModelAndView listar(@ModelAttribute("filtro") PesquisaDTO filtro) {
		ModelAndView mv = new ModelAndView(PAGES_FORNECEDOR_FORNECEDORES);

		if (!StringUtils.isEmpty(filtro.getNome())) {
			List<Fornecedor> fornecedores = this.service.filtrar(filtro);
			mv.addObject("fornecedores", fornecedores);
		} else {
			mv.addObject("fornecedores", service.list());
		}

		return mv;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/fornecedores");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Fornecedor removido com sucesso!");
		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Fornecedor fornecedor = this.service.getById(id);
		return novo(fornecedor);
	}

	@GetMapping("/novo")
	public ModelAndView novo(Fornecedor fornecedor) {
		ModelAndView mv = new ModelAndView(PAGES_FORNECEDOR_NOVO_FORNECEDOR);
		mv.addObject("fornecedor", fornecedor);
		return mv;
	}

	@GetMapping("/ativar/{id}")
	public ModelAndView ativarDesativar(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/fornecedores");

		if (this.service.ativarDesativar(id)) {
			attributes.addFlashAttribute("ativadoDesativado", "Fornecedor ativado com sucesso!");
		} else {
			attributes.addFlashAttribute("ativadoDesativado", "Fornecedor desativado com sucesso!");
		}
		return mv;
	}

	@PostMapping("/save")
	public ModelAndView salvar(@Valid Fornecedor fornecedor, BindingResult result, Model model,
			RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/fornecedores");

		if (result.hasErrors()) {
			return novo(fornecedor);
		}

		attributes.addFlashAttribute("mensagem", "Fornecedor salvo com sucesso");
		this.service.save(fornecedor);
		return mv;
	}

}
