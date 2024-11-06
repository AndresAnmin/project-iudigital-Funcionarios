
package com.iudigital.project.Funcionario.data;

import com.iudigital.project.Funcionario.config.ConnectionConfig;
import com.iudigital.project.Funcionario.domain.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDao {
    
    private static final String GET_FUNCIONARIOS = "SELECT * FROM funcionario";
    
    private static final String CREATE_FUNCIONARIO = "INSERT INTO funcionario (numero_funcionario, tipo_identificacion, nombre, apellido, direccion, telefono, fecha_nacimiento, tipo_genero,"
            + " estado_civil, titulo_obtenido)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    // Cambié el nombre de la variable para que sea coherente y corregí el nombre de la columna
    private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM funcionario WHERE id = ?";
    
    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionario SET tipo_identificacion = ?, nombre = ?,"
            + " apellido = ?, direccion = ?, telefono = ?, fecha_nacimiento = ?, tipo_genero = ?, estado_civil = ?, titulo_obtenido = ? WHERE numero_funcionario = ?";

    private static final String DELETE_FUNCIONARIO = "DELETE FROM funcionario WHERE numero_funcionario = ?";


    // Aquí puedes agregar métodos para implementar las consultas, como getFuncionarioById y otros CRUD.
    
    
    public List<Funcionario> getFuncionarios() throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try{
            
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(resultSet.getInt("Id"));
                funcionario.setnumeroFuncionario(resultSet.getString("numero_funcionario"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
                funcionario.setTipoGenero(resultSet.getString("tipo_genero"));
                funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setTituloObtenido(resultSet.getString("titulo_obtenido"));
                funcionarios.add(funcionario);
            }
         return funcionarios;
            
        }finally{
            
            if (connection != null ) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
    
    public void createFuncionario(Funcionario funcionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_FUNCIONARIO);
            
            
            preparedStatement.setString(1, funcionario.getnumeroFuncionario());
            preparedStatement.setString(2, funcionario.getTipoIdentificacion());
            preparedStatement.setString(3, funcionario.getNombre());
            preparedStatement.setString(4, funcionario.getApellido());
            preparedStatement.setString(5, funcionario.getDireccion());
            preparedStatement.setString(6, funcionario.getTelefono());
            preparedStatement.setString(7, funcionario.getFechaNacimiento());
            preparedStatement.setString(8, funcionario.getTipoGenero());
            preparedStatement.setString(9, funcionario.getEstadoCivil());
            preparedStatement.setString(10, funcionario.getTituloObtenido());
            
            preparedStatement.executeUpdate();
            
            
        }finally{
            
            if (connection != null ) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public Funcionario getFuncionario(int id) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;
        
        try {
            
             connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("Id"));
                funcionario.setnumeroFuncionario(resultSet.getString("numero_funcionario"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
                funcionario.setTipoGenero(resultSet.getString("tipo_genero"));
                funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setTituloObtenido(resultSet.getString("titulo_obtenido"));
            }
            
            return funcionario;
            
            
        }finally{
             if (connection != null ) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
    
    public void updateFuncionario(String numeroFuncionario, Funcionario funcionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
            
            preparedStatement.setString(1, funcionario.getTipoIdentificacion());
            preparedStatement.setString(2, funcionario.getNombre());
            preparedStatement.setString(3, funcionario.getApellido());
            preparedStatement.setString(4, funcionario.getDireccion());
            preparedStatement.setString(5, funcionario.getTelefono());
            preparedStatement.setString(6, funcionario.getFechaNacimiento());
            preparedStatement.setString(7, funcionario.getTipoGenero());
            preparedStatement.setString(8, funcionario.getEstadoCivil());
            preparedStatement.setString(9, funcionario.getTituloObtenido());
            preparedStatement.setString(10, numeroFuncionario);
            preparedStatement.executeUpdate();
            
        }finally{
            
            if (connection != null ) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        
    }
    
     public void deleteFuncionario(String numeroFuncionario) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // Establecer la conexión con la base de datos
        connection = ConnectionConfig.getConnection();

        // Preparar la consulta SQL de eliminación
        preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
        preparedStatement.setString(1, numeroFuncionario); // Configurar el parámetro de la consulta

        // Ejecutar la consulta y verificar el resultado
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Funcionario eliminado con éxito.");
        } else {
            System.out.println("No se encontró un funcionario con el número especificado.");
        }
    } catch (SQLException e) {
        // Manejo de excepciones
        System.err.println("Error al eliminar el funcionario: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Cerrar recursos en el orden adecuado
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } 
        
        catch (SQLException e) {
            System.err.println("Error al cerrar los recursos: " + e.getMessage());
        }
    }
    

     }
     
}