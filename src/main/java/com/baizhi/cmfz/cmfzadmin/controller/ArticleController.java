package com.baizhi.cmfz.cmfzadmin.controller;

import com.baizhi.cmfz.cmfzadmin.entity.Article;
import com.baizhi.cmfz.cmfzadmin.entity.Guru;
import com.baizhi.cmfz.cmfzadmin.entity.RichTextResult;
import com.baizhi.cmfz.cmfzadmin.service.ArticleService;
import com.baizhi.cmfz.cmfzadmin.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private GuruService guruService;
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/selectAllArticle.do")
    @ResponseBody
    public List<Article> selectAllArticle(){
        return  articleService.selectAllArticle();
    }

        @RequestMapping("/add.do")
    @ResponseBody
    public String add(String articleTitle,String guruI,String articleFlag,String articleContent){
        String articleID = UUID.randomUUID().toString().replace("-", "");
        if(articleFlag==null){
            articleFlag = "下架";
        }else if(articleFlag.equals("on")){
            articleFlag = "上架";
        }
        articleService.add(new Article(articleID,articleTitle,articleContent,new Date(),guruI,articleFlag));
        return "success";
    }
    @RequestMapping("/all.do")
    @ResponseBody
    public List<Guru> all(){
        return guruService.queryAll();
    }
    @RequestMapping("/upload.do")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException { // MultipartFile[] 代表多文件上传
        HttpSession session = request.getSession();
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        List<String> lists = new ArrayList<String>();
        for (MultipartFile file : files) {
            lists.add(file.getOriginalFilename());
        }
        try {
            String realPath = session.getServletContext().getRealPath("upload").replace("cmfz-admin","");
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String uuidName = UUID.randomUUID().toString().replace("-", "");
                    String oldName = file.getOriginalFilename();
                    String suffix = oldName.substring( oldName.lastIndexOf(".") );
                    file.transferTo(new File( realPath +"/"+ uuidName + suffix ));
                    data.add(request.getContextPath()+"/upload/"+uuidName+suffix);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }
}
