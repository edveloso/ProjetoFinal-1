package br.unigranrio.managedbean;/* Imports list */

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.bean.requisito.Passo;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.controller.CasoDeUsoController;
import br.unigranrio.controller.Exportador;
import br.unigranrio.controller.ExportadorXml;
import br.unigranrio.controller.FluxoController;
import br.unigranrio.controller.PassoController;
import br.unigranrio.controller.PosCondicaoController;
import br.unigranrio.controller.PreCondicaoController;

@ManagedBean
@SessionScoped
public class ExportacaoMB {

	private CasoDeUsoController casoControl = new CasoDeUsoController();
	private FluxoController fluxoControl = new FluxoController();
	private PassoController passoControl = new PassoController();
	private PosCondicaoController posControl = new PosCondicaoController();
	private PreCondicaoController preControl = new PreCondicaoController();
	private CasoDeUso casoDeUso = new CasoDeUso();
	private ListDataModel<CasoDeUso> listCasoDeUso;
	private List<Integer> casosDeUsoSelecionados = new ArrayList<Integer>();
	private String link;
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;

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

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public String exportar() {

		Exportador exportador = null;
		casoDeUso = casoMB.getCasosDeUso().getRowData();

		if (casoMB.getFormato().equals("xml")) {
			exportador = new ExportadorXml();
			
			List<Fluxo> fluxos = fluxoControl.selecionarTodosCaso(casoDeUso.getId());
			for (Fluxo fluxo : fluxos) {
				List<Passo> passos = passoControl.selecionarTodosFluxo(fluxo.getId());
				fluxo.setPassosParaXML(passos);
			}

			CasoDeUso ucExp = new CasoDeUso();
			
			ucExp.setAtores(casoDeUso.getAtores());
			ucExp.setCodigo(casoDeUso.getCodigo());
			ucExp.setNome(casoDeUso.getNome());
			ucExp.setObjetivo(casoDeUso.getObjetivo());
			ucExp.setFluxosParaXML(fluxos);
			ucExp.setId(casoDeUso.getId());
			ucExp.setTipo(casoDeUso.getTipo());
			ucExp.setPreCondicoesParaXML(preControl.selecionaTodosPorCasoDeUso(casoDeUso.getId()));
			ucExp.setPosCondicoesParaXML(posControl.selecionaTodosPorCasoDeUso(casoDeUso.getId()));
			ucExp.setRegrasDeNegocioParaXML(casoDeUso.getRegrasDeNegocioParaXML());
			ucExp.setRequisitosNaoFuncionaisParaXML(casoDeUso.getRequisitosNaoFuncionaisParaXML());

			link = exportador.exportarXML(ucExp);
		}

		if(casoMB.getFormato().equals("pdf")){
			
		}
		
		return "exportacoes";
	}

	public ListDataModel<CasoDeUso> getListCasoDeUso() {
		Projeto projeto = projetoMB.getProjeto();
		if(projeto == null){
			listCasoDeUso = new ListDataModel<CasoDeUso>();
		} else {
			long id = projeto.getId();
			System.out.println(id);
			listCasoDeUso = new ListDataModel<CasoDeUso>(casoControl.selecionarTodosProjeto(id));
		}
		return listCasoDeUso;
	}

	public void setListCasoDeUso(ListDataModel<CasoDeUso> listCasoDeUso) {
		this.listCasoDeUso = listCasoDeUso;
	}

	public ProjetoMB getProjetoMB() {
		return projetoMB;
	}

	public void setProjetoMB(ProjetoMB projetoMB) {
		this.projetoMB = projetoMB;
	}

	public CasoDeUsoMB getCasoMB() {
		return casoMB;
	}

	public void setCasoMB(CasoDeUsoMB casoMB) {
		this.casoMB = casoMB;
	}
	
}