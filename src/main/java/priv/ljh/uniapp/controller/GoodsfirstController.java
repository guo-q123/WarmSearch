package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import priv.ljh.pc.entity.PcGoodsdetail;
import priv.ljh.uniapp.entity.Goodsfirst;
import priv.ljh.uniapp.entity.Unbo;
import priv.ljh.uniapp.mapper.GoodsfirstMapper;
import priv.ljh.uniapp.service.GoodsfirstService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 首页展示的物品信息 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-02-19
 */
@Api(tags = {"首页展示的物品信息控制类"})
@Slf4j
@RestController
@RequestMapping("/goodsfirst")
public class GoodsfirstController {

    @Autowired
    private GoodsfirstMapper goodsfirstMapper;

    @Autowired
    private GoodsfirstService goodsfirstService;

    @ApiOperation("增加一条信息")
    @PostMapping("/all")
    public ResultResponse create(@RequestBody Goodsfirst goodsfirst){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        goodsfirstMapper.insert(goodsfirst);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, goodsfirst);
        return res;
    }

    @ApiOperation("增加一条首页展示的物品信息信息")
    @PostMapping
    public ResultResponse createGoodsfirst(Goodsfirst goodsfirst, MultipartFile file, HttpServletRequest req){
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
            goodsfirst.setImgurl(url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }

        goodsfirstMapper.insert(goodsfirst);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, goodsfirst);
        return res;
    }

    @ApiOperation("根据id删除一条首页展示的物品信息数据")
    @PostMapping("/delete")
    public ResultResponse deleteGoodsfirst (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = goodsfirstMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条首页展示的物品信息数据")
    @PutMapping
    public ResultResponse updateGoodsfirst(@RequestBody Goodsfirst goodsfirst){
        ResultResponse res = null;
        goodsfirstMapper.updateById(goodsfirst);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, goodsfirst);
        return res;
    }

    @ApiOperation("查询所有首页展示的物品信息信息")
    @GetMapping
    public ResultResponse queryGoodsfirst(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        PageHelper.startPage(pageNo,limit);
        List<Goodsfirst> goodsfirsts = goodsfirstMapper.selectList(null);
        PageInfo info = new PageInfo(goodsfirsts);
        log.info("goodsfirsts====>"+goodsfirsts);
        MyPage page = this.goodsfirstService.searchUnbo(pageNo, limit, idSort,goodsfirsts);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public priv.ljh.utils.requestMessage.ResultResponse queryUreteralDataById(@RequestParam("id") Integer id, @RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        priv.ljh.utils.requestMessage.ResultResponse res = null;
        List<Map> info = goodsfirstMapper.selectById(id);
        log.info("info====>"+info);
        priv.ljh.utils.requestMessage.MyPage page = this.goodsfirstService.searchById(pageNo, limit, idSort,info);
        res = new priv.ljh.utils.requestMessage.ResultResponse(priv.ljh.utils.requestMessage.Constants.STATUS_OK, priv.ljh.utils.requestMessage.Constants.MESSAGE_OK,page);
        return res;
    }

}

