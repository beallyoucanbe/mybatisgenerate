package com.shuoyi.Service;

import com.shuoyi.mapper.user.CityMapper;
import com.shuoyi.model.user.City;
import com.shuoyi.model.user.CityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaosy-c on 2017/12/28.
 */
@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public City getCityByPrimary(Integer id){
        CityExample oExample = new CityExample();
        CityExample.Criteria oCriteria = oExample.createCriteria();
        oCriteria.andIdEqualTo(id);
        return cityMapper.selectByExample(oExample).get(0);
    }
}
