package org.openshift.webservices;


/**
 * Created with IntelliJ IDEA.
 * User: spousty
 * Date: 11/5/13
 * Time: 8:00 AM
 * To change this template use File | Settings | File Templates.
 */

import org.openshift.data.ParkpointsEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("parks")
public class ParkWS {

     //get the entity manager from the container. No need to automanage
    //This also includes the closing of the EM
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces("application/json")
    public List getAllParks(){
        List allParksList = new ArrayList();
        allParksList = em.createQuery("select p from ParkpointsEntity p").getResultList();

        return allParksList;
    }
}
