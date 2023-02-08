/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PENJUALAN;


import reparasi.*;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface PenjualanDAO {
    public void save(ppenjualan masuk);
    public void update(ppenjualan masuk);
    public void delete(ppenjualan masuk);
    
 
    public List<ppenjualan> getAll();
}
