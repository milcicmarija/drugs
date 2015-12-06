package opendata.drugs.api.services;

import java.util.List;

import opendata.drugs.api.domain.Drug;

public interface DrugsServices {

	List<Drug> getDrugs(int page, int limit, String sort, String query);
	List<Drug> getSupstitute (int page, int limit, String sort, String query);
}
