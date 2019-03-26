package com.baizhi.cmfz.cmfzadmin.controller;

import com.baizhi.cmfz.cmfzadmin.entity.Slidesshow;
import com.baizhi.cmfz.cmfzadmin.service.SlidesshowService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
/**
 * @Description 轮播图控制层功能
 * @Author wumengkai
 * @Time 2018-7-6
 */
@Controller
@RequestMapping("/slides")
public class SlidesshowController {
    @Autowired
    private SlidesshowService slidesshowService;
    @Autowired
    private FastFileStorageClient storageClient;
    /**
     * @Description 分页展示所有轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 当前页，单页显示条数
     * @Exception
     */
    @RequestMapping("/find.do")
    @ResponseBody
    public Map<String,Object> showByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows")Integer pageSize){
        return slidesshowService.queryByPage(nowPage, pageSize);
    }
    /**
     * @Description 添加轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 轮播图属性
     * @Exception
     */
    /*@RequestMapping("/add.do")
    @ResponseBody
    public String add(String slidesshowDescribe,String slidesshowFlag,MultipartFile slidesshowPosition,HttpSession session) throws Exception{
        //上传轮播图
        String realPath = session.getServletContext().getRealPath("upload").replace("cmfz-admin","");
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        String oldName = slidesshowPosition.getOriginalFilename();
        String suffix = oldName.substring( oldName.lastIndexOf(".") );
        slidesshowPosition.transferTo(new File( realPath +"/"+ uuidName + suffix ));
        //入库
        slidesshowService.add(new Slidesshow(uuidName,slidesshowDescribe,slidesshowPosition.getOriginalFilename(),slidesshowFlag,new Date()));
        return "success";
    }*/
    @RequestMapping("/add.do")
    @ResponseBody
    public String add(String slidesshowDescribe,String slidesshowFlag,MultipartFile slidesshowPosition,HttpSession session) throws Exception{
        //上传轮播图
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        String suffix = slidesshowPosition.getOriginalFilename().substring( slidesshowPosition.getOriginalFilename().lastIndexOf(".") );
        StorePath storePath = storageClient.uploadFile(slidesshowPosition.getInputStream(), slidesshowPosition.getSize(), suffix.replace(".",""), null);
        System.out.println(storePath.getGroup() +"|"+ storePath.getPath());
        //入库
        slidesshowService.add(new Slidesshow(uuidName,slidesshowDescribe,storePath.getGroup()+"/"+storePath.getPath(),slidesshowFlag,new Date()));
        return "success";
    }
    /**
     * @Description 更新轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 轮播图属性
     * @Exception
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public String update(String slidesshowDescribe,String slidesshowFlag,MultipartFile slidesshowpicture,String slidesshowId,HttpSession session) throws Exception{
        if(!slidesshowpicture.getOriginalFilename().equals("")){
            //更新图片
            System.out.println("============更新图片===============");
            String realPath = session.getServletContext().getRealPath("upload").replace("cmfz-admin","");
            String oldName = slidesshowpicture.getOriginalFilename();
            String suffix = oldName.substring( oldName.lastIndexOf(".") );
            slidesshowpicture.transferTo(new File( realPath +"/"+ slidesshowId + suffix ));
            //更新属性值
            slidesshowService.modify(new Slidesshow(slidesshowId,slidesshowDescribe,slidesshowpicture.getOriginalFilename(),slidesshowFlag,new Date()));
        }else{
            System.out.println("============不更新图片===============");
            Slidesshow slidesshow = slidesshowService.queryById(slidesshowId);
            slidesshow.setSlidesshowDescribe(slidesshowDescribe);
            slidesshow.setSlidesshowFlag(slidesshowFlag);
            slidesshowService.modify(slidesshow);
        }
        return "success";
    }
}
