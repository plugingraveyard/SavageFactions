package net.prosavage.factionsx.upgrade

import net.prosavage.factionsx.FactionsX
import net.prosavage.factionsx.persist.data.getFLocation
import net.prosavage.factionsx.util.SerializableItem
import org.bukkit.CropState
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.block.BlockGrowEvent
import org.bukkit.material.Crops

class WheatUpgrade(name: String, item: SerializableItem, maxLevelLore: List<String>, costLevel: Map<Int, LevelInfo>)
    : Upgrade(name, item, maxLevelLore, costLevel) {
    override val upgradeListener = WheatInstantGrowListener(this, FactionsX.instance)

    class WheatInstantGrowListener(override val upgrade: Upgrade, override val factionsX: FactionsX) : UpgradeListener {

        @EventHandler
        fun onCropGrow(event: BlockGrowEvent) {
            if (Material.matchMaterial(event.block.type.name) !== Material.WHEAT) return
            if (!runUpgradeEffectWithChance(getFLocation(event.block.chunk))) return

            event.isCancelled = true
            val blockState = event.block.state
            blockState.data = Crops(CropState.RIPE)
            blockState.update()
        }

    }
}