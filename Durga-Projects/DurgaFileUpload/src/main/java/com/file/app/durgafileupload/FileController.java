package com.file.app.durgafileupload;

import com.file.app.durgafileupload.entity.ResponseFile;
import com.file.app.durgafileupload.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileController {

    @Autowired
    private FileStorageService storageService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login-page";
    }

    @PostMapping("/files")
    public ModelAndView validateUser(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        String userName = request.getParameter("uname");
        String password = request.getParameter("psw");
        if (userName.equals("durga") && password.equals("password")) {
            model.setViewName("file-upload");
        } else {
            model.addObject("wrongObject","You Have Entered Worng Username and Password.");
            model.setViewName("login-page");
        }
        return model;
    }

    /*@PostMapping("/uploadFile")
    public String uploadFileToDatabase(HttpServletRequest request) {
        request.getParameter("filename");
        return "file-upload";
    }*/

    @RequestMapping(value="/uploadFile",method= RequestMethod.POST)
    public ModelAndView upload(@RequestParam MultipartFile file, HttpSession session) throws IOException {
        String path=session.getServletContext().getRealPath("/");
        String filename=file.getOriginalFilename();
        storageService.store(file);
        System.out.println(path+" "+filename);
        try{
            byte barr[]=file.getBytes();

            BufferedOutputStream bout=new BufferedOutputStream(
                    new FileOutputStream(path+"/"+filename));
            bout.write(barr);
            bout.flush();
            bout.close();

        }catch(Exception e){
            System.out.println(e);
        }
        return new ModelAndView("upload-success","filename",path+"/"+filename);
    }

    @GetMapping("/uploadNewFile")
    public String uploadNewFile() {
        return "file-upload";
    }

    @GetMapping("/showAllFiles")
    public ModelAndView getListFiles() {
        ModelAndView model = new ModelAndView();
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        model.addObject("files", files);
        model.setViewName("all-files");
        return model;
    }
}
