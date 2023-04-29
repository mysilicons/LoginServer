package cn.mysilicon.loginserver.controller;

import cn.mysilicon.loginserver.entity.BannerImage;
import cn.mysilicon.loginserver.mapper.BannerImageMapper;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bannerimage")
public class BannerImageController {
    @Resource
    private BannerImageMapper bannerImageMapper;

    @GetMapping("/list")
    public String getBannerImage() {
        List<BannerImage> imageList = bannerImageMapper.selectAll();
        Gson gson = new Gson();
        return gson.toJson(imageList);
    }
}
