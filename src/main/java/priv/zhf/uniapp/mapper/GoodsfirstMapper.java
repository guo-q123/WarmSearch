package priv.zhf.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.zhf.uniapp.entity.Goodsfirst;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 首页展示的物品信息 Mapper 接口
 * </p>
 *
 */
@Mapper
@Repository
@ApiModel("首页展示的物品信息实体接口类")
public interface GoodsfirstMapper extends BaseMapper<Goodsfirst> {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from goodsfirst where id  = #{id}")
    List<Map> selectById(@Param("id") Integer id);

}
