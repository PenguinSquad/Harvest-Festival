package joshie.harvest.buildings.items;

import joshie.harvest.api.core.ICreativeSorted;
import joshie.harvest.buildings.Building;
import joshie.harvest.buildings.BuildingRegistry;
import joshie.harvest.buildings.HFBuildings;
import joshie.harvest.buildings.render.BuildingKey;
import joshie.harvest.core.HFTab;
import joshie.harvest.core.base.ItemHFFML;
import joshie.harvest.core.helpers.TownHelper;
import joshie.harvest.core.helpers.generic.BuildingHelper;
import joshie.harvest.core.util.Text;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemBuilding extends ItemHFFML<ItemBuilding, Building> implements ICreativeSorted {
    public ItemBuilding() {
        super(BuildingRegistry.REGISTRY, HFTab.TOWN);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        Building building = getObjectFromStack(stack);
        if (world.provider.getDimension() == 0 && building != null && !TownHelper.getClosestTownToPlayer(player).hasBuilding(building.getRegistryName())) {
            RayTraceResult raytrace = BuildingHelper.rayTrace(player, 128, 0F);
            if (raytrace == null || raytrace.getBlockPos() == null || raytrace.sideHit != EnumFacing.UP) {
                return new ActionResult(EnumActionResult.PASS, stack);
            }

            BuildingKey key = BuildingHelper.getPositioning(world, raytrace, building, player, hand);
            return new ActionResult<>(building.generate(world, key.getPos(), key.getMirror(), key.getRotation()), stack);
        }

        return new ActionResult(EnumActionResult.PASS, stack);
    }

    @Override
    public Building getNullValue() {
        return HFBuildings.null_building;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return Text.format("harvestfestival.structures.spawn", getObjectFromStack(stack).getLocalisedName());
    }

    @Override
    public int getSortValue(ItemStack stack) {
        return 200;
    }
}
