/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparasi;


import java.util.List;

/**
 *
 * @author Acer
 */
public interface REPARASIDAO {
    public void save(uubah masuk);
    public void update(uubah masuk);
    public void delete(uubah masuk);
    
 
    public List<uubah> getAll();
}
