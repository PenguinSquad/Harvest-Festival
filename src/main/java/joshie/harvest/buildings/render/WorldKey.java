package joshie.harvest.buildings.render;

import joshie.harvest.buildings.BuildingImpl;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import org.apache.commons.lang3.ObjectUtils;

public class WorldKey {
    private final Mirror mirror;
    private final Rotation rotation;
    private final BuildingImpl building;

    public WorldKey(Mirror mirror, Rotation rotation, BuildingImpl building) {
        this.mirror = mirror;
        this.rotation = rotation;
        this.building = building;
    }

    public static WorldKey of(Mirror mirror, Rotation rotation, BuildingImpl building) {
        return new WorldKey(mirror, rotation, building);
    }

    public Mirror getMirror() {
        return mirror;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public BuildingImpl getBuilding() {
        return building;
    }

    @SuppressWarnings( "deprecation" )
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof WorldKey) {
            final WorldKey other = (WorldKey) obj;
            return ObjectUtils.equals(getMirror(), other.getMirror())
                    && ObjectUtils.equals(getRotation(), other.getRotation())
                    && ObjectUtils.equals(getBuilding(), other.getBuilding());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return (getMirror() == null ? 0 : getMirror().hashCode()) ^
                (getRotation() == null ? 0 : getRotation().hashCode()) ^
                (getBuilding() == null ? 0 : getBuilding().hashCode());
    }
}
