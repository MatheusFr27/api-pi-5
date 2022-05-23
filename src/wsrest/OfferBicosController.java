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

import dao.OfferBicosDAO;
import helper.ResponseJson;
import model.OfferBicos;
import wsinterface.IGenericController;

@Path("/offer-bicos")
public class OfferBicosController implements IGenericController<OfferBicos> {

	private OfferBicosDAO dao;

	public OfferBicosController() {
		this.dao = new OfferBicosDAO();
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

		ResponseJson<OfferBicos> rj = new ResponseJson<OfferBicos>((OfferBicos) this.dao.findById(id), "");

		return rj.ok();
	}

	@GET
	@Path("/find-by-id-post-bicos/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByIdPostBicos(@PathParam("id") int id) {

		ResponseJson<ArrayList> rj = new ResponseJson<ArrayList>((ArrayList) this.dao.findByIdPostBicos(id), "");

		return rj.ok();
	}

	@Override
	public Response findByColumns(ArrayList<OfferBicos> columns, ArrayList<OfferBicos> validate) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Path("/store")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response store(OfferBicos request) {

		ResponseJson<String> rj = new ResponseJson<String>((String) this.dao.store(request), "");

		return rj.ok();
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response update(OfferBicos request) {

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
