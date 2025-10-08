package com.learning_project_spring_boot.LearnProject.Service;


import com.learning_project_spring_boot.LearnProject.Model.StaffModel;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class StaffService {

    List<StaffModel> staff = new ArrayList<StaffModel>();

    public StaffService(){
        staff = Arrays.asList(
                new StaffModel(1,"Raja","MCA","IT","chennai",100000),
                new StaffModel(2,"kamal","B.tech","IT","Bangalore",10000),
                new StaffModel(3,"Rishab","B.tech","IT","Mumbai",250000)
        );
    }

    public List<StaffModel> getStaffList(){
        System.out.println("Service method is invoked");
        return staff;
    }

    public String addStaffList(StaffModel staffPayload){
        staff.add(staffPayload);
        return "Staff detail added successfully";
    }

    public String modifyStaffDetails(long id,StaffModel actualPayload){

        for(StaffModel item : staff){
            if(item.getStaffId() == id){
                item.setStaffId(actualPayload.getStaffId());
                item.setStaffName(actualPayload.getStaffName());
                item.setStaffQualifaction(actualPayload.getStaffQualifaction());
                item.setStaffDepartment(actualPayload.getStaffDepartment());
                item.setStaffAddress(actualPayload.getStaffAddress());
                item.setStaffSalary(actualPayload.getStaffSalary());

                return "Record Modified Successfully";
            }
        }



        return "ID is Not found";
    }
    public List<StaffModel> ModifyStaffDetailsStreamApi(long id,StaffModel actualPayload){
        List<StaffModel> updatedStaff = staff.stream()
                .filter(item -> item.getStaffId() == id)
                .peek(
                        item -> {
                            item.setStaffId(actualPayload.getStaffId());
                            item.setStaffName(actualPayload.getStaffName());
                            item.setStaffQualifaction(actualPayload.getStaffQualifaction());
                            item.setStaffDepartment(actualPayload.getStaffDepartment());
                            item.setStaffAddress(actualPayload.getStaffAddress());
                            item.setStaffSalary(actualPayload.getStaffSalary());
                        }
                )
                .collect(Collectors.toList());


        return updatedStaff;
    }

    public String modifyField(long id,StaffModel actualPayload){
        for(StaffModel data : staff){
            if(data.getStaffId() == id ){
                data.setStaffName(actualPayload.getStaffName());
                return "Record Modified Success";
            }
        }
        return "ID Not found";
    }

    public String removeStaff(long id){

        boolean isDeleted = staff
                .removeIf(item -> item != null && Objects.equals(item.getStaffId(),id));

        System.out.println(isDeleted);

        return isDeleted ? "Staff Details Removed successfully" : "ID Not Found";
    }




}