package priv.zhf.utils;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT令牌，拦截器
 */
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();

        //获取请求头中的令牌
        String token = request.getHeader("Authorization" );
        //验证token
        try {
            //验证令牌
            PCJwtUtils.verify(token);
            //放行
            return true;
            //通过
//            map.put("state",true);
//            map.put("msg","请求成功");
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("message","无效签名");
        }catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("message","token过期");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("message","两次算法不一致");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","token无效");
        }
        //设置状态
        map.put("state",false);
        //响应回前台，将map转为json
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
