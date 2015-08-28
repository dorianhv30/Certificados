/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Estudiantenivel;
import entities.EstudiantenivelPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author D0R14N
 */
@Stateless
@Path("estudiantexnivel")
public class EstudiantenivelFacadeREST extends AbstractFacade<Estudiantenivel> {
    @PersistenceContext(unitName = "CertificadosPU")
    private EntityManager em;

    private EstudiantenivelPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idEstudiante=idEstudianteValue;idNivel=idNivelValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.EstudiantenivelPK key = new entities.EstudiantenivelPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idEstudiante = map.get("idEstudiante");
        if (idEstudiante != null && !idEstudiante.isEmpty()) {
            key.setIdEstudiante(new java.lang.Integer(idEstudiante.get(0)));
        }
        java.util.List<String> idNivel = map.get("idNivel");
        if (idNivel != null && !idNivel.isEmpty()) {
            key.setIdNivel(new java.lang.Integer(idNivel.get(0)));
        }
        return key;
    }

    public EstudiantenivelFacadeREST() {
        super(Estudiantenivel.class);
    }

    @POST
    @Override
    @Consumes({ "application/json"})
    public void create(Estudiantenivel entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({ "application/json"})
    public void edit(@PathParam("id") PathSegment id, Estudiantenivel entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.EstudiantenivelPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Estudiantenivel find(@PathParam("id") PathSegment id) {
        entities.EstudiantenivelPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({ "application/json"})
    public List<Estudiantenivel> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Estudiantenivel> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
