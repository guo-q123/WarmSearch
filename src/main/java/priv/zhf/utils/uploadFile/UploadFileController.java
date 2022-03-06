package priv.zhf.utils.uploadFile;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * UploadFile  文件上传工具类接口
 *
 */
@Api(tags = {"文件上传工具类接口控制类"})
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadFileController {


    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
    @PostMapping
    public Map<String, Object> fileUpload(MultipartFile file,HttpServletRequest req) {
        Map<String, Object> result = new HashMap<>();
        String originalName = file.getOriginalFilename();
        String format = sdf.format(new Date());
        String realPath = "D:\\serach\\";
        File folder = new File(realPath);
        if(!folder.exists()) {
            folder.mkdirs();
        }
        String newName = UUID.randomUUID().toString() + ".jpg";
        try {
            file.transferTo(new File(folder,newName));
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/" + newName;
            result.put("status","success");
            result.put("url",url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }
        return result;
    }



//    //    @Autowired
////    private UploadFileService uploadFileService;
////
////    @ApiOperation("文件上传")
////    @PostMapping
////    public ResultResponse uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest req) {
////        ResultResponse res = null;
//////        HttpServletRequest req = null;
////        UploadFileServiceImpl up = new UploadFileServiceImpl();
////
////        System.out.println(up.url);
////
////        return uploadFileService.uploadFiles(file,req);
////    }
//
//    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
//    @PostMapping
//    public Map<String, Object> fileUpload(MultipartFile file,HttpServletRequest req) {
//        Map<String, Object> result = new HashMap<>();
//        String originalName = file.getOriginalFilename();
////        if(!originalName.endsWith(".png")) {
////            result.put("status","error");
////            result.put("msg","文件类型不对");
////            return result;
////        }
////        if(!originalName.endsWith(".jpg")) {
////            result.put("status","error");
////            result.put("msg","文件类型不对");
////            return result;
////        }
//        String format = sdf.format(new Date());
//        String realPath = "D:\\serach\\";
//        File folder = new File(realPath);
//        if(!folder.exists()) {
//            folder.mkdirs();
//        }
//        String newName = UUID.randomUUID().toString() + ".jpg";
//        try {
//            file.transferTo(new File(folder,newName));
////            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/" + newName;
//            String url = req.getServerName() + ":" + req.getServerPort() + "/" + newName;
//            result.put("status","success");
//            result.put("url",url);
//        } catch (IOException e) {
//            result.put("status","error");
//            result.put("msg",e.getMessage());
//        }
//
//        return result;
//
//    }



}
