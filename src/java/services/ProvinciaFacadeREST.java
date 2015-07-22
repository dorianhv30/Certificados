/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Canton;
import entities.Provincia;
import java.util.ArrayList;
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

/**
 *
 * @author D0R14N
 */
@Stateless
@Path("provincia")
public class ProvinciaFacadeREST extends AbstractFacade<Provincia> {
    @PersistenceContext(unitName = "CertificadosPU")
    private EntityManager em;

    public ProvinciaFacadeREST() {
        super(Provincia.class);
    }

    @POST
    @Override
    @Consumes({ "application/json"})
    public void create(Provincia entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({ "application/json"})
    public void edit(@PathParam("id") Integer id, Provincia entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({ "application/json"})
    public Provincia find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ "application/json"})
    public List<Provincia> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ "application/json"})
    public List<Provincia> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("cantones/{id}")
    @Produces({"application/json"})
    public List<Canton> getCantones(@PathParam("id") Integer id) {
        Provincia provincia = super.find(id);
        List<Canton> list = new ArrayList(provincia.getCantonCollection());
        return list;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
