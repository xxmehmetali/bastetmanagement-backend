//package com.bastet.bastetmanagement.core.configurations.modelmapper;
//
//import com.bastet.bastetmanagement.models.Corporation;
//import com.bastet.bastetmanagement.models.Model;
//import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class ModelMapperUtils<T, TDTO> {
//    private final Class<TDTO> type;
//    @Resource
//    private ModelMapper modelMapper;
//
//    public ModelMapperUtils(Class<TDTO> type) {
//        this.type = type;
//    }
//    public Class<TDTO> getMyType() {
//        return this.type;
//    }
//
////    public ModelMapperUtils(){
////
////    }
//
//
//    public List<TDTO> mapToList(List<Corporation> models, Class<TDTO> t){
//        List<TDTO> dto_list = new ArrayList<>();
//        models.stream()
//                .forEach(model -> {
//                    dto_list.add(modelMapper.map(model, getMyType()));
//                });
//        return dto_list;
//    }
//
//
////    public List<TDTO> mapToList(T all, Class<TDTO> corporationDtoClass) {
////        List<TDTO> dto_list = new ArrayList<>();
////        models.stream()
////                .forEach(model -> {
////                    dto_list.add(modelMapper.map(model, getMyType()));
////                });
////        return dto_list;
////    }
//}
