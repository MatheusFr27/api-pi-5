package wsrest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.BicosCategoryDAO;
import dao.UserDAO;
import helper.ResponseJson;
import model.BicosCategory;
import model.User;
import wsinterface.IGenericController;

@Path("/bicos-category")
public class BicosCategoryController implements IGenericController<BicosCategory> {

	private BicosCategoryDAO dao;

	public BicosCategoryController() {
		this.dao = new BicosCategoryDAO();
	}

	@GET
	@Path("/initialize")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response initialize() {

		ResponseJson<ArrayList> rj = new ResponseJson<ArrayList>((ArrayList) this.dao.initialize(), "");

		return rj.ok();

	}

	@GET
	@Path("/find-by-id/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response findById(@PathParam("id") int id) {

		ResponseJson<BicosCategory> rj = new ResponseJson<BicosCategory>((BicosCategory) this.dao.findById(id), "");

		return rj.ok();
	}

	@Override
	public Response findByColumns(ArrayList<BicosCategory> columns, ArrayList<BicosCategory> validate) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Path("/store")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response store(BicosCategory request) {

		ResponseJson<String> rj = new ResponseJson<String>((String) this.dao.store(request), "");

		return rj.ok();
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response update(BicosCategory request) {

		ResponseJson<String> rj = new ResponseJson<String>((String) this.dao.update(request), "");

		return rj.ok();
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response delete(@PathParam("id") int id) {

		ResponseJson<String> rj = new ResponseJson<String>((String) this.dao.delete(id), "");

		return rj.ok();
	}

}
