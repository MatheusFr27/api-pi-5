package wsrest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.UserDAO;
import helper.ResponseJson;
import model.User;
import wsinterface.IGenericController;

@Path("/user")
public class UserController implements IGenericController<User> {

	@GET
	@Path("/initialize")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response initialize() {

		UserDAO dao = new UserDAO();

		ResponseJson<ArrayList> rj = new ResponseJson<ArrayList>((ArrayList) dao.initialize(), "");

		return rj.ok();

	}

	@GET
	@Path("/find-by-id/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response findById(@PathParam("id") int id) {

		UserDAO dao = new UserDAO();

		ResponseJson<User> rj = new ResponseJson<User>((User) dao.findById(id), "");

		return rj.ok();
	}

	@Override
	public Response findByColumns(ArrayList<User> columns, ArrayList<User> validate) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Path("/store")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response store(User request) {

		UserDAO dao = new UserDAO();

		ResponseJson<String> rj = new ResponseJson<String>((String) dao.store(request), "");

		return rj.ok();
	}

	@Override
	public Response update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
