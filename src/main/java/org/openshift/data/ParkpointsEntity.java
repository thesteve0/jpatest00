package org.openshift.data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: spousty
 * Date: 11/4/13
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "parkpoints", schema = "public", catalog = "jpatestoo")
@Entity
public class ParkpointsEntity {
    private int parkid;
    private String name;
    private String theGeom;

    @javax.persistence.Column(name = "parkid", nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getParkid() {
        return parkid;
    }

    public void setParkid(int parkid) {
        this.parkid = parkid;
    }

    @javax.persistence.Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @javax.persistence.Column(name = "the_geom")
    @Basic
    public String getTheGeom() {
        return theGeom;
    }

    public void setTheGeom(String theGeom) {
        this.theGeom = theGeom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkpointsEntity that = (ParkpointsEntity) o;

        if (parkid != that.parkid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (theGeom != null ? !theGeom.equals(that.theGeom) : that.theGeom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parkid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (theGeom != null ? theGeom.hashCode() : 0);
        return result;
    }
}