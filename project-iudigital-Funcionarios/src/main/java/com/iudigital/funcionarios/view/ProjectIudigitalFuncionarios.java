package com.iudigital.funcionarios.view;

import com.iudigital.project.Funcionario.controller.FuncionarioController;
import com.iudigital.project.Funcionario.data.FuncionarioDao;
import com.iudigital.project.Funcionario.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProjectIudigitalFuncionarios {

    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBienvenido al sistema de gestión de funcionarios");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear funcionario");
            System.out.println("2. Listar funcionarios");
            System.out.println("3. Actualizar funcionario");
            System.out.println("4. Eliminar funcionario por número de identificación");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    createOneFuncionario(funcionarioController);
                    break;
                case 2:
                    listFuncionarios(funcionarioDao);
                    break;
                case 3:
                    updateFuncionario(funcionarioDao, scanner);
                    break;
                case 4:
                    deleteFuncionario(funcionarioDao, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }

    public static void createOneFuncionario(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite el ID del funcionario:");
            String idFuncionario = sc.nextLine();
            System.out.println("Digite el tipo de identificación:");
            String tipoIdentificacion = sc.nextLine();
            System.out.println("Digite el nombre:");
            String nombre = sc.nextLine();
            System.out.println("Digite el apellido:");
            String apellido = sc.nextLine();
            System.out.println("Digite la dirección:");
            String direccion = sc.nextLine();
            System.out.println("Digite el teléfono:");
            String telefono = sc.nextLine();
            System.out.println("Digite la fecha de nacimiento (YYYY-MM-DD):");
            String fechaNacimiento = sc.nextLine();
            System.out.println("Digite el tipo de género:");
            String tipoGenero = sc.nextLine();
            System.out.println("Digite el estado civil:");
            String estadoCivil = sc.nextLine();
            System.out.println("Digite el título obtenido:");
            String tituloObtenido = sc.nextLine();
            
            Funcionario funcionario = new Funcionario();
            funcionario.setnumeroFuncionario(idFuncionario);
            funcionario.setTipoIdentificacion(tipoIdentificacion);
            funcionario.setNombre(nombre);
            funcionario.setApellido(apellido);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechaNacimiento(fechaNacimiento);
            funcionario.setTipoGenero(tipoGenero);
            funcionario.setEstadoCivil(estadoCivil);
            funcionario.setTituloObtenido(tituloObtenido);
            funcionarioController.create(funcionario);  
            System.out.println("Funcionario creado con éxito.");
        } catch (Exception e) {
            System.err.println("Error al crear el funcionario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void listFuncionarios(FuncionarioDao funcionarioDao) {
        try {
            List<Funcionario> funcionarios = funcionarioDao.getFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay funcionarios para mostrar.");
            } else {
                  // Utiliza 'funcionarios' correctamente aquí
            funcionarios.forEach(func -> {
                System.out.println("ID: " + func.getId()); 
                System.out.println("ID Funcionario: " + func.getnumeroFuncionario()); 
                System.out.println("Tipo Identificación: " + func.getTipoIdentificacion()); 
                System.out.println("Nombre: " + func.getNombre()); 
                System.out.println("Apellido: " + func.getApellido()); 
                System.out.println("Dirección: " + func.getDireccion()); 
                System.out.println("Teléfono: " + func.getTelefono()); 
                System.out.println("Fecha de Nacimiento: " + func.getFechaNacimiento()); 
                System.out.println("Tipo Género: " + func.getTipoGenero()); 
                System.out.println("Estado Civil: " + func.getEstadoCivil()); 
                System.out.println("Título Obtenido: " + func.getTituloObtenido()); 
                System.out.println("============================================================"); 
                System.out.println("============================================================"); 
                System.out.println("============================================================"); 
            });
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

    public static void updateFuncionario(FuncionarioDao funcionarioDao, Scanner scanner) {
        try {
            System.out.print("Ingresa el número de funcionario a actualizar: ");
            String numeroFuncionario = scanner.nextLine();

            Funcionario funcionario = new Funcionario();
            funcionario.setnumeroFuncionario(numeroFuncionario);

            System.out.println("Digite el nuevo tipo de identificación:");
            funcionario.setTipoIdentificacion(scanner.nextLine());
            System.out.println("Digite el nuevo nombre:");
            funcionario.setNombre(scanner.nextLine());
            System.out.println("Digite el nuevo apellido:");
            funcionario.setApellido(scanner.nextLine());
            System.out.println("Digite la nueva dirección:");
            funcionario.setDireccion(scanner.nextLine());
            System.out.println("Digite el nuevo teléfono:");
            funcionario.setTelefono(scanner.nextLine());
            System.out.println("Digite la nueva fecha de nacimiento (YYYY-MM-DD):");
            funcionario.setFechaNacimiento(scanner.nextLine());
            System.out.println("Digite el nuevo tipo de género:");
            funcionario.setTipoGenero(scanner.nextLine());
            System.out.println("Digite el nuevo estado civil:");
            funcionario.setEstadoCivil(scanner.nextLine());
            System.out.println("Digite el nuevo título obtenido:");
            funcionario.setTituloObtenido(scanner.nextLine());

            funcionarioDao.updateFuncionario(numeroFuncionario, funcionario);
            System.out.println("Funcionario actualizado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar el funcionario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void deleteFuncionario(FuncionarioDao funcionarioDao, Scanner scanner) {
        System.out.print("Ingresa el número de funcionario a eliminar: ");
        String numeroFuncionario = scanner.nextLine();
        funcionarioDao.deleteFuncionario(numeroFuncionario);
    }
}


