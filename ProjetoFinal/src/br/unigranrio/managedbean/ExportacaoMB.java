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
import br.unigranrio.controller.RegraDeNegocioController;
import br.unigranrio.controller.RequisitoNaoFuncionalController;

@ManagedBean
@SessionScoped
public class ExportacaoMB {

	private CasoDeUsoController casoControl = new CasoDeUsoController();
	private FluxoController fluxoControl = new FluxoController();
	private PassoController passoControl = new PassoController();
	private RegraDeNegocioController regraControl = new RegraDeNegocioController();
	private PosCondicaoController posControl = new PosCondicaoController();
	private PreCondicaoController preControl = new PreCondicaoController();
	private RequisitoNaoFuncionalController reqControl = new RequisitoNaoFuncionalController();
	private CasoDeUso casoDeUso = new CasoDeUso();
	private ListDataModel<CasoDeUso> listCasoDeUso;
	private List<Integer> casosDeUsoSelecionados = new ArrayList<Integer>();
	private String formato;
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

	/*public String novo() {

		String mensagem = "Exportações";
		this.casoDeUso = new CasoDeUso();

		// Pega o ID do projeto
		ProjetoMB projetoMB = (ProjetoMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("projetoMB");

		boolean temProjeto = false;

		if (projetoMB != null) {
			casoDeUso.setProjeto(projetoMB.getProjeto());

			if (casoDeUso.getProjeto().getId() != null) {
				mensagem = casoDeUso.getProjeto().getNome() + " >> Exportações";

				this.listCasoDeUso = (ListDataModel<CasoDeUso>) casoControl.selecionarTodosProjeto(casoDeUso.getProjeto().getId());
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
	}*/

	public String exportar() {

		Exportador exportador = null;

		if (formato.equals("xml")) {
			exportador = new ExportadorXml();
			
			casoDeUso = casoMB.getCasosDeUso().getRowData();
			//casoDeUso = listCasoDeUso.getRowData();
			List<Fluxo> fluxos = fluxoControl.selecionarTodosCaso(casoDeUso.getId());
			for (Fluxo fluxo : fluxos) {
				List<Passo> passos = passoControl.selecionarTodosFluxo(fluxo.getId());
				fluxo.setPassosParaXML(passos);
				System.out.println(fluxo.getNome());
				for (Passo passo : passos) {
					System.out.println(passo.getPassoAsString());
				}
			}
			

			CasoDeUso ucExp = new CasoDeUso();
			
			ucExp.setAtores(casoDeUso.getAtores());
			ucExp.setCodigo(casoDeUso.getCodigo());
			ucExp.setNome(casoDeUso.getNome());
			ucExp.setObjetivo(casoDeUso.getObjetivo());
			//ucExp.setFluxosParaXML(fluxoControl.selecionarTodosCaso(casoDeUso.getId()));
			ucExp.setFluxosParaXML(fluxos);
			ucExp.setId(casoDeUso.getId());
			ucExp.setTipo(casoDeUso.getTipo());
			ucExp.setPreCondicoesParaXML(preControl.selecionaTodosPorCasoDeUso(casoDeUso.getId()));
			ucExp.setPosCondicoesParaXML(posControl.selecionaTodosPorCasoDeUso(casoDeUso.getId()));
			ucExp.setRegrasDeNegocioParaXML(regraControl.selecionaTodosPorCasoDeUso(casoDeUso.getId()));
			ucExp.setRequisitosNaoFuncionais(reqControl.selecionaTodosPorCasoDeUso(casoDeUso.getId()));

			link = exportador.exportar(ucExp);
		}

		return "novaExportacao";
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