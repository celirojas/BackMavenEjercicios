package com.dh.clase23sClinica.dao;

import com.dh.clase23sClinica.dominio.Domicilio;
import com.dh.clase23sClinica.dominio.Paciente;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component //Para que en service haya a disposición un pacienteDAO
public class PacienteDAOH2 implements IDao<Paciente>{

    //Realizar la conexión con la base de datos
    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }


    //Implementacion de metodos de la interface
    @Override
    public List<Paciente> listarElementos() {
        Connection connection = null;
        List<Paciente>listaPacientes= new ArrayList<>(); //Nos va a devolver una lista de pacientes.
        Paciente paciente = null;
        Domicilio domicilio = null;


        try{
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2(); //Lo necesito para luego cargarlo en el constructor de paciente. De otra manera, sería null.

            //Me conecto
            connection = getConnection();

            //Traigotodo lo que tenga la tabla
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes");

            //Tengo que ejecutar la query y recorrer los resultados
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()){
                int id_domicilio = results.getInt(7); //Acá en la tabla solo hay un id, pero en el constructor pide un objeto Domicilio, por eso le pasamos solo "domicilio". Lo vamos a buscar con el DAOH2

                domicilio = domicilioDAOH2.buscarId(id_domicilio); //Ir a buscar a la base el id que le paso por parámetro. Busco el objeto que tiene ese id.

                paciente= new Paciente(results.getInt(1), results.getString(2), results.getString(3),results.getString(4), results.getInt(5), results.getDate(6).toLocalDate(), domicilio);

                listaPacientes.add(paciente); //Lo agrego a la colección.
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return listaPacientes;
    }


    @Override
    public Paciente buscarId(int id) {
        return null;
    }

    @Override
    public Paciente buscarEmail(String email) {
        Connection connection=null;
        Paciente paciente=null;
        Domicilio domicilio=null;


        try{
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2(); //Lo necesito para luego cargarlo en el constructor de paciente. De otra manera, sería null.

            //Me conecto
            connection = getConnection();

            //Traigotodo lo que tenga la tabla
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes WHERE email LIKE ?");
            preparedStatement.setString(1, email);

            //Tengo que ejecutar la query y recorrer los resultados
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()){
                int id_domicilio = results.getInt(7); //Acá en la tabla solo hay un id, pero en el constructor pide un objeto Domicilio, por eso le pasamos solo "domicilio". Lo vamos a buscar con el DAOH2

                domicilio = domicilioDAOH2.buscarId(id_domicilio); //Ir a buscar a la base el id que le paso por parámetro. Busco el objeto que tiene ese id.

                paciente= new Paciente(results.getInt(1), results.getString(2), results.getString(3),results.getString(4), results.getInt(5), results.getDate(6).toLocalDate(), domicilio);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        try{
            connection = getConnection();
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            Domicilio domicilio = domicilioDAOH2.guardar(paciente.getDomicilio());
            paciente.getDomicilio().setId(domicilio.getId());

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pacientes(apellido, nombre, email, dni, fechaIngreso, domicilio_id) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getApellido());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getEmail());
            preparedStatement.setInt(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(6, paciente.getDomicilio().getId());

            preparedStatement.executeUpdate();
            ResultSet claves = preparedStatement.getGeneratedKeys();
            while(claves.next()){
                paciente.setId(claves.getInt(1));
            }

            preparedStatement.close();




        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        Connection connection = null;
        try{
            connection = getConnection();
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            Domicilio domicilio = domicilioDAOH2.actualizar(paciente.getDomicilio());


            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE pacientes SET apellido=?, nombre=?, email=?, dni=?, fechaIngreso=?, domicilio_id=? WHERE id=?");
            preparedStatement.setString(1, paciente.getApellido());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getEmail());
            preparedStatement.setInt(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(6, paciente.getDomicilio().getId());
            preparedStatement.setInt(7, paciente.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();




        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return paciente;
    }
}
