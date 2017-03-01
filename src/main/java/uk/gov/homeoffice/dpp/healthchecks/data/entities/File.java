package uk.gov.homeoffice.dpp.healthchecks.data.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by C.Barnes on 01/03/2017.
 */
@Entity
@NamedEntityGraph(name = "graph.File.audits",
        attributeNodes = @NamedAttributeNode("audits"))
@Table(name = "files")
public class File {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "received")
    private Date received;

    @Column(name = "filepath")
    private String filepath;

    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Audit> audits;


    public List<Audit> getAudits() {
        return audits;
    }

    public void setAudits(List<Audit> audits) {
        this.audits = audits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String output() {

        String sp = ", ";
        return (this.id + sp + this.received + sp + this.filepath);
    }

    @Override
    public String toString() {
        String result = String.format(
                "File[id=%d, received='%s', filepath='%s']%n",
                id, received.toString(), filepath);

        return result;
    }

    public String toCompleteString() {
        String result = String.format(
                "File[id=%d, received='%s', filepath='%s']%n",
                id, received.toString(), filepath);

        for (Audit audit: audits)
        {
            result += String.format(audit.toString());
        }

        return result;
    }



}
