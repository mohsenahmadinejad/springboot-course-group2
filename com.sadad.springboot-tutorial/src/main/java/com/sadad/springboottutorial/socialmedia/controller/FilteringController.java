package com.sadad.springboottutorial.socialmedia.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sadad.springboottutorial.socialmedia.entity.SampleBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public SampleBean filtering(){
        return new SampleBean("value1","value2","value3");
    }


    @GetMapping("/filtering-list")
    public List<SampleBean> filteringList(){
        return Arrays.asList(new SampleBean("value1","value2","value3"),
                new SampleBean("value11","value22","value33"),
                new SampleBean("value111","value222","value333")
        ) ;
     }

//    @GetMapping("/filtering-dynamic")
//    public MappingJacksonValue filteringDynamic(){
//
//        SampleBean sampleBean= new SampleBean("value1","value2","value3");
//
//        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(sampleBean);
//        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
//        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SampleBeanFilter",filter);
//        mappingJacksonValue.setFilters(filterProvider);
//
//        return mappingJacksonValue;
//
//    }
//
//
//    @GetMapping("/filtering-list-dynamic")
//    public MappingJacksonValue filteringListDynamic(){
//        List<SampleBean> sampleBeanList= Arrays.asList(new SampleBean("value1","value2","value3"),
//                new SampleBean("value11","value22","value33"),
//                new SampleBean("value111","value222","value333")
//        ) ;
//        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(sampleBeanList);
//        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2");
//        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SampleBeanFilter",filter);
//        mappingJacksonValue.setFilters(filterProvider);
//
//        return mappingJacksonValue;
//
//     }


}
