package opendata.drugs.api.services;

import java.util.List;

import opendata.drugs.api.dao.DrugsDao;
import opendata.drugs.api.domain.Drug;

public class DrugsServicesImp  implements DrugsServices{
	
	protected DrugsDao dd = new DrugsDao();

	@Override
	public List<Drug> getDrugs(int page, int limit, String sort, String query) {
		
		return dd.getDrugs(page, limit, sort, query);
	}

	@Override
	public List<Drug> getSupstitute(int page, int limit, String sort, String query) {
		
		return dd.getSupstitute(page, limit, sort, query);
	}

}
