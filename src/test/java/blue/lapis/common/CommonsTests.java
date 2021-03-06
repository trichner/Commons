/*
 * LapisCommons
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package blue.lapis.common;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.event.state.PreInitializationEvent;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public final class CommonsTests {

    public static void mockPlugin() {
        Game gameProxy = mock(Game.class);
        PreInitializationEvent init = mock(PreInitializationEvent.class);
        when(init.getGame()).thenReturn(gameProxy);
        when(init.getPluginLog()).thenReturn(LogManager.getLogger(LapisCommonsPlugin.class));
        new LapisCommonsPlugin().initialize(init);
    }

    public static void mockPlayers(String... players) {
        List<Player> playerList = Lists.newArrayListWithCapacity(players.length);
        for (String name : players) {
            Player player = mock(Player.class);
            when(player.getName()).thenReturn(name);
            playerList.add(player);
        }

        when(LapisCommonsPlugin.getGame().getOnlinePlayers()).thenReturn(ImmutableList.copyOf(playerList));
    }
}
