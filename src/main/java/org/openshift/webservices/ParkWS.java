package org.openshift.webservices;


/**
 * Created with IntelliJ IDEA.
 * User: spousty
 * Date: 11/5/13
 * Time: 8:00 AM
 * To change this template use File | Settings | File Templates.
 */

import org.openshift.data.ParkpointsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;
/*
The EJB container handles @PersistenceContext injection ... ParkWS is not an EJB  ...
you might want to make it an stateless session bean by adding @Stateless to it
 */

@Stateless
@Path("parks")
public class ParkWS {

     //get the entity manager from the container. No need to automanage
    //This also includes the closing of the EM
    //No need to name the unit because we only have one persistence unit in persistence.xml
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces("application/json")
    public List getAllParks(){
        List allParksList = new ArrayList();
        System.out.println("before create query:: " + allParksList.size());
        System.out.println("what about em:: " + em.toString());
        Query query =   em.createQuery("select p from ParkpointsEntity p");
        allParksList = query.getResultList();
        System.out.println("almost there");
        return allParksList;
    }
}
