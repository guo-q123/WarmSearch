package priv.zhf.pc.controller;


import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import priv.zhf.pc.entity.PcRecent;
import priv.zhf.pc.mapper.PcRecentMapper;
import priv.zhf.pc.service.PcRecentService;
import priv.zhf.utils.Constants;
import priv.zhf.utils.MyPage;
import priv.zhf.utils.ResultResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * PC端最新信息 前端控制器
 * </p>
 *
 */
@Api(tags = {"PC端最新信息控制类"})
@Slf4j
@RestController
@RequestMapping("/pcrecent")
public class PcRecentController {
    @Autowired
    private PcRecentMapper pcRecentMapper;

    @Autowired
    private PcRecentService pcRecentService;

    @ApiOperation("增加一条信息")
    @PostMapping("/all")
    public ResultResponse create(@RequestBody PcRecent pcRecent){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        pcRecentMapper.insert(pcRecent);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, pcRecent);
        return res;
    }

    @ApiOperation("增加一条PC端最新信息")
    @PostMapping
    public ResultResponse create(PcRecent pcRecent, MultipartFile file, HttpServletRequest req){
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
            pcRecent.setUrl(url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }
        pcRecentMapper.insert(pcRecent);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, pcRecent);
        return res;
    }

    @ApiOperation("根据id删除一条PC端最新信息数据")
    @PostMapping("/delete")
    public ResultResponse deletePcCarousel (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = pcRecentMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条PC端最新信息数据")
    @PutMapping
    public ResultResponse updatePcCarousel(@RequestBody PcRecent pcRecent){
        ResultResponse res = null;
        pcRecentMapper.updateById(pcRecent);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, pcRecent);
        return res;
    }

    @ApiOperation("查询所有PC端最新信息信息")
    @GetMapping
    public ResultResponse queryPcCarousel(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        PageHelper.startPage(pageNo,limit);
        List<PcRecent> pcRecents = pcRecentMapper.selectList(null);
        PageInfo info = new PageInfo(pcRecents);
        log.info("pcRecents====>"+pcRecents);
        MyPage page = this.pcRecentService.searchPcRecent(pageNo, limit, idSort,pcRecents);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

