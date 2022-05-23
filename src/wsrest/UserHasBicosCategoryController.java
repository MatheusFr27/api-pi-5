package wsrest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.UserHasBicosCategoryDAO;
import helper.ResponseJson;
import model.UserHasBicosCategory;
import wsinterface.IGenericController;

@Path("/user-has-bicos-category")
public class UserHasBicosCategoryController implements IGenericController<UserHasBicosCategory> {

	private UserHasBicosCategoryDAO dao;

	public UserHasBicosCategoryController() {
		this.dao = new UserHasBicosCategoryDAO();
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

	// @GET
	// @Path("/find-by-id/{id}")
	// @Consumes(MediaType.TEXT_PLAIN)
	// @Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response findById(@PathParam("id") int id) {

		ResponseJson<UserHasBicosCategory> rj = new ResponseJson<UserHasBicosCategory>(
				(UserHasBicosCategory) this.dao.findById(id), "");

		return rj.ok();
	}

	@GET
	@Path("/find-by-id-user/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByIdUser(@PathParam("id") int id) {

		ResponseJson<ArrayList> rj = new ResponseJson<ArrayList>((ArrayList) this.dao.findByIdUser(id), "");

		return rj.ok();
	}

	@Override
	public Response findByColumns(ArrayList<UserHasBicosCategory> columns, ArrayList<UserHasBicosCategory> validate) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Path("/store")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response store(UserHasBicosCategory request) {

		ResponseJson<String> rj = new ResponseJson<String>((String) this.dao.store(request), "");

		return rj.ok();
	}

	// @PUT
	// @Path("/update")
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response update(UserHasBicosCategory request) {

		ResponseJson<String> rj = new ResponseJson<String>((String) this.dao.update(request), "");

		return rj.ok();
	}

	// @DELETE
	// @Path("/delete/{id}")
	// @Consumes(MediaType.TEXT_PLAIN)
	// @Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response delete(@PathParam("id") int id) {

		ResponseJson<String> rj = new ResponseJson<String>((String) this.dao.delete(id), "");

		return rj.ok();
	}

	@DELETE
	@Path("/delete/{id_user}/{id_bicos_category}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRelationships(@PathParam("id_user") int idUser,
			@PathParam("id_bicos_category") int idBicosCategory) {

		ResponseJson<String> rj = new ResponseJson<String>(
				(String) this.dao.deleteRelationships(idUser, idBicosCategory), "");

		return rj.ok();
	}

}
