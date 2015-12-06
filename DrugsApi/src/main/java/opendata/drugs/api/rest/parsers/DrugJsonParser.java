package opendata.drugs.api.rest.parsers;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import opendata.drugs.api.domain.Drug;
import opendata.drugs.api.uri.UriGenerator;

public class DrugJsonParser {

	public static JsonArray serializeDrugs(List<Drug> drugs) {
		JsonArray array = new JsonArray();

		if (drugs != null && !drugs.isEmpty()) {

			for (Drug d : drugs) {
				JsonObject jsonMember = serializeDrug(d);
				array.add(jsonMember);
			}
		} 
		return array;
	}

	public static JsonObject serializeDrug(Drug d) {

		 JsonObject jsonMember = new JsonObject();

		if (d != null) {

			JsonObject meta = new JsonObject();
			meta.addProperty("href", UriGenerator.generate(d, d.getName()));

			jsonMember.add("meta", meta);
			jsonMember.addProperty("name", d.getName());
			jsonMember.addProperty("inn", d.getGenericName());
			jsonMember.addProperty("uniquClasification", d.getUniquClasification());

			if (d.getFormAndDose() != null) {
				jsonMember.addProperty("formAndDose",d.getFormAndDose());
			}

			if (d.getAtc() != null) {
				jsonMember.addProperty("atc", d.getAtc());
			}

			if (d.getPrice() != null) {
				jsonMember.addProperty("price", d.getPrice());
			}

			if (d.getManufacturer() != null) {
				jsonMember.addProperty("manufacturer", d.getManufacturer());
			}

			if (d.getRegimeOfDrug() != null) {
				jsonMember.addProperty("regimeOfDrugs", d.getRegimeOfDrug());
			}

		}
		return jsonMember;
	}
	
}
