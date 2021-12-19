/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Repository;


import Reto5.model.Order;
import Reto5.mongoRepository.OrderMongoRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author johan
 */
@Repository
public class OrderRepository {
    
    @Autowired
    private OrderMongoRepository orderRepo;
    

    public List<Order> getAll() {
        return (List<Order>) orderRepo.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepo.findById(id);
    }

    public Order create(Order order) {
        return orderRepo.save(order);
    }

    public void update(Order order) {
        orderRepo.save(order);
    }

    public void delete(Order order) {
        orderRepo.delete(order);
    }
    
    public List<Order> getOrderByZone(String zone){
        return orderRepo.findBySalesManZone(zone);
    }

    public List<Order> getBySalesManId(Integer id){
        return orderRepo.findBySalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return orderRepo.findBySalesManIdAndStatus(id, status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return orderRepo.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
