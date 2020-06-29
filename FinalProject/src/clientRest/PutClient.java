package clientRest;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.Client;

public class PutClient {
	
	public void UpdateConto(String op, int idConto, double mov) {

		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/ContoREST/rest/helloworld/put");

			String input = "{\"op\":\""+op+"\",\"idConto\":\""+idConto+"\",\"mov\":\""+mov+"\"} \n";
			System.out.println(input);

			ClientResponse response = webResource.type("application/json")
			   .put(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
				}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
