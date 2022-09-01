package com.ll.exam.qsl.interestKeyword.entity;

import com.ll.exam.qsl.user.entity.SiteUser;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InterestKeyword {
    @Id
    @EqualsAndHashCode.Include
    private String content;

    @ManyToOne
    private SiteUser siteUser;
}