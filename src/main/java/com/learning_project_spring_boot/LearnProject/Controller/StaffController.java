package com.learning_project_spring_boot.LearnProject.Controller;


import com.learning_project_spring_boot.LearnProject.Model.StaffModel;
import com.learning_project_spring_boot.LearnProject.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/staff/")
public class StaffController {
    @Autowired
    private StaffService serviceobj;

    @GetMapping("getAllStaffList")

    public List<StaffModel> listallStaffs(
            @RequestHeader("token") String token
    ){
        if(token.equals("saravanan-security-api")){
            System.out.println("True block");
            return this.serviceobj.getStaffList();
        }
        else{
            return null;
        }

    }

    @PostMapping("addStaff")
    public String addStaffList(
            @RequestBody StaffModel staffPayload
    ){
        return this.serviceobj.addStaffList(staffPayload);
    }

    @PutMapping("modifyStaff/{id}")
    public List<StaffModel> modifyStaffDetails(
            @PathVariable long id,
            @RequestBody StaffModel updateStaffPayload
    ){
        return this.serviceobj.ModifyStaffDetailsStreamApi(id,updateStaffPayload);
    }


    @PatchMapping("staffNameFileldChange/{id}")
    public String modifyStaffFields(
            @PathVariable long id,
            @RequestBody StaffModel actualPayload
    ){

        return this.serviceobj.modifyField(id,actualPayload);
    }


    @DeleteMapping("/recordDelete/{id}")
    public String removeStaffDetail(
            @PathVariable long id
    ){


        return this.serviceobj.removeStaff(id);
    }

}