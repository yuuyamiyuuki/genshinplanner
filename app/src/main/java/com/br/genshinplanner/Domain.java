package com.br.genshinplanner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Domain {
    private String domainName;
    private int domainImage;

    public static List<Domain> getDomains(){
        List<Domain> domainList = new ArrayList<>();

        domainList.add(Domain.builder()
                .domainName("Midsummer Courtyard")
                .domainImage(R.drawable.midsummer)
                .build());

        domainList.add(Domain.builder()
                .domainName("Valley of Remembrance")
                .domainImage(R.drawable.valley)
                .build());

        domainList.add(Domain.builder()
                .domainName("Peak of Vindagnyr")
                .domainImage(R.drawable.peak)
                .build());

        domainList.add(Domain.builder()
                .domainName("Midsummer Courtyard")
                .domainImage(R.drawable.midsummer)
                .build());

        domainList.add(Domain.builder()
                .domainName("Midsummer Courtyard")
                .domainImage(R.drawable.midsummer)
                .build());

        domainList.add(Domain.builder()
                .domainName("Domain of Guyun")
                .domainImage(R.drawable.goyun)
                .build());

        domainList.add(Domain.builder()
                .domainName("Hidden Palace of Zhou Formula")
                .domainImage(R.drawable.zhouy)
                .build());

        domainList.add(Domain.builder()
                .domainName("Clear Pool and Mountain Cavern")
                .domainImage(R.drawable.pool)
                .build());

        domainList.add(Domain.builder()
                .domainName("Ridge Watch")
                .domainImage(R.drawable.ridge)
                .build());

        domainList.add(Domain.builder()
                .domainName("Momiji-Dyed Court")
                .domainImage(R.drawable.momiji)
                .build());

        domainList.add(Domain.builder()
                .domainName("Slumbering Court")
                .domainImage(R.drawable.slumbering)
                .build());

        return domainList;
    }

    public static List<Domain> getDailyWeaponDomains(LocalDate date){
        List<Domain> domainList = new ArrayList<>();
        if(date.getDayOfWeek().equals(DayOfWeek.MONDAY) || date.getDayOfWeek().equals(DayOfWeek.THURSDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            domainList.add(Domain.builder()
                    .domainName("Cecilia Garden")
                    .domainImage(R.drawable.ceciliamondaythursday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Hidden Palace of Lianshan Formula")
                    .domainImage(R.drawable.lianshanmondaythursday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Court of Flowing Sand")
                    .domainImage(R.drawable.flowingmondaythursday)
                    .build());
        }
        if(date.getDayOfWeek().equals(DayOfWeek.TUESDAY) || date.getDayOfWeek().equals(DayOfWeek.FRIDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            domainList.add(Domain.builder()
                    .domainName("Cecilia Garden")
                    .domainImage(R.drawable.ceciliatuesdayfriday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Hidden Palace of Lianshan Formula")
                    .domainImage(R.drawable.lianshantuesdayfriday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Court of Flowing Sand")
                    .domainImage(R.drawable.flowingtuesdayfriday)
                    .build());
        }
        if(date.getDayOfWeek().equals(DayOfWeek.WEDNESDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            domainList.add(Domain.builder()
                    .domainName("Cecilia Garden")
                    .domainImage(R.drawable.ceciliawednesdaysaturday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Hidden Palace of Lianshan Formula")
                    .domainImage(R.drawable.lianshanwednesdaysaturday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Court of Flowing Sand")
                    .domainImage(R.drawable.flowingwednesdaysaturday)
                    .build());
        }

        return domainList;
    }

    public static List<Domain> getDailyTalentDomains(LocalDate date){
        List<Domain> domainList = new ArrayList<>();
        if(date.getDayOfWeek().equals(DayOfWeek.MONDAY) || date.getDayOfWeek().equals(DayOfWeek.THURSDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            domainList.add(Domain.builder()
                    .domainName("Forsaken Rift")
                    .domainImage(R.drawable.forsakenmondaythursday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Taishan Mansion")
                    .domainImage(R.drawable.taishanmondaythursday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Violet Court")
                    .domainImage(R.drawable.violetmondaythursday)
                    .build());
        }
        if(date.getDayOfWeek().equals(DayOfWeek.TUESDAY) || date.getDayOfWeek().equals(DayOfWeek.FRIDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            domainList.add(Domain.builder()
                    .domainName("Forsaken Rift")
                    .domainImage(R.drawable.forsakentuesdayfriday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Taishan Mansion")
                    .domainImage(R.drawable.taishantuesdayfriday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Violet Court")
                    .domainImage(R.drawable.violettuesdayfriday)
                    .build());
        }
        if(date.getDayOfWeek().equals(DayOfWeek.WEDNESDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            domainList.add(Domain.builder()
                    .domainName("Forsaken Rift")
                    .domainImage(R.drawable.forsakenwednesdaysaturday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Taishan Mansion")
                    .domainImage(R.drawable.taishanwednesdaysaturday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName("Violet Court")
                    .domainImage(R.drawable.violetwednesdaysaturday)
                    .build());
        }

        return domainList;
    }

    public static List<Domain> getDailyDomains(LocalDate date){
        List<Domain> dateDomains = Domain.getDomains();
        dateDomains.addAll(Domain.getDailyWeaponDomains(date));
        dateDomains.addAll(Domain.getDailyTalentDomains(date));
        return dateDomains;
    }

}
