package com.baizhi.cmfz.cmfzadmin;

import com.baizhi.cmfz.cmfzadmin.entity.Guru;
import com.baizhi.cmfz.cmfzadmin.entity.Menu;
import com.baizhi.cmfz.cmfzadmin.service.GuruService;
import com.baizhi.cmfz.cmfzadmin.service.Impl.GuruServiceImpl;
import com.baizhi.cmfz.cmfzadmin.service.MenuService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzAdminApplicationTests {
    @Autowired
    private GuruService guruService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private FastFileStorageClient storageClient;

    @Test
    public void contextLoads() throws FileNotFoundException {
        /*File file = new File("D:\\1.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        StorePath storePath = storageClient.uploadFile(inputStream, file.length(),"jpg",null);
        System.out.println(storePath.getGroup()+"|"+storePath.getPath());*/

    }
}
