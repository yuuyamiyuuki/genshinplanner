package com.br.genshinplanner;

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
}
