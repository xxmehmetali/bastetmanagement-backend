package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.ChildDao;
import com.bastet.bastetmanagement.daos.ParentDao;
import com.bastet.bastetmanagement.facades.meeting.MeetingFacade;
import com.bastet.bastetmanagement.models.Child;
import com.bastet.bastetmanagement.models.Parent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/try")
public class HeyController {

    @Resource
    private ChildDao childDao;

    @Resource
    private ParentDao parentDao;

	@GetMapping
    public void trybitch() {

//		Parent parent1 = new Parent();
//		parent1.setName("parent1");
//
//		Child child1 = new Child();
//		child1.setName("child1");
//
//
//
//		//----
//
//		Parent parent2 = new Parent();
//		parent2.setName("parent2");
//
//		Child child2 = new Child();
//		child2.setName("child2");
//
//
//
//		childDao.saveAll(List.of(child1, child2));
//		parentDao.saveAll(List.of(parent1, parent2));
		Child child1 = childDao.findByName("child1");
		Child child2 = childDao.findByName("child2");

		Parent parent1 = parentDao.findByName("parent1");
		Parent parent2 = parentDao.findByName("parent2");

        parentDao.delete(parent1);
//
//		child1.setParent(parent1);
//		parent1.setChild(child1);
//
//        child2.setParent(parent2);
//        parent2.setChild(child2);

//        childDao.saveAll(List.of(child1, child2));
//        parentDao.saveAll(List.of(parent1, parent2));
    }

}
