package skyds.example.second.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import skyds.example.second.domain.Row;
import skyds.example.second.domain.Sql;
import skyds.example.second.service.SqlService;

import java.util.List;

@Controller
public class SqlController {
    private final SqlService sqlService;

    public SqlController(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    @GetMapping("/")
    public String home(){
        return "sql/sqlForm";
    }

    @PostMapping("/sql/all")
    public String sqlAll(SqlForm sqlForm) {
        Sql sql = new Sql();
        sql.setSql(sqlForm.getSql());

        System.out.println("member = " + sql.getSql());

        sqlService.cud(sql);

        return "redirect:/";
    }

    @GetMapping("/sql/select")
    public String sqlSelect(@RequestParam String column, @RequestParam String table, Model model){
        List<Row> rows = sqlService.findRows(column, table);
        model.addAttribute("rows", rows);
        return "sql/sqlList";
    }

}
