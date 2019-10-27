package com.ma.raymond.rayment.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DDA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "from_acc_id")
    private Account fromAcc;

    @ManyToOne
    @JoinColumn(name = "to_acc_id")
    private Account toAcc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Account getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(Account fromAcc) {
        this.fromAcc = fromAcc;
    }

    public Account getToAcc() {
        return toAcc;
    }

    public void setToAcc(Account toAcc) {
        this.toAcc = toAcc;
    }
}
