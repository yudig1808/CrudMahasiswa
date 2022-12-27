package crudmahasiswasederhana.interfce;

import crudmahasiswasederhana.models.mahasiswa;
import java.sql.SQLException;
import java.util.List;

public interface mahasiswaInterface {
    mahasiswa insert(mahasiswa o) throws SQLException;
    
    void update (mahasiswa o) throws SQLException;
    void delete (String nim) throws SQLException;
    
    List<mahasiswa> getAll() throws SQLException;
    
}
