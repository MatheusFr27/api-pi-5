package helper;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ResponseJson<T> {

	T data;
	String message = "";

	public ResponseJson(T data, String message) {
		this.data = data;
		this.message = message;
	}

	public Response ok() {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json;

		try {
			json = "{ \"data\":" + ow.writeValueAsString(this.data) + ", \"message\": \"" + this.message + "\" }";

			return Response.ok(json).status(200).build();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			json = "{ \"data\": [], \"message\": \"Ocorreu um erro.\" }";

			return Response.ok(json).status(400).build();
		}

	}

}
