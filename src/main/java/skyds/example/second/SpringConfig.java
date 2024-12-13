package skyds.example.second;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skyds.example.second.repository.JdbcTemplateMemberRepository;
import skyds.example.second.repository.JdbcTemplateSqlRepository;
import skyds.example.second.repository.MemberRepository;
import skyds.example.second.repository.SqlRepository;
import skyds.example.second.service.MemberService;
import skyds.example.second.service.SqlService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository();
//        return new JdbcTemplateMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }

    @Bean
    public SqlService sqlService(){
        return new SqlService(sqlRepository());
    }

    @Bean
    public SqlRepository sqlRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository();
//        return new JdbcTemplateMemberRepository();
        return new JdbcTemplateSqlRepository(dataSource);
    }
//    @Bean
//    public FilterRegistrationBean<SpiceFilter> spiceFilter() {
//        FilterRegistrationBean<SpiceFilter> registrationBean = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new SpiceFilter());
//        registrationBean.addUrlPatterns("/*");  // url-pattern="*" 대신 "/*" 사용
//        registrationBean.setOrder(1);  // 필터 우선순위 설정
//
//        return registrationBean;
//    }
}
