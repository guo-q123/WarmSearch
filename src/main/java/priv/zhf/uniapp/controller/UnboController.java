package priv.zhf.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import priv.zhf.uniapp.entity.Unbo;
import priv.zhf.uniapp.mapper.UnboMapper;
import priv.zhf.uniapp.service.UnboService;
import priv.zhf.utils.Constants;
import priv.zhf.utils.MyPage;
import priv.zhf.utils.ResultResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 * 首页轮播图 前端控制器
 * </p>
 */
@Api(tags = {"首页轮播图控制类"})
@Slf4j
@RestController
@RequestMapping("/unbo")
public class UnboController {
    @Autowired
    private UnboMapper unboMapper;

    @Autowired
    private UnboService unboService;

    @ApiOperation("增加一条信息")
    @PostMapping("/all")
    public ResultResponse create(@RequestBody Unbo unbo){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        unboMapper.insert(unbo);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, unbo);
        return res;
    }

    @ApiOperation("增加一条轮播图信息")
    @PostMapping
    public ResultResponse create(Unbo unbo,MultipartFile file, HttpServletRequest req){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);

        Map<String, Object> result = new HashMap<>();
        String originalName = file.getOriginalFilename();
        if(!originalName.endsWith(".png")) {
            result.put("status","error");
            result.put("msg","文件类型不对");
        }else if(!originalName.endsWith(".jpg")) {
            result.put("status","error");
            result.put("msg","文件类型不对");
        }
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

            //将图片地址存入数据库
            unbo.setImgUrl(url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }
        unboMapper.insert(unbo);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, unbo);
        return res;
    }

    @ApiOperation("根据id删除一条轮播图数据")
    @PostMapping("/delete")
    public ResultResponse deleteUnbo (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = unboMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条轮播图数据")
    @PutMapping
    public ResultResponse updateUnbo(@RequestBody Unbo unbo){
        ResultResponse res = null;
        unboMapper.updateById(unbo);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, unbo);
        return res;
    }

    @ApiOperation("查询所有轮播图信息")
    @GetMapping
    public ResultResponse queryUnbo(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        PageHelper.startPage(pageNo,limit);
        List<Unbo> unbos = unboMapper.selectList(null);
        PageInfo info = new PageInfo(unbos);
        log.info("unbos====>"+unbos);
        MyPage page = this.unboService.searchUnbo(pageNo, limit, idSort,unbos);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

}

