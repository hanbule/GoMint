/*
 * Copyright (c) 2018 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.world.biome.component;

public interface Climate {

    /**
     * Get the temperature of this biome
     *
     * @return temperature of this biome
     */
    float temperature();

    /**
     * Get the downfall likely hood of this biome
     *
     * @return downfall likely hood of this biome
     */
    float downfall();

}
