package crudmahasiswasederhana.controller;

import crudmahasiswasederhana.db.ConnectionHelper;
import crudmahasiswasederhana.interfce.mahasiswaInterface;
import crudmahasiswasederhana.models.mahasiswa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class mahasiswaController implements mahasiswaInterface {
    PreparedStatement st;
    
    @Override
    public mahasiswa insert (mahasiswa o) throws SQLException{
        st = ConnectionHelper.getConnection().prepareStatement("insert into mahasiswa_21103051 values (?,?,?)");
        st.setString(1, o.getNim());
        st.setString(2, o.getNama());
        st.setString(3, o.getAlamat());
        st.executeUpdate();
        return o;
    }
    
    @Override
    public void update(mahasiswa o) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement("update mahasiswa set nama=?, alamat=? where nim=?");
        st.setString(1, o.getNama());
        st.setString(2, o.getAlamat());
        st.setString(3, o.getNim());
        st.executeUpdate();
    }

    @Override
    public void delete(String nim) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement("delete from mahasiswa where nim=?");
        st.setString(1, nim);
        st.executeUpdate();
    }

    @Override
    public List<mahasiswa> getAll() throws SQLException {
        Statement st=ConnectionHelper.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select *"+ "from mahasiswa_21103051");
        List<mahasiswa>list=new ArrayList<mahasiswa>();
        while(rs.next()){
            mahasiswa mhs=new mahasiswa();
            mhs.setNim(rs.getString("nim"));
            mhs.setNama(rs.getString("nama"));
            mhs.setAlamat(rs.getString("alamat"));
            list.add(mhs);
        }
        return list;
    }
}
