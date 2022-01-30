package com.footballinventory.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jersey {

    @ApiModelProperty(notes = "Id",name="id",required=true,value="Jersey id")
    private String jerseyId;

    @ApiModelProperty(notes = "Team",name="team",required=true,value="team name")
    private String team;

    @ApiModelProperty(notes = "Jersey Size",name="size",required=true,value="jersey size")
    private String size;

    @ApiModelProperty(notes = "Jersey Color",name="color",required=true,value="Jersey color")
    private String color;
}
