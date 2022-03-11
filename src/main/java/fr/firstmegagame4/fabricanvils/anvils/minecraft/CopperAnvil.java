package fr.firstmegagame4.fabricanvils.anvils.minecraft;

import fr.firstmegagame4.fabricanvils.anvils.BaseAnvil;
import fr.firstmegagame4.fabricanvils.anvils.InferiorMetalAnvil;
import fr.firstmegagame4.fabricanvils.screenhandlers.minecraft.CopperAnvilScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CopperAnvil extends InferiorMetalAnvil {

    public CopperAnvil(Settings settings) {
        super(settings);
    }

    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        this.playLandingAnvilSound(world, pos, SoundEvents.BLOCK_COPPER_PLACE);
    }

    @Override
    public void onDestroyedOnLanding(World world, BlockPos pos, FallingBlockEntity fallingBlockEntity) {
        this.playDestroyLandingAnvilSound(world, pos, SoundEvents.BLOCK_COPPER_PLACE);
    }

    @Nullable
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new CopperAnvilScreenHandler(
                this.getForgeSound(),
                this.getBreakSound(),
                this.getChanceBreak(),
                syncId,
                inventory,
                ScreenHandlerContext.create(world, pos)),
                TITLE
        );
    }

    @Override
    public SoundEvent getForgeSound() {
        return SoundEvents.BLOCK_COPPER_PLACE;
    }

    @Override
    public SoundEvent getBreakSound() {
        return SoundEvents.BLOCK_COPPER_PLACE;
    }
}
