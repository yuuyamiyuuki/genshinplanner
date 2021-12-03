package com.br.genshinplanner;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventEntity {

    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private Integer resinSpent;
    private String domain;
}
