package skyds.example.second.repository;

import skyds.example.second.domain.Row;
import skyds.example.second.domain.Sql;

import java.util.List;

public interface SqlRepository {
    Sql cud(Sql sql);
    List<Row> findRows(String column, String table);
}
