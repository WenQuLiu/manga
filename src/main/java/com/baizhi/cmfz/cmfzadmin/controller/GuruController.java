package com.baizhi.cmfz.cmfzadmin.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.cmfzadmin.entity.Guru;
import com.baizhi.cmfz.cmfzadmin.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * @Description 上师控制层功能
 * @Author wumengkai
 * @Time 2018-7-6
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    /**
     * @Description 分页查找上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 当前页码，单页显示条数
     * @Exception
     */
    @RequestMapping("/find.do")
    @ResponseBody
    public Map<String,Object> find(@RequestParam("page") Integer nowPage, @RequestParam("rows")Integer pageSize){
        return guruService.queryByPage(nowPage,pageSize);
    }
    /**
     * @Description 分页模糊查找上师信息
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 当前页码，单页显示条数，模糊查找的属性
     * @Exception
     */
    @RequestMapping("/findproperty.do")
    @ResponseBody
    public Map<String,Object> findProperty(@RequestParam("page") Integer nowPage, @RequestParam("rows")Integer pageSize,String value,String name){
        Guru guru = new Guru();
        if(name.equals("guruId")){
            guru.setGuruId(value);
        }else if(name.equals("guruName")){
            guru.setGuruName(value);
        }
        return guruService.quertPropertyByPage(nowPage,pageSize,guru);
    }
    /**
     * @Description 添加上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 上师各属性值
     * @Exception
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public String insert(String guruName, MultipartFile guruPhoto, String guruContent, HttpSession session) throws IOException{
        //文件上传
        String realPath = session.getServletContext().getRealPath("upload").replace("cmfz-admin","");
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        String oldName = guruPhoto.getOriginalFilename();
        String suffix = oldName.substring( oldName.lastIndexOf(".") );
        guruPhoto.transferTo(new File( realPath +"/"+ uuidName + suffix ));
        //添加上师信息
        guruService.add(new Guru(uuidName,guruName,guruPhoto.getOriginalFilename(),guruContent));
        return "success";
    }
    /**
     * @Description 多条信息上传
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 上传文件
     * @Exception
     */
    @RequestMapping("/addmore.do")
    @ResponseBody
    public String addmore(MultipartFile gurumore,HttpSession session) throws Exception{
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        params.setNeedSave(false);
        System.out.println("===================实体类接收=======================");
        List<Guru> list = ExcelImportUtil.importExcel(gurumore.getInputStream(), Guru.class, params);
        for (Guru guru : list) {
            guruService.add(guru);
            System.out.println(guru);
        }
        System.out.println("====================导入成功=======================");
        return "success";
    }
    /**
     * @Description 下载上师数据
     * @Author wumengkai
     * @Time 2018-7-8
     * @Param
     * @Exception
     */
    @RequestMapping("/explore.do")
    public void exportExcl(HttpServletResponse response) throws IOException{
        List<Guru> gurus = guruService.queryAll();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("上师信息","上师信息"),Guru.class,gurus);
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        String fileName = new String("上师数据.xls".getBytes(),"iso-8859-1");
        response.setHeader("content-disposition","attachment;fileName="+fileName);
        workbook.write(out);
        out.close();

    }
    /**
     * @Description 更新上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 用户名,密码,验证码
     * @Exception
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public String update(String guruId, String guruName, MultipartFile guruPicture, String guruContent,HttpSession session) throws IOException{
        //是否更新图片
        if(!guruPicture.getOriginalFilename().equals("")){
            //将更新的图片上传
            String realPath = session.getServletContext().getRealPath("upload").replace("cmfz-admin","");
            String oldName = guruPicture.getOriginalFilename();
            String suffix = oldName.substring( oldName.lastIndexOf(".") );
            guruPicture.transferTo(new File( realPath +"/"+ guruId + suffix ));
            //更新新上师信息
            guruService.modify(new Guru(guruId,guruName,guruPicture.getOriginalFilename(),guruContent));
        }else{
            //更新上师信息
            Guru guru = guruService.queryById(guruId);
            guru.setGuruName(guruName);
            guru.setGuruContent(guruContent);
            guruService.modify(guru);
        }
        return "success";
    }

}
