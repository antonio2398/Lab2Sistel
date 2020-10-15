/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.Tienda;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author caro
 */
@Path("ws_tienda")
public class Ws_tienda {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Ws_tienda
     */
    public Ws_tienda() {
    }

    @GET
    @Path("consultarPrimerCliente")
    @Produces({"application/json"})
    public String consultarPrimerClientes(){
        Tienda miTienda = new Tienda();
        return miTienda.consultarPrimerCliente();
    }
    @GET
    @Path("consultarUltimoEmpleado")
    @Produces({"application/json"})
    public String consultarUltimoEmpleado(){
        Tienda miTienda = new Tienda();
        return miTienda.consultarUltimoEmpleado();
    } 
    
    @GET
    @Path("consultarUltimosProductos")
    @Produces({"application/json"})
    public String consultarUltimosProductos(){
        Tienda miTienda = new Tienda();
        return miTienda.consultarUltimosProductos();
    } 
    
       
    
}
