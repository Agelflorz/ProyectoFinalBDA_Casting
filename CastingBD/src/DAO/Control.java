/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DAO.DAO_Cliente;
/**
 *
 * @author blude
 */
public class Control {
    private DAO_Cliente clienteD;

    public Control() {
    }
        public DAO_Cliente getClienteDAO(){
        if(this.clienteD != null)
        {
            return this.clienteD;
        }
        else
        {
            this.clienteD = new DAO_Cliente();
            return this.clienteD;
        }
    }
    
}
