package uk.gov.homeoffice.dpp.healthchecks.data.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by C.Barnes on 01/03/2017.
 */
@Entity
@Table(name = "audit")
public class Audit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="start")
    private Date start;

    @Column(name="finish")
    private Date finish;

    @Column(name="status")
    private String status;

    @Column(name="error_msg")
    private String error_msg;

    @ManyToOne
    @JoinColumn(name="fileid")
    private File file;

    @ManyToOne
    @JoinColumn(name="checkid")
    private Check check;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public File getFile() {
        return file;
    }

    public Check getCheck() {
        return check;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public String output(){
        String sp = ", ";

        String values = this.id + sp +  this.start + sp + this.finish + sp + this.status + sp + this.error_msg;

        return values;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Audit[id=%d, start='%s', finish='%s', status='%s', error_msg='%s']%n",
                id/*, checkid, fileid*/, start.toString(), finish.toString(), status, error_msg);


        return result;
    }

    public String toCompleteString() {
        String result = String.format(
                "Audit[id=%d, start='%s', finish='%s', status='%s', error_msg='%s']%n",
                id, start.toString(), finish.toString(), status, error_msg);

        result += file.toString();

        result += check.toString();

        return result;
    }

}
