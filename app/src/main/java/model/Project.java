package model;

import java.util.Date;

/**
 *
 * @author julio
 */
public class Project {
    private int id;
    private String name;
    private String description;
    private Date createdWork;
    private Date updatedWork;

    public Project(int id, String name, String description, Date createdWork, Date updatedWork) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdWork = createdWork;
        this.updatedWork = updatedWork;
    }

    public Project() {
        throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getCreatedWork() {
        return createdWork;
    }

    public void setCreatedWork(Date createdWork) {
        this.createdWork = createdWork;
    }

    public Date getUpdatedWork() {
        return updatedWork;
    }

    public void setUpdatedWork(Date updatedWork) {
        this.updatedWork = updatedWork;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", description=" + description + ", createdWork=" + createdWork + ", updatedWork=" + updatedWork + '}';
    }

     
    
    
}
