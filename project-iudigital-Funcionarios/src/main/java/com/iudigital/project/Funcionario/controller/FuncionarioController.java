
package com.iudigital.project.Funcionario.controller;

import com.iudigital.project.Funcionario.data.FuncionarioDao;
import com.iudigital.project.Funcionario.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author esteb
 */
public class FuncionarioController {
    
    private FuncionarioDao funcionarioDao;
    
    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
    }
    
    public List<Funcionario> getListFuncionario() throws SQLException {
        return funcionarioDao.getFuncionarios();
    }
    
    public void create(Funcionario funcionario) throws SQLException {
        funcionarioDao.createFuncionario(funcionario);
    }
    
    public Funcionario getOneFuncionario(int id) throws SQLException{
        return funcionarioDao.getFuncionario(id);
    }
    
    public void update(String numeroFuncionario, Funcionario funcionario) throws SQLException{
        funcionarioDao.updateFuncionario(numeroFuncionario, funcionario);
    }
    
    public void delete(String numeroFuncionario) throws SQLException{
        funcionarioDao.deleteFuncionario(numeroFuncionario);
    }
}
    
