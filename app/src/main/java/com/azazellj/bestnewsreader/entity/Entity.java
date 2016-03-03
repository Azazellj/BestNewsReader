package com.azazellj.bestnewsreader.entity;

/**
 * Created by azazellj on 3/1/16.
 */
public class Entity {
    private long id;

    protected Entity() {
    }

    protected Entity(Entity entity) {
        this.id = entity.getId();
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (object != null && object instanceof Entity) {
            Entity entity = (Entity) object;
            return this.id == entity.id;
        } else {
            return false;
        }
    }
}
