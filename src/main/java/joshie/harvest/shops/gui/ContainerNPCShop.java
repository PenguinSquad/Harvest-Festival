package joshie.harvest.shops.gui;

import joshie.harvest.core.base.gui.ContainerBase;
import joshie.harvest.npcs.entity.EntityNPC;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerNPCShop extends ContainerBase {
    private final EntityNPC npc;

    public ContainerNPCShop(EntityNPC npc) {
        this.npc = npc;
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {
        npc.setTalking(null);
    }
}
