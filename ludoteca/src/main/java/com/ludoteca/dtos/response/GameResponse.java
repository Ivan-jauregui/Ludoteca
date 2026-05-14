package com.ludoteca.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameResponse {
    private String name;
    private String category;
    private Integer minimunAge;
}
