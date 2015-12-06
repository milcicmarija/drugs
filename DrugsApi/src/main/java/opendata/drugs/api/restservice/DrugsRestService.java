package opendata.drugs.api.restservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import opendata.drugs.api.config.Settings;
import opendata.drugs.api.domain.Drug;
import opendata.drugs.api.rest.parsers.DrugJsonParser;
import opendata.drugs.api.services.DrugsServices;
import opendata.drugs.api.services.DrugsServicesImp;
	@Path("/api/drug")
	public class DrugsRestService {

		private final Logger logger = LogManager.getLogger(DrugsRestService.class);

		protected DrugsServices drugsService;
		

		public DrugsRestService() {
			drugsService = new DrugsServicesImp();
			
		}

		@GET
		@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
		public Response getDrugs(@QueryParam("limit") int limit,
								   @QueryParam("page") int page,
								   @QueryParam("sort") String sortType,
								   @QueryParam("query") String query) {

			if (limit == 0) {
				limit = Settings.getInstance().config.query.limit;
			}

			if (page == 0) {
				page = 1;
			}

			if (sortType == null || (!sortType.equalsIgnoreCase("DESC") && sortType != null)) {
				sortType = "ASC";
			}
			
			if(query == null){
				query = "";
			}

			List<Drug> drugs = drugsService.getDrugs(page, limit, sortType.toUpperCase(), query);

//			if (drugs.isEmpty())
//				try {
//					throw new AppException(Status.NOT_FOUND, ResourceBundleUtil.getMessage("drug.not_found"));
//				} catch (KeyNotFoundInBundleException e) {
//					logger.error(e);
//				}

			String json = DrugJsonParser.serializeDrugs(drugs).toString();

			return Response.status(Response.Status.OK).entity(json).build();
		}
	}
