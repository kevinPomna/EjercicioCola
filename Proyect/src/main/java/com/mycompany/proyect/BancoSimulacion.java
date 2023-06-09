/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect;

/**
 *
 * @author usuario
 */
public class BancoSimulacion {
    private String[] colaClientes;
    private int tamaño;
    private int siguiente;

    public BancoSimulacion(int capacidad) {
        colaClientes = new String[capacidad];
        tamaño = 0;
        siguiente = 0;
    }

    public void llegadaCliente(String cliente) {
        if (tamaño < colaClientes.length) {
            colaClientes[(siguiente + tamaño) % colaClientes.length] = cliente;
            tamaño++;
            System.out.println("Cliente " + cliente + " ha llegado al banco.");
        } else {
            System.out.println("La cola de clientes está llena. No se puede agregar el cliente " + cliente);
        }
    }

    public void atencionCliente() {
        if (tamaño > 0) {
            String cliente = colaClientes[siguiente];
            siguiente = (siguiente + 1) % colaClientes.length;
            tamaño--;
            System.out.println("Cliente " + cliente + " ha sido atendido.");
        } else {
            System.out.println("No hay clientes en espera.");
        }
    }

    public void simulacion(int tiempo) {
        for (int i = 0; i < tiempo; i++) {
            System.out.println("\nTiempo: " + (i + 1));
            double numAleatorio = Math.random();
            if (numAleatorio > 0.3) {
                String nuevoCliente = "Cliente" + (i + 1);
                llegadaCliente(nuevoCliente);
            }
            atencionCliente();
        }
    }
}
