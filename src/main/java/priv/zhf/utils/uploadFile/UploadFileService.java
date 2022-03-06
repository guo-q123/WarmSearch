package priv.zhf.utils.uploadFile;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import priv.zhf.utils.ResultResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * UploadFileService
 *
 */
@Service
public interface UploadFileService {
    /**
     * 文件上传
     * @param file
     * @return
     */
    ResultResponse uploadFiles(MultipartFile file, HttpServletRequest req);

}
