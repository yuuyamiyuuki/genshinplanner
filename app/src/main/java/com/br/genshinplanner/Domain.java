package com.br.genshinplanner;

import android.content.Context;
import android.content.res.Resources;

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
    private String domainLocation;
    private int domainImage;

    public static List<Domain> getDomains(Context context){
        List<Domain> domainList = new ArrayList<>();

        domainList.add(Domain.builder()
                .domainName(context.getString(R.string.midsummer))
                .domainLocation(context.getString(R.string.midsummerLocation))
                .domainImage(R.drawable.midsummer)
                .build());

        domainList.add(Domain.builder()
                .domainName(context.getString(R.string.valley))
                .domainLocation(context.getString(R.string.valleyLocation))
                .domainImage(R.drawable.valley)
                .build());

        domainList.add(Domain.builder()
                .domainName(context.getString(R.string.peak))
                .domainLocation(context.getString(R.string.peakLocation))
                .domainImage(R.drawable.peak)
                .build());

        domainList.add(Domain.builder()
                .domainName(context.getString(R.string.guyun))
                .domainLocation(context.getString(R.string.guyunLocation))
                .domainImage(R.drawable.goyun)
                .build());

        domainList.add(Domain.builder()
                .domainName(context.getString(R.string.zhou))
                .domainLocation(context.getString(R.string.zhouLocation))
                .domainImage(R.drawable.zhouy)
                .build());

        domainList.add(Domain.builder()
                .domainName(context.getString(R.string.pool))
                .domainLocation(context.getString(R.string.poolLocation))
                .domainImage(R.drawable.pool)
                .build());

        domainList.add(Domain.builder()
                .domainName(context.getString(R.string.ridge))
                .domainLocation(context.getString(R.string.ridgeLocation))
                .domainImage(R.drawable.ridge)
                .build());

        domainList.add(Domain.builder()
                .domainName(context.getString(R.string.momiji))
                .domainLocation(context.getString(R.string.momijiLocation))
                .domainImage(R.drawable.momiji)
                .build());

        domainList.add(Domain.builder()
                .domainName(context.getString(R.string.slumbering))
                .domainLocation(context.getString(R.string.slumberingLocation))
                .domainImage(R.drawable.slumbering)
                .build());

        return domainList;
    }

    public static List<Domain> getDailyWeaponDomains(LocalDate date, Context context){
        List<Domain> domainList = new ArrayList<>();
        if(CalendarUtils.checkIfMondayThursday(date)) {
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.cecilia))
                    .domainLocation(context.getString(R.string.ceciliaLocation))
                    .domainImage(R.drawable.ceciliamondaythursday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.lianshan))
                    .domainLocation(context.getString(R.string.lianshanLocation))
                    .domainImage(R.drawable.lianshanmondaythursday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.flowing))
                    .domainLocation(context.getString(R.string.flowingLocation))
                    .domainImage(R.drawable.flowingmondaythursday)
                    .build());
        }
        if(CalendarUtils.checkIfTuesdayFriday(date)) {
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.cecilia))
                    .domainLocation(context.getString(R.string.ceciliaLocation))
                    .domainImage(R.drawable.ceciliatuesdayfriday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.lianshan))
                    .domainLocation(context.getString(R.string.lianshanLocation))
                    .domainImage(R.drawable.lianshantuesdayfriday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.flowing))
                    .domainLocation(context.getString(R.string.flowingLocation))
                    .domainImage(R.drawable.flowingtuesdayfriday)
                    .build());
        }
        if(CalendarUtils.checkIfWednesdaySaturday(date)) {
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.cecilia))
                    .domainLocation(context.getString(R.string.ceciliaLocation))
                    .domainImage(R.drawable.ceciliawednesdaysaturday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.lianshan))
                    .domainLocation(context.getString(R.string.lianshanLocation))
                    .domainImage(R.drawable.lianshanwednesdaysaturday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.flowing))
                    .domainLocation(context.getString(R.string.flowingLocation))
                    .domainImage(R.drawable.flowingwednesdaysaturday)
                    .build());
        }

        return domainList;
    }

    public static List<Domain> getDailyTalentDomains(LocalDate date, Context context){
        List<Domain> domainList = new ArrayList<>();
        if(CalendarUtils.checkIfMondayThursday(date)) {
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.forsaken))
                    .domainLocation(context.getString(R.string.forsakenLocation))
                    .domainImage(R.drawable.forsakenmondaythursday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.taishan))
                    .domainLocation(context.getString(R.string.taishanLocation))
                    .domainImage(R.drawable.taishanmondaythursday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.violet))
                    .domainLocation(context.getString(R.string.violetLocation))
                    .domainImage(R.drawable.violetmondaythursday)
                    .build());
        }
        if(CalendarUtils.checkIfTuesdayFriday(date)) {
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.forsaken))
                    .domainLocation(context.getString(R.string.forsakenLocation))
                    .domainImage(R.drawable.forsakentuesdayfriday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.taishan))
                    .domainLocation(context.getString(R.string.taishanLocation))
                    .domainImage(R.drawable.taishantuesdayfriday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.violet))
                    .domainLocation(context.getString(R.string.violetLocation))
                    .domainImage(R.drawable.violettuesdayfriday)
                    .build());
        }
        if(CalendarUtils.checkIfWednesdaySaturday(date)) {
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.forsaken))
                    .domainLocation(context.getString(R.string.forsakenLocation))
                    .domainImage(R.drawable.forsakenwednesdaysaturday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.taishan))
                    .domainLocation(context.getString(R.string.taishanLocation))
                    .domainImage(R.drawable.taishanwednesdaysaturday)
                    .build());
            domainList.add(Domain.builder()
                    .domainName(context.getString(R.string.violet))
                    .domainLocation(context.getString(R.string.violetLocation))
                    .domainImage(R.drawable.violetwednesdaysaturday)
                    .build());
        }

        return domainList;
    }

    public static List<Domain> getDailyDomains(LocalDate date, Context context){
        List<Domain> dateDomains = Domain.getDomains(context);
        dateDomains.addAll(Domain.getDailyWeaponDomains(date, context));
        dateDomains.addAll(Domain.getDailyTalentDomains(date, context));
        return dateDomains;
    }

}
