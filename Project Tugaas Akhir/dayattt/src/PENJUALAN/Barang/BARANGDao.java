/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PENJUALAN.Barang;


import java.util.List;

/**
 *
 * @author arya
 */
public interface BARANGDao {
    public void save(BARANG brg);
    public void update(BARANG brg);
    public void delete(BARANG brg);
    public List<BARANG> getAll();
}
