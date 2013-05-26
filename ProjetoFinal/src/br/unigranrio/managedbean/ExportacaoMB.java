package br.unigranrio.managedbean;/* Imports list */

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.controller.CasoDeUsoController;
import br.unigranrio.controller.Exportador;
import br.unigranrio.controller.ExportadorXml;

public class ExportacaoMB {

	private CasoDeUsoController casoDeUsoBC;
	private CasoDeUso casoDeUso = new CasoDeUso();
	private List<CasoDeUso> listCasoDeUso = new ArrayList<CasoDeUso>();
	private List<Integer> casosDeUsoSelecionados = new ArrayList<Integer>();
	private String formato;
	private String link;

	public ExportacaoMB() {
	}

	public CasoDeUso getCasoDeUso() {
		return this.casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso arg0) {
		this.casoDeUso = arg0;
	}

	public List<Integer> getCasosDeUsoSelecionados() {
		return this.casosDeUsoSelecionados;
	}

	public void setCasosDeUsoSelecionados(List<Integer> casosDeUsoSelecionados) {
		this.casosDeUsoSelecionados = casosDeUsoSelecionados;
	}

	public void setTodosCasosDeUso(List<CasoDeUso> listCasoDeUso) {
		this.listCasoDeUso = listCasoDeUso;
	}

	public List<CasoDeUso> getTodosCasosDeUso() {
		return listCasoDeUso;
	}

	public List<SelectItem> getTodosCasosDeUsoSelItens() {

		List<SelectItem> itens = new ArrayList<SelectItem>();

		for (CasoDeUso uc : getTodosCasosDeUso())
			itens.add(new SelectItem(uc.getId(), uc.getNome()));

		return itens;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public String novo() {

		String mensagem = "Exportações";
		this.casoDeUso = new CasoDeUso();

		// Pega o ID do projeto
		ProjetoMB projetoMB = (ProjetoMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("projetoMB");

		boolean temProjeto = false;

		if (projetoMB != null) {
			casoDeUso.setProjeto(projetoMB.getProjeto());

			if (casoDeUso.getProjeto().getId() != null) {
				mensagem = casoDeUso.getProjeto().getNome() + " >> Exportações";

				this.listCasoDeUso = casoDeUsoBC.selecionarTodosProjeto(casoDeUso.getProjeto().getId());
				temProjeto = true;
			}
		}

		// Muda o texto do Cabeçalho
		MensagemMB principal = (MensagemMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("principalMB");

		if (principal != null)
			principal.setMensagem(mensagem);

		if (!temProjeto)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Projeto não selecionado!", null));

		return "novaExportacao";
	}

	public String exportar() {

		Exportador exportador = null;

		if (formato.equals("xml")) {
			exportador = new ExportadorXml();

			for (Integer cod : casosDeUsoSelecionados) {
				casoDeUso = casoDeUsoBC.selecionarCaso(cod);

				CasoDeUso ucExp = new CasoDeUso();
				ucExp.setAtores(casoDeUso.getAtores());
				ucExp.setCodigo(casoDeUso.getCodigo());
				ucExp.setNome(casoDeUso.getNome());
				ucExp.setObjetivo(casoDeUso.getObjetivo());
				ucExp.setFluxosParaXML(casoDeUso.getFluxosParaXML());
				ucExp.setId(casoDeUso.getId());
				ucExp.setTipo(casoDeUso.getTipo());
				ucExp.setPreCondicoesParaXML(casoDeUso.getPreCondicoesParaXML());
				ucExp.setPosCondicoesParaXML(casoDeUso.getPosCondicoesParaXML());
				ucExp.setRegrasDeNegocioParaXML(casoDeUso.getRegrasDeNegocioParaXML());

				link = exportador.exportar(ucExp);
			}
		}

		return "novaExportacao";
	}
}