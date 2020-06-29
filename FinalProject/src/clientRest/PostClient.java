package clientRest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostClient {
	
	public void createConto(int idConto) {
		
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/ContoREST/rest/helloworld/post");

			String input = ""+idConto+"";
			System.out.println(input);

			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);

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
