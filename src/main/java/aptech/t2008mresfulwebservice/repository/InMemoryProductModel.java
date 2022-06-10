//package aptech.t2008mresfulwebservice.repository;
//
//import aptech.t2008mresfulwebservice.entity.Product;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InMemoryProductModel implements ProductModel{
//
//    private static List<Product> products = new ArrayList<>();
//
//    @Override
//    public Product save(Product product){
//        products.add(product);
//        return null;
//    }
//    @Override
//    public Product update(Product product, int id){
//       int index = -1;
//        for (int i = 0; i < products.size(); i++) {
//            if(products.get(i).getId()==id){
//            index = i;
//            }
//        }
//       if (index != -1){
//           products.get(index).setPrice(product.getPrice());
//           products.get(index).setName(product.getName());
//       }
//       return products.get(index);
//    }
//    @Override
//    public boolean delete(int id){
//        int index = -1;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == id){
//                index = i;
//            }
//        }
//        if (index !=-1){
//            products.remove(index);
//        }
//        return false;
//    }
//    @Override
//    public List<Product> findAll(){
//        return products;
//    }
//    @Override
//    public Product findById(int id){
//        int index = -1;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == id){
//                index = i;
//            }
//        }
//        if (index !=-1){
//           return   products.get(index);
//        }
//        return null;
//    }
//}
