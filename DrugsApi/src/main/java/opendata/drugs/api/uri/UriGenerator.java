package opendata.drugs.api.uri;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.mysql.jdbc.log.Log;

import opendata.drugs.api.config.Settings;
import opendata.drugs.api.rest.name.RestServiceName;

public class UriGenerator {

	private static String uriPrefix = Settings.getInstance().config.uriGenerator.uriPrefix;

	public static String generate(Object o, String name) {
		RestServiceName restServiceNameAnn = o.getClass().getAnnotation(RestServiceName.class);
		
		if (restServiceNameAnn != null) {
			String specificName = restServiceNameAnn.value();
			
			UriBuilder builder = UriBuilder.fromPath(uriPrefix).path(specificName + "/" + name);
			System.out.println("ADRESA!!!!!!!!!!!!!!!!" + builder);
			URI uri = builder.build();
			return uri.toString();
		} else {
//			throw new MissingRestServiceNameAnnotationException("Passed object's class does not have declared RestServiceName annotation");
		}
		return uriPrefix;
	}
}