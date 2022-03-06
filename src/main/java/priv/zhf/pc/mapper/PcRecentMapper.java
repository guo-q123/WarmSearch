package priv.zhf.pc.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import priv.zhf.pc.entity.PcRecent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * PC端最新信息 Mapper 接口
 * </p>
 *
 */
@Mapper
@Repository
@ApiModel("PC端最新信息实体接口类")
public interface PcRecentMapper extends BaseMapper<PcRecent> {

}
