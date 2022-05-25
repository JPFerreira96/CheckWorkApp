package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author julio
 */
public class ProjectController {
    
    public void save (Project projects){
  
        String sql = "INSERT INTO projects (NAME,"
                + "DESCRIPITION,"
                + "CREATEDWORK,"
                + "UPDATEDWORK) VALUES (?, ?, ?, ?)";
            
            Connection connection = null;
            PreparedStatement statement = null;
            
            try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, projects.getName());
            statement.setString(2, projects.getDescription());
            statement.setDate(3, new Date(projects.getCreatedWork().getTime()));
            statement.setDate(4, new Date(projects.getUpdatedWork().getTime()));
            statement.execute();           
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa "
                    + ex.getMessage(), ex);
            
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update(Project projects){
        //Declaro o Método Update(Atualização) SQL para poder ser inserido no BD
        String sql = "UPDATE projects SET"
                + " name = ?,"
                + " description = ?,"
                + " createdWork = ?,"
                + " updatedWork = ?,"
                + " WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
                
                 try {                    
                 connection = ConnectionFactory.getConnection();
                 statement = connection.prepareStatement(sql);
                 statement.setString(1, projects.getName());
                 statement.setString(2, projects.getDescription());
                 statement.setDate(3,new Date(projects.getCreatedWork().getTime()));
                 statement.setDate(4, new Date(projects.getUpdatedWork().getTime()));
                 statement.setInt(5,projects.getId());
                 
                        
                 statement.execute();                 
              } catch (Exception ex) {
                  throw new RuntimeException("Erro ao atualizar tarefa", ex);
              
              } finally {
                     ConnectionFactory.closeConnection(connection, statement);
          }                 
    }
        
         public List<Project> getAll(){
             
              String sql = "SELECT * FROM projects";
              
               Connection connection = null;
               PreparedStatement statement = null;
               ResultSet resultSet = null;
               List<Project> projects = new ArrayList<Project>();
               
               try {
                  connection = ConnectionFactory.getConnection();
                  statement = connection.prepareStatement(sql);
                  
                  
                  resultSet = statement.executeQuery();
                  
                  while (resultSet.next()){
                      
                      Project project = new Project();
                      project.setId(resultSet.getInt("id"));
                      project.setName(resultSet.getString("name"));
                      project.setDescription(resultSet.getString("description"));
                      project.setCreatedWork(resultSet.getDate("createdWork"));
                      project.setUpdatedWork(resultSet.getDate("updatedWork"));
                      
                      projects.add(project);
                      
                             
                  }
                  
              } catch (Exception ex) {
                  throw new RuntimeException("Erro ao listar as tarefas " + ex.getMessage(), ex);
              } finally {
                   ConnectionFactory.closeConnection(connection,statement,resultSet);
              }
               //Devolvendo a Lista de projetos
              return projects;
    }
         
         public void removeById(int idProject){
             
             String sql = "DELETE FROM projects WHERE id = ?";
             
             Connection connection = null;
             PreparedStatement statement = null;
             
             try {
                 
                 connection = ConnectionFactory.getConnection();
                 statement = connection.prepareStatement(sql);
                 statement.setInt(1, idProject);
                 statement.execute();
                 
             } catch(SQLException ex) {
                 throw new RuntimeException("Erro ao deletar o projeto", ex);
                 
             } finally {
                 ConnectionFactory.closeConnection(connection, statement);
             }
         }
}
        


