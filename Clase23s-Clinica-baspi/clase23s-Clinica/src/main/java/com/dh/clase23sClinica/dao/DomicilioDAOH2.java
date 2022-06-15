package com.dh.clase23sClinica.dao;

import com.dh.clase23sClinica.dominio.Domicilio;

import java.sql.*;
import java.util.List;

public class DomicilioDAOH2 implements IDao<Domicilio>{
    //Realizar la conexión con la base de datos
    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }


    @Override
    public List<Domicilio> listarElementos() {
        return null;
    }

    @Override
    public Domicilio buscarId(int id) {
        Connection connection = null;
        Domicilio domicilio = null;

        try{
            //Me conecto
            connection=getConnection();

            //Preparo la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM domicilio WHERE id=?");
            preparedStatement.setInt(1,id); //Id que recibo por parámetro.

            //Lo ejecuto y lo recorro
            ResultSet result= preparedStatement.executeQuery();
            while(result.next()){
                domicilio=new Domicilio(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5));
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
        return domicilio;
    }

    @Override
    public Domicilio buscarEmail(String email) {
        return null;
    }

    //Clase 25
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO domicilios(calle, numero, localidad, provincia) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.executeUpdate();

            ResultSet claves = preparedStatement.getGeneratedKeys();
            while(claves.next()){
                domicilio.setId(claves.getInt(1));
            }
            preparedStatement.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE domicilios SET calle=?, numero=?, localidad=?, provincia=? WHERE id=?");
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.setInt(5, domicilio.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return domicilio;
    }
}
