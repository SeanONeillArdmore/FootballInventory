package com.footballinventory.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jersey {

    private String jerseyId;
    private String team;
    private String size;
    private String color;
}
