/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author julio
 */
public class TaskController {
    //Controle de Tarefas através da classe e inicio a Conexão
    public void save(Task task){
        String sql = "INSERT INTO tasks (idProject,"
                + "name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createdWork,"
                + "updatedWork,) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedWork().getTime()));
            statement.setDate(8, new Date(task.getUpdatedWork().getTime()));
            statement.execute();           
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa "
                    + ex.getMessage(), ex);
            
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    //Atualiza tarefas 
    public void update(Task task){
        //Declaro o Método Update(Atualização) SQL para poder ser inserido no BD
        String sql = "UPDATE tasks SET"
                + " idProject = ?,"
                + " name = ?,"
                + " description = ?,"
                + " completed = ?,"
                + " notes = ?,"
                + " deadline = ?,"
                + " createdWork = ?,"
                + " updatedWork = ?,"
                + " WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
                
                 try {                    
                 connection = ConnectionFactory.getConnection();
                 statement = connection.prepareStatement(sql);
                 statement.setInt(1, task.getIdProject());
                 statement.setString(2, task.getName());
                 statement.setString(3, task.getDescription());
                 statement.setBoolean(4, task.isIsCompleted());
                 statement.setString(5, task.getNotes());
                 statement.setDate(6, new Date(task.getDeadline().getTime()));
                 statement.setDate(7, new Date(task.getCreatedWork().getTime()));
                 statement.setDate(8, new Date(task.getUpdatedWork().getTime()));
                 statement.execute();
                 
              } catch (Exception ex) {
                  throw new RuntimeException("Erro ao atualizar tarefa", ex);
         }
    }
    //Remover tarefas que eu desejo
    public void removeById(int taskId) throws SQLException{
        
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a tarefa"+ ex.getMessage(), ex);
            
        } finally {
            ConnectionFactory.closeConnection(connection, statement);            
            }
        }
          //Mostrar a Lista de tarefas
          public List<Task> getAll(int idProject){
             
              String sql = "SELECT * FROM tasks WHERE idProject = ?";
              
               Connection connection = null;
               PreparedStatement statement = null;
               ResultSet resultSet = null;
               
               List<Task> tasks = new ArrayList<Task>();
               
               try {
                  connection = ConnectionFactory.getConnection();
                  statement = connection.prepareStatement(sql);
                  statement.setInt(1, idProject);
                  
                  resultSet = statement.executeQuery();
                  
                  while (resultSet.next()){
                      
                      Task task = new Task();
                      task.setId(resultSet.getInt("id"));
                      task.setIdProject(resultSet.getInt("idProject"));
                      task.setName(resultSet.getString("name"));
                      task.setDescription(resultSet.getString("description"));
                      task.setIsCompleted(resultSet.getBoolean("completed"));
                      task.setDeadline(resultSet.getDate("deadline"));
                      task.setCreatedWork(resultSet.getDate("createdWork"));
                      task.setUpdatedWork(resultSet.getDate("updatedWork"));
                      
                      task.add(task);
                      
                             
                  }
                  
              } catch (Exception ex) {
                  throw new RuntimeException("Erro ao listar as tarefas " + ex.getMessage(), ex);
              } finally {
                   ConnectionFactory.closeConnection(connection,statement,resultSet);
              }
               //Devolvendo a Lista de tarefas
              return tasks;
    }
}
