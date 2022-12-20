//package com.bastet.bastetmanagement.core.configurations.modelmapper;
//
//import com.bastet.bastetmanagement.controllers.ExpenseController;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Component
//public class CustomModelMapper extends ModelMapper{
//    public <S, T> List<T> mapToList(List<S> source, Class<T> targetClass) {
//        return source
//                .stream()
//                .map(element -> map(element, targetClass))
//                .collect(Collectors.toList());
//    }
//}
