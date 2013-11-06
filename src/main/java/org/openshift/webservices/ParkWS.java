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
import java.util.HashMap;
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
    @PersistenceContext(name = "parks")
    EntityManager em;

    @GET
    @Produces("application/json")
    public List getAllParks(){
        List allParksList = new ArrayList();
        System.out.println("before create query:: " + allParksList.size());
        System.out.println("what about em:: " + em.toString());
        //Query query =   em.createQuery("select p.id, p.name, astext(p.theGeom)from ParkpointsEntity p");
        Query query =   em.createQuery("select p from ParkpointsEntity p");

        ArrayList templist = (ArrayList) query.getResultList();
        if (templist != null && templist.size() > 0){
           allParksList = processQueryResults(templist);
        }
        System.out.println("almost there");
        return allParksList;
    }


    private ArrayList processQueryResults(ArrayList inList){
        ArrayList forResults = new ArrayList(inList.size());
        for(int i = 0; i < inList.size(); i++){
            //HashMap park = new HashMap();
            ParkpointsEntity ppe = (ParkpointsEntity) inList.get(i);
            String interiorClass = ppe.getName() ;


           forResults.add(interiorClass);

        }

        return forResults;
    }
}
