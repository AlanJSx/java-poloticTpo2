package Persistencia;

import Logica.Clientes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    ClientesJpaController jpaCliente = new ClientesJpaController();
    
    public void altaCliente(Clientes cliente){
        try {
            jpaCliente.create(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // metodo para obtener a todos los clientes de la base de datos y almacenarlos en una lista
    public List<Clientes> obtenerClientes(){
        List<Clientes> listaClientes = jpaCliente.findClientesEntities();
        
        return listaClientes;
    }

    
    
    
   
}
