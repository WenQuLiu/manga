package com.baizhi.cmfz.cmfzadmin;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@SpringBootApplication
@MapperScan("com.baizhi.cmfz.cmfzadmin.dao")
public class CmfzAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmfzAdminApplication.class, args);
    }
}
