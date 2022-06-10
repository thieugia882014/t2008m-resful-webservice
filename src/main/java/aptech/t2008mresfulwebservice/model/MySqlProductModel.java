package aptech.t2008mresfulwebservice.model;


import aptech.t2008mresfulwebservice.entity.Product;
import aptech.t2008mresfulwebservice.repository.ProductModel;
import aptech.t2008mresfulwebservice.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel {
    @Override
    public Product save(Product obj)   {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "insert into products (name, price) value (?,?)"
                    );
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setDouble(2, obj.getPrice());
            preparedStatement.execute();
            return obj;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product update(Product updateProduct, int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "update products set name = ?, price =? where id =?");
            preparedStatement.setString(1, updateProduct.getName());
            preparedStatement.setDouble(2, updateProduct.getPrice());
            preparedStatement.setInt(3, updateProduct.getId());
            preparedStatement.execute();
            return updateProduct;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  List<Product> findAll()  {
        List<Product> ListObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = "select * from products";
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Product obj = new Product(id,name,price);
                ListObj.add(obj);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ListObj;

    }
    @Override
    public Product findById(int id)  {
        Product obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = String.format("Select * from products where id =%d",id);
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            if (resultSet.next()){
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                obj = new Product(id,name,price);
            }
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return obj;
    }
    @Override
    public  boolean delete(int id){
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "delete from products where id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
