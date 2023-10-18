package com.practical.details.model.entity;


import com.practical.details.common.constants.Constants;
import com.practical.details.service.iface.BaseEntityIface;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(
        sql = " UPDATE tbl_groups SET deleted = true WHERE id=? "
)
public class BaseEntity implements BaseEntityIface, Serializable {
  
    @Column(name = "status")
    protected String status;

    @Id
    protected String id;

    private boolean deleted = Boolean.FALSE;

    @Override
    @PrePersist
    public void preInsert() {
        this.status = Constants.ACTIVE;
    }

    @Override
    @PreUpdate
    public void preUpdate() {
        
    }

    @Override
    @PostUpdate
    public void postUpdate() {

    }

    @Override
    @PreRemove
    public void preDelete() {
        
    }

    @Override
    @PostRemove
    public void postDelete() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;

        if (id == null) {
            return false;
        }

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
