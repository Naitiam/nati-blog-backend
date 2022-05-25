package com.mine.controller;

import com.mine.entity.MineInfo;
import com.mine.service.MineService;
import com.mine.util.Result;
import com.mine.util.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MineController {
    @Resource
    private MineService mineService;

    @GetMapping("/home")
    public Result<MineInfo> LoginAdm(){
        MineInfo adm = mineService.findMineInfo("Naitiam");
        adm.setAdmpwd("");
        return new Result<>(2000,"登录成功",adm);
    }

    @PostMapping("/login")
    public Result<MineInfo> LoginAdm(@RequestBody MineInfo mineInfo){
//        System.out.println("admname :"+ mineInfo.getAdmname());
//        System.out.println("admpwd :"+mineInfo.getAdmpwd());
        MineInfo adm = mineService.findMineInfo(mineInfo.getAdmname());
        if(adm !=null){
            if(adm.getAdmpwd().equals(mineInfo.getAdmpwd())){
                String token = TokenUtils.genToken(String.valueOf(adm.getAdmname()),adm.getAdmpwd());
                adm.setToken(token);
//                System.out.println("登陆成功的用户"+adm);
                return new Result<>(2000,"登录成功",adm);
            }
        }
        return new Result<>(2001,"登录失败",null);
    }
    @PostMapping("/modifyinfo")
    public Result<Void> modifyinfo(@RequestBody MineInfo mineInfo){
//        System.out.println(mineInfo+"这里是更新获取到的数据");
        int updateMineInfo = mineService.updateMineInfo(mineInfo);
        if(updateMineInfo==1){
            return new Result<Void>(2000,"更新成功",null);
        }else{
            return new Result<Void>(2001,"更新失败",null);
        }
    }
}
