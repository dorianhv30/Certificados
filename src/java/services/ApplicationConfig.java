/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author D0R14N
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(services.CantonFacadeREST.class);
        resources.add(services.CertificacionFacadeREST.class);
        resources.add(services.CertificadosCORS.class);
        resources.add(services.DistritoFacadeREST.class);
        resources.add(services.EstudianteFacadeREST.class);
        resources.add(services.EstudiantenivelFacadeREST.class);
        resources.add(services.NivelFacadeREST.class);
        resources.add(services.ParametroFacadeREST.class);
        resources.add(services.PerfilFacadeREST.class);
        resources.add(services.ProvinciaFacadeREST.class);
        resources.add(services.UsuarioFacadeREST.class);
    }
    
}
