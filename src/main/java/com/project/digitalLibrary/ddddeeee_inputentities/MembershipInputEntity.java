package com.project.digitalLibrary.ddddeeee_inputentities;

import com.project.digitalLibrary.zzzz_utils.MembershipPlan;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MembershipInputEntity {

    @NotNull
    private long userId;

    @NotNull
    private MembershipPlan plan;

}
