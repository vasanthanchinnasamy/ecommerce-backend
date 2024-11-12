package com.innovate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderKey  implements Serializable {

    @Column(name = "case_tid")
    private Long caseTid;

    @Column(name = "tag_id")
    private Long tagId;

}
