package uk.gov.homeoffice.dpp.healthchecks.data.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by C.Barnes on 01/03/2017.
 */
@Entity
@Table(name = "checks")
public class Check {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="active")
    private boolean active;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "check", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Audit> auditList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Audit> getAuditList() {
        return auditList;
    }

    public void setAuditList(List<Audit> auditList) {
        this.auditList = auditList;
    }

    public String output() {
        String sp = ", ";

        return (this.id + sp + this.name + sp + this.active + sp + this.description);
    }

    @Override
    public String toString() {
        String result =  String.format(
                "Check[id=%d, active='%b', name='%s', Desc='%s']%n",
                id, active, name, description);


        return result;
    }

    public String toCompleteString(){
        String result =  String.format(
                "Check[id=%d, active='%b', name='%s', Desc='%s']%n",
                id, active, name, description);

        for (Audit audit: auditList)
        {
            result += String.format(audit.toString());
        }

        return result;
    }

}
