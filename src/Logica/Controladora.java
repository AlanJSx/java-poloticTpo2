package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Controladora {
    // Instancio la clase ControladoraPersistencia
    ControladoraPersistencia controlPer = new ControladoraPersistencia();
 
    // metodo para utilizar los datos y convertirlo en un objeto de tipo Clientes
    public void altaCliente(int num_cliente, String nombre_perro, String raza, String color, String alergico, String atencion_especial, String nombre_duenio, String celular, String observaciones) {
        
        Clientes cliente = new Clientes();
        
        cliente.setNum_cliente(num_cliente);
        cliente.setNombre_perro(nombre_perro);
        cliente.setRaza(raza);
        cliente.setColor(color);
        cliente.setAlergico(alergico);
        cliente.setAtencion_especial(atencion_especial);
        cliente.setNombre_duenio(nombre_duenio);
        cliente.setCelular(celular);
        cliente.setObservaciones(observaciones);
        
        // Mediante el metodo altaCliente de la ControladoraPersistencia, le paso el objeto creado
        controlPer.altaCliente(cliente);
    }
    
    // metodo para obtener la lsita de clientes desde persistencia
    private List<Clientes> listaClientes(){       
        return controlPer.obtenerClientes();
    }
    
    // metodo para iterar la lista de clientes y convertirlos a una tabla
    public void listaClientes(JTable table){
        List<Clientes> listaClientes = this.listaClientes();
        DefaultTableModel model;  
        String [] titulo = {"NroCliente", "Nombre", "Raza", "Color", "Alergico", "Atencion Especial", "Dueño", "telefono", "observaciones"};
        
        model = new DefaultTableModel(null, titulo);
        
              
        String [] datosCliente = new String[titulo.length];
        
        for (Clientes cliente : listaClientes) {
            datosCliente[0] = cliente.getNum_cliente()+"";
            datosCliente[1] = cliente.getNombre_perro();
            datosCliente[2] = cliente.getRaza();
            datosCliente[3] = cliente.getColor();
            datosCliente[4] = cliente.getAlergico();
            datosCliente[5] = cliente.getAtencion_especial();
            datosCliente[6] = cliente.getNombre_duenio();
            datosCliente[7] = cliente.getCelular();
            datosCliente[8] = cliente.getObservaciones();

            model.addRow(datosCliente);
        }
        table.setModel(model);          
    } 
}
