package br.unigranrio.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.dao.DAO;

@ManagedBean
@SessionScoped
public class CasoDeUsoMB {

	private CasoDeUso casoDeUso = new CasoDeUso();
	private ListDataModel<CasoDeUso> casosDeUso = new ListDataModel<CasoDeUso>();
	private List<CasoDeUso> casos;
	private DAO<CasoDeUso> dao = new DAO<CasoDeUso>(CasoDeUso.class);
	public Boolean cadastro = true;
	
	//Lista de Casos de Uso
	public List<CasoDeUso> getCasos(){
		if(casos == null){
			System.out.println("Carregando Casos de Uso");
			casos = new DAO<CasoDeUso>(CasoDeUso.class).getAllOrder("nome");
		}
		return casos;
	}

	public CasoDeUsoMB() {
		
	}
	//Tentando inserir validação
	public void addCasoDeUso(){
		for(CasoDeUso casos : this.getCasos()){
			if(casos.getNome().equalsIgnoreCase(this.getCasoDeUso().getNome())){
				this.cadastro = false;
			}
		}
		if(this.cadastro == true){
			if(this.casoDeUso.getNome().length()>20) {
				System.out.println("Caso de uso com mais de 20 caracteres, Sejá mais objetivo");
			}else{
				if(casoDeUso.getId() == null){
					System.out.println("Cadastro realizado com sucesso");
					dao.adiciona(casoDeUso);
					this.casoDeUso = new CasoDeUso();
				}else{
					System.out.println("Alteração realizada com sucesso");
					dao.atualiza(casoDeUso);
				}
			}
		}else{
			System.out.println("Caso de Uso já registrado");
		}
		casos = dao.getAllOrder("nome");
		this.cadastro = true;
	}
	
	public String addCaso(){
		return "addCasos";
	}
	
	public String salvar(CasoDeUso caso){
		return "listCasos";
	}
	
	public String apagar(){
		return "listCasos";
	}

	public ListDataModel<CasoDeUso> getCasosDeUso() {
		casosDeUso = new ListDataModel<CasoDeUso>();
		return casosDeUso;
	}

	public void setCasosDeUso(ListDataModel<CasoDeUso> casosDeUso) {
		this.casosDeUso = casosDeUso;
	}

	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public DAO<CasoDeUso> getDao() {
		return dao;
	}

	public void setDao(DAO<CasoDeUso> dao) {
		this.dao = dao;
	}

	public void setCasos(List<CasoDeUso> casos) {
		this.casos = casos;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}
	
}
