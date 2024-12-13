package skyds.example.second.service;

import org.springframework.stereotype.Service;
import skyds.example.second.domain.Row;
import skyds.example.second.domain.Sql;
import skyds.example.second.repository.SqlRepository;

import java.util.List;


public class SqlService {
    private final SqlRepository sqlRepository;

    public SqlService(SqlRepository sqlRepository) {
        this.sqlRepository = sqlRepository;
    }

    public Long cud(Sql sql) {

        sqlRepository.cud(sql);

        return 1L;
    }

    public List<Row> findRows(String column, String table) {
        return sqlRepository.findRows(column, table);
    }

}
