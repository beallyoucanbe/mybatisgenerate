package com.shuoyi.Service;

import com.shuoyi.mapper.user.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaosy-c on 2017/12/28.
 */
@Service
public class CountryService {

    @Autowired
    private CountryMapper countryMapper;


}
