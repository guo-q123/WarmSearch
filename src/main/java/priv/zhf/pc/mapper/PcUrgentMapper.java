package priv.zhf.pc.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.zhf.pc.entity.PcUrgent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * PC端急需物品 Mapper 接口
 * </p>
 *
 */
@Mapper
@Repository
@ApiModel("PC端急需物品实体接口类")
public interface PcUrgentMapper extends BaseMapper<PcUrgent> {

    @Select("select id, panelId, type, url, create_time, updated_time, goods_name, goods_detail, status from pc_urgent where id=#{id}")
    List<Map> getUrgentId(@Param("id")Integer id);
}
